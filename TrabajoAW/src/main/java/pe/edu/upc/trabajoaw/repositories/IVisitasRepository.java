package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajoaw.entities.Visitas;

import java.time.Instant;
import java.util.List;

public interface IVisitasRepository extends JpaRepository<Visitas, Integer> {
}
