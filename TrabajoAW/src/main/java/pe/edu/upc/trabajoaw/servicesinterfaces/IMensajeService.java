package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Mensaje;

import java.util.List;

public interface IMensajeService {
    List<Mensaje> list();
    void insertar(Mensaje m);
    Mensaje listId(int id);
    void delete(int id);
    void edit(Mensaje m);

}
