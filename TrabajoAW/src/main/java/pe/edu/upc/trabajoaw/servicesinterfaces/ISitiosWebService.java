package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.SitiosWeb;

import java.util.List;

public interface ISitiosWebService {
    List<SitiosWeb> list();
    void insertar(SitiosWeb s);
    SitiosWeb listId(int id);
    void delete(int id);
    void edit(SitiosWeb s);
    List<Object[]> duracionPromedioVisitasPorSitio();
}
