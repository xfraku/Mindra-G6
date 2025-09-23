package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Playlist;

public interface IPlaylistRepository extends JpaRepository<Playlist, Integer> {

}
