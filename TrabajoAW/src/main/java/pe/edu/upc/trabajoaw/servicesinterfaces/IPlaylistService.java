package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.entities.Playlist;

import java.util.List;

public interface IPlaylistService {
    List<Playlist> list();
    void insertar(Playlist p);
    Playlist listId(int id);
    void delete(int id);
    void edit(Playlist p);

}
