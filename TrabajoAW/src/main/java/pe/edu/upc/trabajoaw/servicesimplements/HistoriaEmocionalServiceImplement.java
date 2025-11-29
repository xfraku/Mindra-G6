package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.HistoriaEmocional;
import pe.edu.upc.trabajoaw.repositories.IHistoriaEmocionalRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IHistoriaEmocionalService;

import java.util.List;

@Service
public class HistoriaEmocionalServiceImplement implements IHistoriaEmocionalService {

    @Autowired
    private IHistoriaEmocionalRepository repository;

    @Override
    public List<HistoriaEmocional> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(HistoriaEmocional h) {
        repository.save(h);
    }

    @Override
    public HistoriaEmocional listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(HistoriaEmocional h) {
        repository.save(h);
    }
}