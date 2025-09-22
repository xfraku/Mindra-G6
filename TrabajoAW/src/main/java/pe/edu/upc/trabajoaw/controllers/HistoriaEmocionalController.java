package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.HistoriaEmocionalDTO;
import pe.edu.upc.trabajoaw.entities.HistoriaEmocional;
import pe.edu.upc.trabajoaw.servicesinterfaces.IHistoriaEmocionalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historia-emocional")
public class HistoriaEmocionalController {

    @Autowired
    private IHistoriaEmocionalService service;

    @GetMapping("/listar")
    public List<HistoriaEmocionalDTO> listarHistoria(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,HistoriaEmocionalDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void insertar(@RequestBody HistoriaEmocionalDTO dto){
        ModelMapper m = new ModelMapper();
        HistoriaEmocional entity=m.map(dto,HistoriaEmocional.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        HistoriaEmocional entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        HistoriaEmocionalDTO dto=m.map(entity,HistoriaEmocionalDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        HistoriaEmocional entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody HistoriaEmocionalDTO dto){
        ModelMapper m = new ModelMapper();
        HistoriaEmocional entity=m.map(dto,HistoriaEmocional.class);
        HistoriaEmocional existente = service.listId(entity.getIdHistoriaEmocional());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdHistoriaEmocional());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdHistoriaEmocional() + "modificado correctamente");
    }
}
