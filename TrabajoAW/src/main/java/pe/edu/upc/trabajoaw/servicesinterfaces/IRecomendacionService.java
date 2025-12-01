package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Recomendacion;

import java.util.List;

public interface IRecomendacionService {
    List<Recomendacion> list();
    void insertar(Recomendacion r);
    Recomendacion listId(int id);
    void delete(int id);
    void edit(Recomendacion r);
}
