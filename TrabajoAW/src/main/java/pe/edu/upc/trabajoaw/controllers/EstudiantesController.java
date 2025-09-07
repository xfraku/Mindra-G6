package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
}
