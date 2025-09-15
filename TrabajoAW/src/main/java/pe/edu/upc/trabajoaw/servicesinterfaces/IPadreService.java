package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Padre;

import java.util.List;

public interface IPadreService {

    public List<Padre> list();

    public void insertar(Padre p);

    public Padre listId(int id);

    public void delete(int id);
    public void edit(Padre u);
}
