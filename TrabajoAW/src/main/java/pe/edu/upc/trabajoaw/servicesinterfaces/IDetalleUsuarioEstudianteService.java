package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.DetalleUsuarioEstudiante;

import java.util.List;

public interface IDetalleUsuarioEstudianteService {
    List<DetalleUsuarioEstudiante> list();
    void insertar(DetalleUsuarioEstudiante d);
    DetalleUsuarioEstudiante listId(int id);
    void delete(int id);
    void edit(DetalleUsuarioEstudiante d);
    List<DetalleUsuarioEstudiante> buscarPorCentro(String centroEstudio);
    List<DetalleUsuarioEstudiante> listarPorUsuario(int idUsuario);

}
