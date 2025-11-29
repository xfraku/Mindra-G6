package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.TiempoDistraccionUsuarioDTO;
import pe.edu.upc.trabajoaw.dtos.TiempoProductivoUsuarioDTO;
import pe.edu.upc.trabajoaw.dtos.UsuarioDTO;
import pe.edu.upc.trabajoaw.entities.Usuario;
import pe.edu.upc.trabajoaw.servicesinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioDTO> listarUsuario(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario usu=m.map(dto,Usuario.class);
        service.insertar(usu);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Usuario usu = service.listId(id);
        if(usu == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto=m.map(usu,UsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Usuario usu = service.listId(id);
        if (usu == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario usu=m.map(dto,Usuario.class);
        Usuario existente = service.listId(usu.getIdUsuario());
        if (existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar. No existe un registro con el ID: " + usu.getIdUsuario());
        }
        service.edit(usu);
        return ResponseEntity.ok("Registro con ID " +  usu.getIdUsuario() + " modificado correctamente");
    }

    @GetMapping("/totalTiempoDistraccionUsuario")
    public ResponseEntity<?> totalTiempoDistraccionUsuario(@RequestParam int idUsuario) {
        List<String[]> total=service.tiempoSitiosDistractoresUsuario(idUsuario);
        List<TiempoDistraccionUsuarioDTO> listaTotal=new ArrayList<>();
        if (total.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron proveedores registrados ");
        }
        for(String[] columna:total){
            TiempoDistraccionUsuarioDTO dto=new TiempoDistraccionUsuarioDTO();
            dto.setIdUsuario(Integer.getInteger(columna[0]));
            dto.setNombre(columna[1]);
            dto.setTiempo_total(Integer.parseInt(columna[2]));
            listaTotal.add(dto);
        }
        return ResponseEntity.ok(listaTotal);
    }

    @GetMapping("/tiempoProductivoUsuario")
    @PreAuthorize("hasAnyAuthority('ADMIN','ESTUDIANTE')")
    public ResponseEntity<?> tiempoProductivoUsuario(@RequestParam int idUsuario) {
        List<String[]> total=service.tiempoProductivoUsuario(idUsuario);
        List<TiempoProductivoUsuarioDTO> listaTotal=new ArrayList<>();
        if (total.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios registrados con tiempo productivo");
        }
        for(String[] columna:total){
            TiempoProductivoUsuarioDTO dto=new TiempoProductivoUsuarioDTO();
            dto.setIdUsuario(Integer.getInteger(columna[0]));
            dto.setNombre(columna[1]);
            dto.setApellido(columna[2]);
            dto.setTiempo_total_minutos(Integer.parseInt(columna[3]));
            listaTotal.add(dto);
        }
        return ResponseEntity.ok(listaTotal);
    }
}