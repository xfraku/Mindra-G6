package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.trabajoaw.entities.Notificacion;

import java.util.List;

public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {
    @Query(value ="SELECT id_Notificacion, problema, fecha, id_Usuario_Estudiantes, id_Usuario_Padre, id_Usuario_Profesor " +
            "FROM Notificacion " +
            "WHERE id_Usuario_Profesor IS NULL " +
            "ORDER BY fecha DESC", nativeQuery = true)
    List<Object[]> listarNotificacionessinprofesionalasignado();
}