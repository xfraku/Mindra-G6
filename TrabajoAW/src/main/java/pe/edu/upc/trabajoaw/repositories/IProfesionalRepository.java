package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Profesional;

public interface IProfesionalRepository extends JpaRepository<Profesional,Integer> {
}
