package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Recomendacion;

public interface IRecomendacionRepository extends JpaRepository<Recomendacion, Integer> {
}
