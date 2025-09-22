package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Recordatorio;

import java.util.List;

public interface IRecordatorioService {
    List<Recordatorio> list();
    void insertar(Recordatorio r);
    Recordatorio listId(int id);
    void delete(int id);
    void edit(Recordatorio r);

}
