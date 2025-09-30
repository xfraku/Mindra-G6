package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoaw.entities.EjercicioRelajacion;

import java.util.List;

@Repository
public interface IEjercicioRelajacionRepository extends JpaRepository<EjercicioRelajacion, Integer> {
    @Query(value = "SELECT e.titulo, e.descripcion, COUNT(h.idEjercicio) AS total_usos\n" +
            "FROM historiaEmocionalDetalle h\n" +
            "JOIN ejerciciosRelajacion e \n" +
            "    ON h.idEjercicio = e.idEjercicio\n" +
            "GROUP BY e.idEjercicio, e.titulo, e.descripcion\n" +
            "ORDER BY total_usos DESC;", nativeQuery = true)
    public List<String[]> ejerciciosRelajacionTop();
}
