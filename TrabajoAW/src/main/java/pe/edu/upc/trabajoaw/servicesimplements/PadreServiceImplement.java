package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Padre;
import pe.edu.upc.trabajoaw.repositories.IPadreRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IPadreService;

import java.util.List;
@Service
public class PadreServiceImplement implements IPadreService {

    @Autowired
    private IPadreRepository repository;

    @Override
    public List<Padre> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Padre p) {
        repository.save(p);
    }

    @Override
    public Padre listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }

    @Override
    public void edit(Padre u) {
        repository.save(u);
    }
}
