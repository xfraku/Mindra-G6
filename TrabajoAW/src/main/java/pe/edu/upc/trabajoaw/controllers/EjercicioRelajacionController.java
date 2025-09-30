package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.EjercicioRelajacionDTO;
import pe.edu.upc.trabajoaw.dtos.EjerciciosRelajacionTopDTO;
import pe.edu.upc.trabajoaw.entities.EjercicioRelajacion;
import pe.edu.upc.trabajoaw.servicesinterfaces.IEjercicioRelajacionService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ejercicio-relajacion")
public class EjercicioRelajacionController {

    @Autowired
    private IEjercicioRelajacionService service;

    @GetMapping("/listar")
    public List<EjercicioRelajacionDTO> listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,EjercicioRelajacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void insertar(@RequestBody EjercicioRelajacionDTO dto){
        ModelMapper m = new ModelMapper();
        EjercicioRelajacion entity=m.map(dto,EjercicioRelajacion.class);
        service.insertar(entity);
    }

    @GetMapping("/{id}")
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
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        EjercicioRelajacion entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
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

    @GetMapping("/topEjeciciosUsados")
    public ResponseEntity<?> topEjeciciosUsados() {
        List<String[]> ejercicios=service.ejerciciosRelajacionTop();
        List<EjerciciosRelajacionTopDTO> listaMontos=new ArrayList<>();
        if (ejercicios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron proveedores registrados ");
        }
        for(String[] columna:ejercicios){
            EjerciciosRelajacionTopDTO dto=new EjerciciosRelajacionTopDTO();
            dto.setTitulo(columna[0]);
            dto.setDescripcion(columna[1]);
            dto.setTotal_usos(Integer.parseInt(columna[2]));
            listaMontos.add(dto);
        }
        return ResponseEntity.ok(listaMontos);
    }
}
