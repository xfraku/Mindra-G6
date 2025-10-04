package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.SonidoDTO;
import pe.edu.upc.trabajoaw.entities.Sonido;
import pe.edu.upc.trabajoaw.servicesinterfaces.ISonidoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sonidos")
public class SonidoController {

    @Autowired
    private ISonidoService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public List<SonidoDTO> listar() {
        ModelMapper m = new ModelMapper();
        return service.list().stream().map(e -> m.map(e, SonidoDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public void insertar(@RequestBody SonidoDTO dto) {
        ModelMapper m = new ModelMapper();
        service.insertar(m.map(dto, Sonido.class));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<?> listarId(@PathVariable int id) {
        Sonido entity = service.listId(id);
        if (entity == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Sonido con ID " + id);
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(entity, SonidoDTO.class));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        if (service.listId(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Sonido con ID " + id);
        service.delete(id);
        return ResponseEntity.ok("Sonido eliminado: " + id);
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> modificar(@RequestBody SonidoDTO dto) {
        ModelMapper m = new ModelMapper();
        Sonido entity = m.map(dto, Sonido.class);
        if (service.listId(entity.getIdSonido()) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Sonido con ID " + entity.getIdSonido());
        service.edit(entity);
        return ResponseEntity.ok("Sonido modificado: " + entity.getIdSonido());
    }
}