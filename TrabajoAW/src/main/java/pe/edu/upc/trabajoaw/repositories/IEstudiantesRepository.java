package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoaw.entities.Estudiantes;

import java.util.List;

@Repository
public interface IEstudiantesRepository extends JpaRepository<Estudiantes, Integer> {
    @Query("Select p from Estudiantes p where p.centroEstudiantes like %:centroEstudiantes%")
    public List<Estudiantes> buscar(@Param("centroE") String centroE);
}
