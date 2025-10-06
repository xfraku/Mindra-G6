package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.DetalleUsuarioEstudiante;

import java.util.List;

public interface IDetalleUsuarioEstudianteRepository extends JpaRepository<DetalleUsuarioEstudiante, Integer> {
    List<DetalleUsuarioEstudiante> findByCentroEstudioContainingIgnoreCase(String centroEstudio);
    List<DetalleUsuarioEstudiante> findByUsuario_IdUsuario(int idUsuario);
}