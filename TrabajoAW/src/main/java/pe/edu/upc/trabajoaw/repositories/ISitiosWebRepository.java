package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.trabajoaw.entities.SitiosWeb;

import java.util.List;

public interface ISitiosWebRepository extends JpaRepository<SitiosWeb, Integer> {
    @Query(value = "SELECT s.idSitioWeb, s.nombre, " +
            "EXTRACT(EPOCH FROM AVG(v.fechaSalida - v.fechaEntrada)) AS duracion_promedio_seg " +
            "FROM sitiosWeb s " +
            "JOIN visitas v ON v.idSitioWeb = s.idSitioWeb " +
            "GROUP BY s.idSitioWeb, s.nombre " +
            "ORDER BY duracion_promedio_seg DESC", nativeQuery = true)
    List<Object[]> duracionPromedioVisitasPorSitio();
}