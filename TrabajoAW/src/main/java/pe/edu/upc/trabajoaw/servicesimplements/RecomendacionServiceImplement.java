package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Recomendacion;
import pe.edu.upc.trabajoaw.repositories.IRecomendacionRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IRecomendacionService;

import java.util.List;

@Service
public class RecomendacionServiceImplement implements IRecomendacionService {

    @Autowired
    private IRecomendacionRepository repository;

    @Override
    public List<Recomendacion> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Recomendacion r) {
        repository.save(r);
    }

    @Override
    public Recomendacion listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Recomendacion r) {
        repository.save(r);
    }
}
