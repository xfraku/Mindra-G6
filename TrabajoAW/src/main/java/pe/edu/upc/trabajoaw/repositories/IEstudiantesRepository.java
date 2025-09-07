package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoaw.entities.Estudiantes;

@Repository
public interface IEstudiantesRepository extends JpaRepository<Estudiantes, Integer> {
}
