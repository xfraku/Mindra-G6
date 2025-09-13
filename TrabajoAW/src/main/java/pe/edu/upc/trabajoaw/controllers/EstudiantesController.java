package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.EstudiantesDTO;
import pe.edu.upc.trabajoaw.entities.Estudiantes;
import pe.edu.upc.trabajoaw.servicesinterfaces.IEstudiantesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {
    @Autowired
    private IEstudiantesService service;

    @GetMapping
    public List<EstudiantesDTO> listarEstudiantes(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,EstudiantesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EstudiantesDTO dto){
        ModelMapper m = new ModelMapper();
        Estudiantes estu=m.map(dto,Estudiantes.class);
        service.insert(estu);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Estudiantes estu = service.listId(id);
        if(estu == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        EstudiantesDTO dto=m.map(estu,EstudiantesDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Estudiantes estu = service.listId(id);
        if (estu == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody EstudiantesDTO dto){
        ModelMapper m = new ModelMapper();
        Estudiantes estu=m.map(dto,Estudiantes.class);
        Estudiantes existente = service.listId(estu.getIdUsuario());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + estu.getIdUsuario());
        }
        service.edit(estu);
        return ResponseEntity.ok("Registro con ID " +  estu.getIdUsuario() + "modificado correctamente");
    }

    @GetMapping("/busquedas")
    public ResponseEntity<?> buscar(@RequestParam String centroEstudiantes){
        List<Estudiantes> estudiantes = service.buscarCentro(centroEstudiantes);
        if(estudiantes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron proveedores: " + centroEstudiantes);
        }
        List<EstudiantesDTO> listaDTO = estudiantes.stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,EstudiantesDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
