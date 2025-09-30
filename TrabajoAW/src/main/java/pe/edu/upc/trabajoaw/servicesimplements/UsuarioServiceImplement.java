package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Usuario;
import pe.edu.upc.trabajoaw.repositories.IUsuarioRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public List<Usuario> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Usuario u) {
        repository.save(u);
    }

    @Override
    public Usuario listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Usuario u) {
        repository.save(u);
    }

    @Override
    public List<String[]> tiempoSitiosDistractoresUsuario(int idUsuario) {
        return repository.tiempoSitiosDistractoresUsuario(idUsuario);
    }
}
