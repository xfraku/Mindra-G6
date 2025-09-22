package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.AlertaDTO;
import pe.edu.upc.trabajoaw.entities.Alerta;
import pe.edu.upc.trabajoaw.servicesinterfaces.IAlertaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private IAlertaService service;

    @GetMapping("/listar")
    public List<AlertaDTO> listar() {
        return service.list().stream().map(e -> {
            ModelMapper m = new ModelMapper();
            return m.map(e, AlertaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void insertar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alerta entity = m.map(dto, Alerta.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable int id) {
        Alerta entity = service.listId(id);
        if (entity == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Alerta con ID " + id);
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(entity, AlertaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        if (service.listId(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Alerta con ID " + id);
        service.delete(id);
        return ResponseEntity.ok("Alerta eliminada: " + id);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alerta entity = m.map(dto, Alerta.class);
        if (service.listId(entity.getIdAlerta()) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Alerta con ID " + entity.getIdAlerta());
        service.edit(entity);
        return ResponseEntity.ok("Alerta modificada: " + entity.getIdAlerta());
    }

}
