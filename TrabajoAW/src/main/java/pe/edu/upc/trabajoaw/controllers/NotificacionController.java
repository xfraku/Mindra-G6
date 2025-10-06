package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.NotificacionDTO;
import pe.edu.upc.trabajoaw.entities.Notificacion;
import pe.edu.upc.trabajoaw.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','ESTUDIANTE','APODERADO','ESPECIALISTA')")
    public List<NotificacionDTO> listarNotificacion(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','ESTUDIANTE','APODERADO','ESPECIALISTA')")
    public void insertar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion entity=m.map(dto,Notificacion.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','ESTUDIANTE','APODERADO','ESPECIALISTA')")
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
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','ESTUDIANTE','APODERADO','ESPECIALISTA')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Notificacion entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','ESTUDIANTE','APODERADO','ESPECIALISTA')")
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
}