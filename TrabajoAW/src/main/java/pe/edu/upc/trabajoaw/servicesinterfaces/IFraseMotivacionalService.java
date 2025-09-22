package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.FraseMotivacional;

import java.util.List;
import java.util.Optional;

public interface IFraseMotivacionalService {
    List<FraseMotivacional> list();
    void insertar(FraseMotivacional f);
    FraseMotivacional listId(int id);
    void delete(int id);
    void edit(FraseMotivacional f);
}
