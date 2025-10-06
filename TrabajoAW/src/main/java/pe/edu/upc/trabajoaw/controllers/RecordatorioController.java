package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.RecordatorioDTO;
import pe.edu.upc.trabajoaw.entities.Recordatorio;
import pe.edu.upc.trabajoaw.servicesinterfaces.IRecordatorioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recordatorio")
public class RecordatorioController {

    @Autowired
    private IRecordatorioService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public List<RecordatorioDTO> listarRecordatorio(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,RecordatorioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public void insertar(@RequestBody RecordatorioDTO dto){
        ModelMapper m = new ModelMapper();
        Recordatorio entity=m.map(dto,Recordatorio.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Recordatorio entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        RecordatorioDTO dto=m.map(entity,RecordatorioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Recordatorio entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<String> modificar(@RequestBody RecordatorioDTO dto){
        ModelMapper m = new ModelMapper();
        Recordatorio entity=m.map(dto,Recordatorio.class);
        Recordatorio existente = service.listId(entity.getIdRecordatorio());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdRecordatorio());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdRecordatorio() + "modificado correctamente");
    }
}
