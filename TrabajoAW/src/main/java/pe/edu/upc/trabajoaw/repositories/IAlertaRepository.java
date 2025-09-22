package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Alerta;

public interface IAlertaRepository extends JpaRepository<Alerta, Integer> {
}
