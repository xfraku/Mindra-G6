package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.trabajoaw.entities.Emocion;

import java.util.List;

public interface IEmocionRepository extends JpaRepository<Emocion, Integer> {
    @Query (value = "SELECT h.id_Historia_Emocional, h.titulo, COUNT(he.id_Emocion) AS emociones_count\n" +
            "FROM Historia_Emocional h\n" +
            "LEFT JOIN Historias_Emocionales_Emociones he\n" +
            "  ON he.id_Historia_Emocional = h.id_Historia_Emocional\n" +
            "GROUP BY h.id_Historia_Emocional, h.titulo\n" +
            "ORDER BY emociones_count DESC, h.id_Historia_Emocional", nativeQuery = true)
    public List<Emocion> cantidadHistoriasEmocional();
}
