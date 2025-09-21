package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Recordatorio;
import pe.edu.upc.trabajoaw.repositories.IRecordatorioRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IRecordatorioService;

import java.util.List;

@Service
public class RecordatorioServiceImplement implements IRecordatorioService {

    @Autowired
    private IRecordatorioRepository repository;

    @Override
    public List<Recordatorio> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Recordatorio r) {
        repository.save(r);
    }

    @Override
    public Recordatorio listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Recordatorio r) {
        repository.save(r);
    }
}
