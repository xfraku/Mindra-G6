package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.DuracionPromedioSitioDTO;
import pe.edu.upc.trabajoaw.dtos.SitiosWebDTO;
import pe.edu.upc.trabajoaw.entities.SitiosWeb;
import pe.edu.upc.trabajoaw.servicesinterfaces.ISitiosWebService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// ... existing code ...
@RestController
@RequestMapping("/sitiosweb")
public class SitioWebController {

    @Autowired
    private ISitiosWebService service;

    @GetMapping("/listar")
    @PreAuthorize("permitAll()")
    public List<SitiosWebDTO> listarSitiosWeb(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,SitiosWebDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("permitAll()")
    public void insertar(@RequestBody SitiosWebDTO dto){
        ModelMapper m = new ModelMapper();
        SitiosWeb entity=m.map(dto, SitiosWeb.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        SitiosWeb entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        SitiosWebDTO dto=m.map(entity,SitiosWebDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        SitiosWeb entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> modificar(@RequestBody SitiosWebDTO dto){
        ModelMapper m = new ModelMapper();
        SitiosWeb entity=m.map(dto,SitiosWeb.class);
        SitiosWeb existente = service.listId(entity.getIdSitioWeb());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdSitioWeb());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdSitioWeb() + "modificado correctamente");
    }
}