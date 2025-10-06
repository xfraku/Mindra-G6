package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.EjercicioRelajacionDTO;
import pe.edu.upc.trabajoaw.entities.EjercicioRelajacion;
import pe.edu.upc.trabajoaw.servicesinterfaces.IEjercicioRelajacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ejercicio-relajacion")
public class EjercicioRelajacionController {

    @Autowired
    private IEjercicioRelajacionService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public List<EjercicioRelajacionDTO> listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,EjercicioRelajacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public void insertar(@RequestBody EjercicioRelajacionDTO dto){
        ModelMapper m = new ModelMapper();
        EjercicioRelajacion entity=m.map(dto,EjercicioRelajacion.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        EjercicioRelajacion entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        EjercicioRelajacionDTO dto=m.map(entity,EjercicioRelajacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        EjercicioRelajacion entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyRole('ADMIN','ESTUDIANTE','ESPECIALISTA')")
    public ResponseEntity<String> modificar(@RequestBody EjercicioRelajacionDTO dto){
        ModelMapper m = new ModelMapper();
        EjercicioRelajacion entity=m.map(dto,EjercicioRelajacion.class);
        EjercicioRelajacion existente = service.listId(entity.getIdEjercicioRelajacion());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + entity.getIdEjercicioRelajacion());
        }
        service.edit(entity);
        return ResponseEntity.ok("Registro con ID " +  entity.getIdEjercicioRelajacion() + "modificado correctamente");
    }
}
