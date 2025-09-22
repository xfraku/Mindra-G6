package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Alerta;

import java.util.List;
import java.util.Optional;

public interface IAlertaService {
    List<Alerta> list();
    void insertar(Alerta a);
    Alerta listId(int id);
    void delete(int id);
    void edit(Alerta a);
}
