package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.VisitasDTO;
import pe.edu.upc.trabajoaw.entities.SitiosWeb;
import pe.edu.upc.trabajoaw.entities.Usuario;
import pe.edu.upc.trabajoaw.entities.Visitas;
import pe.edu.upc.trabajoaw.servicesinterfaces.ISitiosWebService;
import pe.edu.upc.trabajoaw.servicesinterfaces.IUsuarioService;
import pe.edu.upc.trabajoaw.servicesinterfaces.IVisitasServices;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/visitas")
public class VisitasController {

    @Autowired
    private IVisitasServices service;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ISitiosWebService sitiosWebService;

    @GetMapping("/listar")
    @PreAuthorize("permitAll()")
    public List<VisitasDTO> listarVisitas(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,VisitasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("permitAll()")
    public void insertar(@RequestBody VisitasDTO dto){
        Visitas visita = new Visitas();

        visita.setFechaEntrada(dto.getFechaEntrada());
        visita.setFechaSalida(dto.getFechaSalida());

        Usuario usuario = usuarioService.listId(dto.getIdUsuario());
        SitiosWeb sitioWeb = sitiosWebService.listId(dto.getIdSitioWeb());

        visita.setUsuario(usuario);
        visita.setSitiosWeb(sitioWeb);

        service.insertar(visita);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Visitas entity = service.listId(id);
        if(entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        VisitasDTO dto=m.map(entity,VisitasDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id){
        Visitas entity = service.listId(id);
        if (entity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID:" + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado correctamente");
    }

    @PutMapping("/modificar")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> modificar(@RequestBody VisitasDTO dto){
        Visitas visita = service.listId(dto.getIdVisita());

        if (visita == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dto.getIdVisita());
        }

        visita.setFechaEntrada(dto.getFechaEntrada());
        visita.setFechaSalida(dto.getFechaSalida());

        Usuario usuario = usuarioService.listId(dto.getIdUsuario());
        SitiosWeb sitioWeb = sitiosWebService.listId(dto.getIdSitioWeb());

        visita.setUsuario(usuario);
        visita.setSitiosWeb(sitioWeb);

        service.edit(visita);

        return ResponseEntity.ok("Registro con ID " + dto.getIdVisita() + " modificado correctamente");
    }
}
