package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    List<Notificacion> list();
    void insertar(Notificacion n);
    Notificacion listId(int id);
    void delete(int id);
    void edit(Notificacion n);
    List<Object[]> listarNotificacionessinprofesionalasignado();
}
