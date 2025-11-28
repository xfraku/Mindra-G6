package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.trabajoaw.entities.Recordatorio;

import java.util.List;

public interface IRecordatorioRepository extends JpaRepository<Recordatorio, Integer> {
    @Query(value = "SELECT r.id_Recordatorio, r.titulo, r.descripcion, r.dia_Elegido, r.activo\n" +
            "FROM Recordatorio r\n" +
            "WHERE r.activo = 'SI' AND r.dia_Elegido = 'Lunes'\n" +
            "ORDER BY r.id_Recordatorio", nativeQuery = true)
    public List<String[]> cantidadRecordatoriosActivospordia();
}
