package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.EjercicioRelajacion;
import pe.edu.upc.trabajoaw.repositories.IEjercicioRelajacionRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IEjercicioRelajacionService;

import java.util.List;
@Service
public class EjercicioRelajacionServiceImplement implements IEjercicioRelajacionService {

    @Autowired
    private IEjercicioRelajacionRepository repository;

    @Override
    public List<EjercicioRelajacion> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(EjercicioRelajacion e) {
        repository.save(e);
    }

    @Override
    public EjercicioRelajacion listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(EjercicioRelajacion e) {
        repository.save(e);
    }

}
