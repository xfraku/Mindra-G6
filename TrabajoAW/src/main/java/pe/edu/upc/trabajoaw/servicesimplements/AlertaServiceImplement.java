package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Alerta;
import pe.edu.upc.trabajoaw.repositories.IAlertaRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IAlertaService;

import java.util.List;
@Service
public class AlertaServiceImplement implements IAlertaService {

    @Autowired
    private IAlertaRepository repository;

    @Override
    public List<Alerta> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Alerta a) {
        repository.save(a);
    }

    @Override
    public Alerta listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Alerta a) {
        repository.save(a);
    }

}
