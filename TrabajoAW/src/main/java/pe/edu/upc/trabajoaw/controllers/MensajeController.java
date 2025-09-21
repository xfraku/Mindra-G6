package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.MensajeDTO;
import pe.edu.upc.trabajoaw.entities.Mensaje;
import pe.edu.upc.trabajoaw.servicesinterfaces.IMensajeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {

    @Autowired
    private IMensajeService service;

    @GetMapping("/listar")
    public List<MensajeDTO> listarMensaje(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,MensajeDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void insertar(@RequestBody MensajeDTO dto){
        ModelMapper m = new ModelMapper();
        Mensaje entity=m.map(dto,Mensaje.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Mensaje entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        MensajeDTO dto=m.map(entity,MensajeDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Mensaje entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody MensajeDTO dto){
        ModelMapper m = new ModelMapper();
        Mensaje entity=m.map(dto,Mensaje.class);
        Mensaje existente = service.listId(entity.getIdMensaje());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdMensaje());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdMensaje() + "modificado correctamente");
    }

}
