package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Emocion;

import java.util.List;

public interface IEmocionService {
    List<Emocion> list();
    void insertar(Emocion e);
    Emocion listId(int id);
    void delete(int id);
    void edit(Emocion e);

}
