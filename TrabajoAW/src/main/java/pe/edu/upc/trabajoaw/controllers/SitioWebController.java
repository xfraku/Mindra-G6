package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.DuracionPromedioSitioDTO;
import pe.edu.upc.trabajoaw.dtos.SitiosWebDTO;
import pe.edu.upc.trabajoaw.entities.SitiosWeb;
import pe.edu.upc.trabajoaw.servicesinterfaces.ISitiosWebService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// ... existing code ...
@RestController
@RequestMapping("/sitiosweb")
public class SitioWebController {

    @Autowired
    private ISitiosWebService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public List<SitiosWebDTO> listarSitiosWeb(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,SitiosWebDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public void insertar(@RequestBody SitiosWebDTO dto){
        ModelMapper m = new ModelMapper();
        SitiosWeb entity=m.map(dto, SitiosWeb.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        SitiosWeb entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        SitiosWebDTO dto=m.map(entity,SitiosWebDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        SitiosWeb entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> modificar(@RequestBody SitiosWebDTO dto){
        ModelMapper m = new ModelMapper();
        SitiosWeb entity=m.map(dto,SitiosWeb.class);
        SitiosWeb existente = service.listId(entity.getIdSitioWeb());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdSitioWeb());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdSitioWeb() + "modificado correctamente");
    }

    // Nuevo endpoint: duración promedio de visitas por sitio web
    @GetMapping("/duracionpromedio")
    public ResponseEntity<?> duracionPromedioPorSitio() {
        List<Object[]> filas = service.duracionPromedioVisitasPorSitio();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros de visitas para calcular la duración promedio");
        }
        List<DuracionPromedioSitioDTO> respuesta = new ArrayList<>();
        for (Object[] c : filas) {
            DuracionPromedioSitioDTO dto = new DuracionPromedioSitioDTO();
            dto.setIdSitioWeb(toInteger(c[0]));
            dto.setNombre(c[1] != null ? c[1].toString() : null);

            // La tercera columna es la duración promedio. Puede venir como BigDecimal, Double, Long, String o algún tipo específico.
            Double segundos = toDouble(c[2]);
            dto.setDuracionPromedioSegundos(segundos);
            dto.setDuracionPromedioHHMMSS(formatSeconds(segundos));

            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }

    private Integer toInteger(Object o) {
        if (o == null) return null;
        if (o instanceof Number n) return n.intValue();
        if (o instanceof String s) {
            try { return Integer.parseInt(s); } catch (NumberFormatException ignored) {}
        }
        return null;
    }

    private Double toDouble(Object o) {
        if (o == null) return null;
        if (o instanceof Number n) return n.doubleValue();
        if (o instanceof String s) {
            try { return Double.parseDouble(s); } catch (NumberFormatException ignored) {}
        }
        // Algunos drivers pueden devolver tipos específicos (p.ej., interval). En tal caso, se puede mapear a String y parsear.
        return null;
    }

    private String formatSeconds(Double seconds) {
        if (seconds == null) return null;
        long total = Math.round(seconds);
        long h = total / 3600;
        long m = (total % 3600) / 60;
        long s = total % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}