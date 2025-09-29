package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Visitas;

import java.util.List;

public interface IVisitasServices {
    List<Visitas> list();
    void insertar(Visitas v);
    Visitas listId(int id);
    void delete(int id);
    void edit(Visitas v);
}
