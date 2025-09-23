package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.EmocionDTO;
import pe.edu.upc.trabajoaw.entities.Emocion;
import pe.edu.upc.trabajoaw.servicesinterfaces.IEmocionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/emocion")
public class EmocionController {
    @Autowired
    private IEmocionService service;

    @GetMapping("/listar")
    public List<EmocionDTO> listarEmocion(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,EmocionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void insertar(@RequestBody EmocionDTO dto){
        ModelMapper m = new ModelMapper();
        Emocion entity=m.map(dto,Emocion.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Emocion entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        EmocionDTO dto=m.map(entity,EmocionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Emocion entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody EmocionDTO dto){
        ModelMapper m = new ModelMapper();
        Emocion entity=m.map(dto,Emocion.class);
        Emocion existente = service.listId(entity.getIdEmocion());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdEmocion());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdEmocion() + "modificado correctamente");
    }
}