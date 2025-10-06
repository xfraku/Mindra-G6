package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Sonido;
import pe.edu.upc.trabajoaw.repositories.ISonidoRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.ISonidoService;

import java.util.List;

@Service
public class SonidoServiceImplement implements ISonidoService {

    @Autowired
    private ISonidoRepository repository;

    @Override
    public List<Sonido> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Sonido s) {
        repository.save(s);
    }

    @Override
    public Sonido listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Sonido s) {
        repository.save(s);
    }
}