package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.FraseMotivacionalDTO;
import pe.edu.upc.trabajoaw.entities.FraseMotivacional;
import pe.edu.upc.trabajoaw.servicesinterfaces.IFraseMotivacionalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/frase-motivacional")
public class FraseMotivacionalController {

    @Autowired
    private IFraseMotivacionalService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCENTE','ESTUDIANTE','ESPECIALISTA')")
    public List<FraseMotivacionalDTO> listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,FraseMotivacionalDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCENTE','ESTUDIANTE','ESPECIALISTA')")
    public void insertar(@RequestBody FraseMotivacionalDTO dto){
        ModelMapper m = new ModelMapper();
        FraseMotivacional entity=m.map(dto,FraseMotivacional.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCENTE','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        FraseMotivacional entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        FraseMotivacionalDTO dto=m.map(entity,FraseMotivacionalDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCENTE','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        FraseMotivacional entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCENTE','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<String> modificar(@RequestBody FraseMotivacionalDTO dto){
        ModelMapper m = new ModelMapper();
        FraseMotivacional entity=m.map(dto,FraseMotivacional.class);
        FraseMotivacional existente = service.listId(entity.getIdFraseMotivacional());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdFraseMotivacional());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdFraseMotivacional() + "modificado correctamente");
    }
}
