package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Emocion;

public interface IEmocionRepository extends JpaRepository<Emocion, Integer> {

}
