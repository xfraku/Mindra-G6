package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.SitiosWeb;
import pe.edu.upc.trabajoaw.repositories.ISitiosWebRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.ISitiosWebService;

import java.util.List;

@Service
public class SitiosWebServiceImplement implements ISitiosWebService {

    @Autowired
    private ISitiosWebRepository repository;

    @Override
    public List<SitiosWeb> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(SitiosWeb s) {
        repository.save(s);
    }

    @Override
    public SitiosWeb listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(SitiosWeb s) {
        repository.save(s);
    }
}
