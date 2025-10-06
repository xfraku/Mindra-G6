package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Sonido;

import java.util.List;

public interface ISonidoService {
    List<Sonido> list();
    void insertar(Sonido s);
    Sonido listId(int id);
    void delete(int id);
    void edit(Sonido s);
}
