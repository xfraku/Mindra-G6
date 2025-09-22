package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.trabajoaw.entities.Alerta;

import java.util.List;

public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
    @Query (value = "SELECT s.id_Sitio_Web, s.nombre, COUNT(sa.id_Alerta) AS alertas_asociadas\n" +
            "FROM Sitios_Web s\n" +
            "LEFT JOIN Sitios_Web_Alertas sa ON sa.id_Sitio_Web = s.id_Sitio_Web\n" +
            "GROUP BY s.id_Sitio_Web, s.nombre\n" +
            "ORDER BY alertas_asociadas DESC, s.id_Sitio_Web", nativeQuery = true)
    public List<Alerta> cantidadSitiosWeb();
}
