package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.VisitasDTO;
import pe.edu.upc.trabajoaw.entities.Visitas;
import pe.edu.upc.trabajoaw.servicesinterfaces.IVisitasServices;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/visitas")
public class VisitasController {

    @Autowired
    private IVisitasServices service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<VisitasDTO> listarVisitas(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,VisitasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void insertar(@RequestBody VisitasDTO dto){
        ModelMapper m = new ModelMapper();
        Visitas entity=m.map(dto,Visitas.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Visitas entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        VisitasDTO dto=m.map(entity,VisitasDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Visitas entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody VisitasDTO dto){
        ModelMapper m = new ModelMapper();
        Visitas entity=m.map(dto,Visitas.class);
        Visitas existente = service.listId(entity.getIdVisita());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdVisita());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdVisita() + "modificado correctamente");
    }
}