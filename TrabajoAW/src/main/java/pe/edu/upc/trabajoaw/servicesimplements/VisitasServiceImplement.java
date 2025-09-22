package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Visitas;
import pe.edu.upc.trabajoaw.repositories.IVisitasRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IVisitasServices;

import java.util.List;

@Service
public class VisitasServiceImplement implements IVisitasServices {

    @Autowired
    private IVisitasRepository repository;

    @Override
    public List<Visitas> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Visitas v) {
        repository.save(v);
    }

    @Override
    public Visitas listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Visitas v) {
        repository.save(v);
    }

}
