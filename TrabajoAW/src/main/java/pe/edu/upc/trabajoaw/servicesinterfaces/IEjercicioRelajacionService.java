package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.EjercicioRelajacion;

import java.util.List;
import java.util.Optional;

public interface IEjercicioRelajacionService {
    List<EjercicioRelajacion> list();
    void insertar(EjercicioRelajacion e);
    EjercicioRelajacion listId(int id);
    void delete(int id);
    void edit(EjercicioRelajacion e);
}
