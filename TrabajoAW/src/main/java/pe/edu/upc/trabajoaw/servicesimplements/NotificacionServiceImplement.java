package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.Notificacion;
import pe.edu.upc.trabajoaw.repositories.INotificacionRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.INotificacionService;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {

    @Autowired
    private INotificacionRepository repository;

    @Override
    public List<Notificacion> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(Notificacion n) {
        repository.save(n);
    }

    @Override
    public Notificacion listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Notificacion n) {
        repository.save(n);
    }
}
