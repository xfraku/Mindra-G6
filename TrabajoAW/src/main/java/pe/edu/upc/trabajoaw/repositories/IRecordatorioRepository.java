package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Recordatorio;

public interface IRecordatorioRepository extends JpaRepository<Recordatorio, Integer> {
}
