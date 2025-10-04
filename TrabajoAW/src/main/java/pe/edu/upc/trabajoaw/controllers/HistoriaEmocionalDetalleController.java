package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.HistoriaEmocionalDetalleDTO;
import pe.edu.upc.trabajoaw.entities.HistoriaEmocionalDetalle;
import pe.edu.upc.trabajoaw.servicesinterfaces.IHistoriaEmocionalDetalleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historia-emocional-detalle")
public class HistoriaEmocionalDetalleController {

    @Autowired
    private IHistoriaEmocionalDetalleService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public List<HistoriaEmocionalDetalleDTO> listar() {
        ModelMapper m = new ModelMapper();
        return service.list().stream().map(e -> m.map(e, HistoriaEmocionalDetalleDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public void insertar(@RequestBody HistoriaEmocionalDetalleDTO dto) {
        ModelMapper m = new ModelMapper();
        HistoriaEmocionalDetalle entity = m.map(dto, HistoriaEmocionalDetalle.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<?> listarId(@PathVariable int id) {
        HistoriaEmocionalDetalle entity = service.listId(id);
        if (entity == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe detalle con ID " + id);
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(entity, HistoriaEmocionalDetalleDTO.class));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        if (service.listId(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe detalle con ID " + id);
        service.delete(id);
        return ResponseEntity.ok("Detalle eliminado: " + id);
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> modificar(@RequestBody HistoriaEmocionalDetalleDTO dto) {
        ModelMapper m = new ModelMapper();
        HistoriaEmocionalDetalle entity = m.map(dto, HistoriaEmocionalDetalle.class);
        if (service.listId(entity.getIdHistoriaEmocionalDetalle()) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe detalle con ID " + entity.getIdHistoriaEmocionalDetalle());
        service.edit(entity);
        return ResponseEntity.ok("Detalle modificado: " + entity.getIdHistoriaEmocionalDetalle());
    }

    @GetMapping("/historial/{idHistorial}")
    public List<HistoriaEmocionalDetalleDTO> listarPorHistorial(@PathVariable int idHistorial) {
        ModelMapper m = new ModelMapper();
        return service.listarPorHistorial(idHistorial).stream()
                .map(e -> m.map(e, HistoriaEmocionalDetalleDTO.class))
                .collect(Collectors.toList());
    }
}