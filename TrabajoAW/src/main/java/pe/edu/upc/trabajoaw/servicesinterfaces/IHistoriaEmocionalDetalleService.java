package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.HistoriaEmocionalDetalle;

import java.util.List;

public interface IHistoriaEmocionalDetalleService {

    List<HistoriaEmocionalDetalle> list();
    void insertar(HistoriaEmocionalDetalle d);
    HistoriaEmocionalDetalle listId(int id);
    void delete(int id);
    void edit(HistoriaEmocionalDetalle d);
    List<HistoriaEmocionalDetalle> listarPorHistorial(int idHistorialEmocional);

}
