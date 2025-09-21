package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.FraseMotivacional;
import pe.edu.upc.trabajoaw.repositories.IFraseMotivacionalRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IFraseMotivacionalService;

import java.util.List;
import java.util.Optional;
@Service
public class FraseMotivacionalServiceImplement implements IFraseMotivacionalService {

    @Autowired
    private IFraseMotivacionalRepository repository;


    @Override
    public List<FraseMotivacional> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(FraseMotivacional f) {
        repository.save(f);
    }

    @Override
    public FraseMotivacional listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(FraseMotivacional f) {
        repository.save(f);
    }

}
