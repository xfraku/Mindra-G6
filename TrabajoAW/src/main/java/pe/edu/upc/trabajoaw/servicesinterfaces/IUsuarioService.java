package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> list();

    public void insertar(Usuario u);

    public Usuario listId(int id);

    public void delete(int id);
    public void edit(Usuario u);
}
