package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Mensaje;

public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {
}
