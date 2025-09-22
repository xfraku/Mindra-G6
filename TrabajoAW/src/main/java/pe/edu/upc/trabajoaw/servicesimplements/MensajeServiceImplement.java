package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Mensaje;
import pe.edu.upc.trabajoaw.repositories.IMensajeRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IMensajeService;

import java.util.List;

@Service
public class MensajeServiceImplement implements IMensajeService {

    @Autowired
    private IMensajeRepository repository;


    @Override
    public List<Mensaje> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Mensaje m) {
        repository.save(m);
    }

    @Override
    public Mensaje listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Mensaje m) {
        repository.save(m);
    }
}
