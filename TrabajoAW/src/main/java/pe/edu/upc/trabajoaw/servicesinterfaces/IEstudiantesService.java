package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Estudiantes;

import java.util.List;

public interface IEstudiantesService {

    public List<Estudiantes> list();

    public void insert(Estudiantes e);

    public Estudiantes listId(int id);

    public void delete(int id);

    public void edit(Estudiantes e);

    public List<Estudiantes> buscarCentro(String  centroEstudiante);
}