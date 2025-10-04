package pe.edu.upc.trabajoaw.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoaw.dtos.PlaylistDTO;
import pe.edu.upc.trabajoaw.entities.Playlist;
import pe.edu.upc.trabajoaw.servicesinterfaces.IPlaylistService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private IPlaylistService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public List<PlaylistDTO> listar() {
        ModelMapper m = new ModelMapper();
        return service.list().stream().map(e -> m.map(e, PlaylistDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/nuevo")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public void insertar(@RequestBody PlaylistDTO dto) {
        ModelMapper m = new ModelMapper();
        service.insertar(m.map(dto, Playlist.class));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<?> listarId(@PathVariable int id) {
        Playlist entity = service.listId(id);
        if (entity == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Playlist con ID " + id);
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(entity, PlaylistDTO.class));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        if (service.listId(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Playlist con ID " + id);
        service.delete(id);
        return ResponseEntity.ok("Playlist eliminada: " + id);
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROFESOR','PADRE')")
    public ResponseEntity<String> modificar(@RequestBody PlaylistDTO dto) {
        ModelMapper m = new ModelMapper();
        Playlist entity = m.map(dto, Playlist.class);
        if (service.listId(entity.getIdPlaylist()) == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe Playlist con ID " + entity.getIdPlaylist());
        service.edit(entity);
        return ResponseEntity.ok("Playlist modificada: " + entity.getIdPlaylist());
    }
}