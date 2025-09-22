package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Notificacion;

public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {
}
