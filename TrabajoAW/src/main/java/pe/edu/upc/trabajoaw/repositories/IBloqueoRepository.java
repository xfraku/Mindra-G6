package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.trabajoaw.entities.Bloqueo;

import java.util.List;

public interface IBloqueoRepository extends JpaRepository<Bloqueo, Integer> {
    @Query(value = "SELECT DISTINCT u.id_Usuario, u.nombre, u.apellido\n" +
            "FROM Usuario u\n" +
            "JOIN Bloqueo b ON b.id_Usuario = u.id_Usuario\n" +
            "WHERE b.fecha >= now() - interval '7 days'\n" +
            "ORDER BY u.id_Usuario", nativeQuery = true)
    public List<Bloqueo> cantidadBloqueos();

}
