package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.PadreDTO;
import pe.edu.upc.trabajoaw.entities.Padre;
import pe.edu.upc.trabajoaw.servicesinterfaces.IPadreService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/padre")
public class PadreController {

    @Autowired
    private IPadreService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE')")
    public List<PadreDTO> listarPadre(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,PadreDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE')")
    public void insertar(@RequestBody PadreDTO dto){
        ModelMapper m = new ModelMapper();
        Padre entity=m.map(dto, Padre.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Padre entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        PadreDTO dto=m.map(entity,PadreDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Padre entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyRole('ADMIN','DOCENTE')")
    public ResponseEntity<String> modificar(@RequestBody PadreDTO dto){
        ModelMapper m = new ModelMapper();
        Padre entity=m.map(dto,Padre.class);
        Padre existente = service.listId(entity.getIdPadre());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdPadre());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdPadre() + "modificado correctamente");
    }
}
