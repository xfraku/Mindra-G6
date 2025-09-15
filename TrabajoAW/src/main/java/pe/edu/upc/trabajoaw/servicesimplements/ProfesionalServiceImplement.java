package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Profesional;
import pe.edu.upc.trabajoaw.repositories.IProfesionalRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IProfesionalService;

import java.util.List;

@Service
public class ProfesionalServiceImplement implements IProfesionalService {

    @Autowired
    private IProfesionalRepository repository;

    @Override
    public List<Profesional> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Profesional prof) {
        repository.save(prof);
    }

    @Override
    public Profesional listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Profesional prof) {
        repository.save(prof);
    }
}
