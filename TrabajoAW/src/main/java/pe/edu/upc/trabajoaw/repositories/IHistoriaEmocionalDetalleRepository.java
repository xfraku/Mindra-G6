package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.HistoriaEmocionalDetalle;

import java.util.List;

public interface IHistoriaEmocionalDetalleRepository extends JpaRepository<HistoriaEmocionalDetalle, Integer> {
    List<HistoriaEmocionalDetalle> findByHistorialEmocional_IdHistoriaEmocional(int idHistorialEmocional);
}
