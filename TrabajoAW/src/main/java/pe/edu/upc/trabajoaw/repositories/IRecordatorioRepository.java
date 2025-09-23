package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.trabajoaw.entities.Recordatorio;

import java.util.List;

public interface IRecordatorioRepository extends JpaRepository<Recordatorio, Integer> {
}
