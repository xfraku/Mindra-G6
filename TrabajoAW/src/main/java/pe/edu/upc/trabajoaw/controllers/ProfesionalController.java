package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.ProfesionalDTO;
import pe.edu.upc.trabajoaw.entities.Profesional;
import pe.edu.upc.trabajoaw.servicesinterfaces.IProfesionalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profesional")
public class ProfesionalController {

    @Autowired
    private IProfesionalService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public List<ProfesionalDTO> listarProfesional(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,ProfesionalDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public void insertar(@RequestBody ProfesionalDTO dto){
        ModelMapper m = new ModelMapper();
        Profesional entity=m.map(dto,Profesional.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Profesional entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        ProfesionalDTO dto=m.map(entity,ProfesionalDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Profesional entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> modificar(@RequestBody ProfesionalDTO dto){
        ModelMapper m = new ModelMapper();
        Profesional entity=m.map(dto,Profesional.class);
        Profesional existente = service.listId(entity.getIdProfesional());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdProfesional());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdProfesional() + "modificado correctamente");
    }
}
