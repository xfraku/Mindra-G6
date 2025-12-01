package pe.edu.upc.trabajoaw.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajoaw.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<Usuario> list();

    public void insertar(Usuario u);

    public Usuario listId(int id);

    public void delete(int id);
    public void edit(Usuario u);
    public List<String[]> tiempoSitiosDistractoresUsuario(int idUsuario);
    public List<String[]> tiempoProductivoUsuario(int idUsuario);
}
