package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.BloqueoDTO;
import pe.edu.upc.trabajoaw.entities.Bloqueo;
import pe.edu.upc.trabajoaw.servicesinterfaces.IBloqueoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bloqueo")
public class BloqueoController {
    @Autowired
    private IBloqueoService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ADMIN','ESPECIALISTA')")
    public List<BloqueoDTO> listarBloqueo(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,BloqueoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyRole('ADMIN','ESPECIALISTA')")
    public void insertar(@RequestBody BloqueoDTO dto){
        ModelMapper m = new ModelMapper();
        Bloqueo entity = m.map(dto,Bloqueo.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ESPECIALISTA')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Bloqueo entity = service.listId(id);
        if(entity == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        BloqueoDTO dto=m.map(entity,BloqueoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ESPECIALISTA')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Bloqueo entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyRole('ADMIN','ESPECIALISTA')")
    public ResponseEntity<String> modificar(@RequestBody BloqueoDTO dto){
        ModelMapper m = new ModelMapper();
        Bloqueo entity=m.map(dto,Bloqueo.class);
        Bloqueo existente = service.listId(entity.getIdBloqueo());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + entity.getIdBloqueo());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdBloqueo() + "modificado correctamente");
    }

}
