package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Playlist;
import pe.edu.upc.trabajoaw.repositories.IPlaylistRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IPlaylistService;

import java.util.List;

@Service
public class PlaylistServiceImplement implements IPlaylistService {

    @Autowired
    private IPlaylistRepository repository;

    @Override
    public List<Playlist> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Playlist p) {
        repository.save(p);
    }

    @Override
    public Playlist listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Playlist p) {
        repository.save(p);
    }
}