package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Bloqueo;

import java.util.List;
import java.util.Optional;

public interface IBloqueoService {
    List<Bloqueo> list();
    void insertar(Bloqueo b);
    Bloqueo listId(int id);
    void delete(int id);
    void edit(Bloqueo b);
}
