package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Estudiantes;
import pe.edu.upc.trabajoaw.repositories.IEstudiantesRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IEstudiantesService;

import java.util.List;

@Service
public class EstudiantesServiceImplement implements IEstudiantesService {
    @Autowired
    private IEstudiantesRepository repository;

    @Override
    public List<Estudiantes> list(){
        return repository.findAll();
    }

    @Override
    public void insert(Estudiantes e){
        repository.save(e);
    }

    @Override
    public Estudiantes listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
    repository.deleteById(id);
    }

    @Override
    public void edit(Estudiantes e) {
    repository.save(e);
    }

    @Override
    public List<Estudiantes> buscarCentro(String centroEstudiante) {
        return repository.buscar(centroEstudiante);
    }
}
