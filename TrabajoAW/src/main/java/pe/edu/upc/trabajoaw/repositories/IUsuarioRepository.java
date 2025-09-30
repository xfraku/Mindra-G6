package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.trabajoaw.entities.Usuario;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT u.id_usuario,\n" +
            "       u.nombres,\n" +
            "       SEC_TO_TIME(\n" +
            "           SUM(TIMESTAMPDIFF(SECOND, v.fecha_entrada, v.fecha_salida))\n" +
            "       ) AS tiempo_total\n" +
            "FROM visitas v\n" +
            "JOIN usuarios u ON v.id_usuario = u.id_usuario\n" +
            "JOIN sitios_web s ON v.id_sitio_web = s.id_sitio_web\n" +
            "WHERE s.clasificacion = 'distractor'\n" +
            "  AND u.id_usuario = %idUsuario%\n" +
            "GROUP BY u.id_usuario, u.nombres", nativeQuery = true)
    public List<String[]> tiempoSitiosDistractoresUsuario(@Param("idUsuario") int idUsuario);
}
