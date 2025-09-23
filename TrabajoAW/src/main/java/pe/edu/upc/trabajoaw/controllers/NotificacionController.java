package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.ListarNotificacionesDTO;
import pe.edu.upc.trabajoaw.dtos.NotificacionDTO;
import pe.edu.upc.trabajoaw.entities.Notificacion;
import pe.edu.upc.trabajoaw.servicesinterfaces.INotificacionService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService service;

    @GetMapping("/listar")
    public List<NotificacionDTO> listarNotificacion(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void insertar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion entity=m.map(dto,Notificacion.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Notificacion entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto=m.map(entity,NotificacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Notificacion entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente");
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion entity=m.map(dto,Notificacion.class);
        Notificacion existente = service.listId(entity.getIdNotificacion());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdNotificacion());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdNotificacion() + " modificado correctamente");
    }

    // Mantiene el listado especial basado en el query nativo existente
    @GetMapping("/sin-profesional")
    public ResponseEntity<?> listarSinProfesionalAsignado() {
        List<Object[]> filas = service.listarNotificacionessinprofesionalasignado();
        List<ListarNotificacionesDTO> resultado = new ArrayList<>();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron notificaciones sin profesional asignado");
        }
        for (Object[] c : filas) {
            ListarNotificacionesDTO dto = new ListarNotificacionesDTO();
            dto.setIdNotificacion(toInteger(c[0]) != null ? toInteger(c[0]) : 0);
            dto.setProblema(c[1] != null ? c[1].toString() : null);
            dto.setFecha(toInstant(c[2]));
            dto.setIdEstudiantes(toInteger(c[3]));
            dto.setIdPadre(toInteger(c[4]));
            dto.setIdProfesional(toInteger(c[5]));
            resultado.add(dto);
        }
        return ResponseEntity.ok(resultado);
    }

    private Integer toInteger(Object o) {
        if (o == null) return null;
        if (o instanceof Number n) return n.intValue();
        if (o instanceof String s) { try { return Integer.parseInt(s); } catch (NumberFormatException ignored) {} }
        return null;
    }

    private Instant toInstant(Object o) {
        if (o == null) return null;
        if (o instanceof Instant i) return i;
        if (o instanceof java.sql.Timestamp ts) return ts.toInstant();
        if (o instanceof LocalDateTime ldt) return ldt.toInstant(ZoneOffset.UTC);
        if (o instanceof String s) { try { return Instant.parse(s); } catch (Exception ignored) {} }
        return null;
    }
}