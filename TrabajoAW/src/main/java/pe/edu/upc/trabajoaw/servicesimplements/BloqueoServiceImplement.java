package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Bloqueo;
import pe.edu.upc.trabajoaw.repositories.IBloqueoRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IBloqueoService;

import java.util.List;

@Service
public class BloqueoServiceImplement implements IBloqueoService {

    @Autowired
    private IBloqueoRepository repository;

    @Override
    public List<Bloqueo> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Bloqueo b) {
        repository.save(b);
    }

    @Override
    public Bloqueo listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Bloqueo b) {
        repository.save(b);
    }

}
