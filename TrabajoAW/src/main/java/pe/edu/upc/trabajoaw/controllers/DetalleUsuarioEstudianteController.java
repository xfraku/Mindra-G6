package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.DetalleUsuarioEstudianteDTO;
import pe.edu.upc.trabajoaw.entities.DetalleUsuarioEstudiante;
import pe.edu.upc.trabajoaw.servicesinterfaces.IDetalleUsuarioEstudianteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalle-estudiante")
public class DetalleUsuarioEstudianteController {

    @Autowired
    private IDetalleUsuarioEstudianteService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','APODERADO','ESPECIALISTA')")
    public List<DetalleUsuarioEstudianteDTO> listar() {
        return service.list().stream().map(e -> {
            ModelMapper m = new ModelMapper();
            return m.map(e, DetalleUsuarioEstudianteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','APODERADO','ESPECIALISTA')")
    public void insertar(@RequestBody DetalleUsuarioEstudianteDTO dto) {
        ModelMapper m = new ModelMapper();
        DetalleUsuarioEstudiante entity = m.map(dto, DetalleUsuarioEstudiante.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','APODERADO','ESPECIALISTA')")
    public ResponseEntity<?> listarId(@PathVariable int id) {
        DetalleUsuarioEstudiante entity = service.listId(id);
        if (entity == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe detalle con ID " + id);
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(entity, DetalleUsuarioEstudianteDTO.class));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','APODERADO','ESPECIALISTA')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        if (service.listId(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe detalle con ID " + id);
        service.delete(id);
        return ResponseEntity.ok("Detalle eliminado: " + id);
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE','APODERADO','ESPECIALISTA')")
    public ResponseEntity<String> modificar(@RequestBody DetalleUsuarioEstudianteDTO dto) {
        ModelMapper m = new ModelMapper();
        DetalleUsuarioEstudiante entity = m.map(dto, DetalleUsuarioEstudiante.class);
        if (service.listId(entity.getIdDetalle()) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe detalle con ID " + entity.getIdDetalle());
        service.edit(entity);
        return ResponseEntity.ok("Detalle modificado: " + entity.getIdDetalle());
    }
}