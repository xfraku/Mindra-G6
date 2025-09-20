package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Visitas;

public interface IVisitasRepository extends JpaRepository<Visitas, Integer> {
}
