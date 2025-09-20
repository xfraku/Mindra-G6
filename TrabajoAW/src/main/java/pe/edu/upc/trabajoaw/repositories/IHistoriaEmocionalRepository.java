package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.HistoriaEmocional;

public interface IHistoriaEmocionalRepository extends JpaRepository<HistoriaEmocional, Integer> {
}
