package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.HistoriaEmocional;

import java.util.List;

public interface IHistoriaEmocionalService {
    List<HistoriaEmocional> list();
    void insertar(HistoriaEmocional h);
    HistoriaEmocional listId(int id);
    void delete(int id);
    void edit(HistoriaEmocional h);
}
