package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.RecomendacionDTO;
import pe.edu.upc.trabajoaw.entities.Recomendacion;
import pe.edu.upc.trabajoaw.servicesinterfaces.IRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendacion")
public class RecomendacionController {

    @Autowired
    private IRecomendacionService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN','ESPECIALISTA','ESTUDIANTE')")
    public List<RecomendacionDTO> listarRecomendacion(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyAuthority('ADMIN','ESPECIALISTA','ESTUDIANTE')")
    public void insertar(@RequestBody RecomendacionDTO dto){
        ModelMapper m = new ModelMapper();
        Recomendacion entity=m.map(dto,Recomendacion.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','ESPECIALISTA','ESTUDIANTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Recomendacion entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        RecomendacionDTO dto=m.map(entity,RecomendacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','ESPECIALISTA','ESTUDIANTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Recomendacion entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN','ESPECIALISTA','ESTUDIANTE')")
    public ResponseEntity<String> modificar(@RequestBody RecomendacionDTO dto){
        ModelMapper m = new ModelMapper();
        Recomendacion entity=m.map(dto,Recomendacion.class);
        Recomendacion existente = service.listId(entity.getIdRecomendacion());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdRecomendacion());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdRecomendacion() + "modificado correctamente");
    }
}
