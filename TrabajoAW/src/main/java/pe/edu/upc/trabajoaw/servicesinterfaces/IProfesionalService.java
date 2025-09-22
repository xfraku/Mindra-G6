package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Profesional;

import java.util.List;

public interface IProfesionalService {

    public List<Profesional> list();

    public void insertar(Profesional prof);

    public Profesional listId(int id);

    public void delete(int id);
    public void edit(Profesional prof);
}
