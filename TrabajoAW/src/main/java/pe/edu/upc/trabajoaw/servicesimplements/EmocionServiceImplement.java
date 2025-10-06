package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Emocion;
import pe.edu.upc.trabajoaw.repositories.IEmocionRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IEmocionService;

import java.util.List;

@Service
public class EmocionServiceImplement implements IEmocionService {

    @Autowired
    private IEmocionRepository repository;


    @Override
    public List<Emocion> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Emocion e) {
        repository.save(e);
    }

    @Override
    public Emocion listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Emocion e) {
        repository.save(e);
    }

}
