package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.EstudiantesDTO;
import pe.edu.upc.trabajoaw.dtos.UsuarioDTO;
import pe.edu.upc.trabajoaw.entities.Usuario;
import pe.edu.upc.trabajoaw.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuario(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    public void insertar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario usu=m.map(dto,Usuario.class);
        service.insertar(usu);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Usuario usu = service.listId(id);
        if(usu == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto=m.map(usu,UsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Usuario usu = service.listId(id);
        if (usu == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody EstudiantesDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario usu=m.map(dto,Usuario.class);
        Usuario existente = service.listId(usu.getIdUsuario());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + usu.getIdUsuario());
        }
        service.edit(usu);
        return ResponseEntity.ok("Registro con ID " +  usu.getIdUsuario() + "modificado correctamente");
    }
}
