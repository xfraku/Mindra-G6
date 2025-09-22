package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoaw.dtos.RankingEmocionViewDTO;
import pe.edu.upc.trabajoaw.dtos.UsuarioRegistroViewDTO;
import pe.edu.upc.trabajoaw.entities.HistoriaEmocional;

import java.util.List;

@Repository
public interface IHistoriaEmocionalRepository extends JpaRepository<HistoriaEmocional, Integer> {

    @Query(
            value = """
                WITH conteo AS (
                  SELECT hed.id_emocion, he.id_usuario, COUNT(*) AS total_registros
                  FROM historias_emocionales_emociones hed
                  JOIN historia_emocional he
                    ON he.id_historia_emocional = hed.id_historia_emocional
                  GROUP BY hed.id_emocion, he.id_usuario
                ),
                ranked AS (
                  SELECT
                    e.id_emocion AS codigo_emocion,
                    e.descripcion AS emocion,
                    c.id_usuario AS usuario,
                    c.total_registros,
                    ROW_NUMBER() OVER (
                      PARTITION BY c.id_emocion
                      ORDER BY c.total_registros DESC, c.id_usuario
                    ) AS posicion
                  FROM conteo c
                  JOIN emocion e ON e.id_emocion = c.id_emocion
                )
                SELECT emocion, codigo_emocion, usuario, total_registros, posicion
                FROM ranked
                ORDER BY emocion, posicion
            """,
            nativeQuery = true
    )
    List<UsuarioRegistroViewDTO> findUsuariosMasRegistrosPorEmocion();

    @Query(
            value = """
               SELECT
                 e.id_emocion       AS idEmocion,
                 e.descripcion      AS emocion,
                 COUNT(DISTINCT he.id_usuario) AS usuariosUnicos,
                 DENSE_RANK() OVER (ORDER BY COUNT(DISTINCT he.id_usuario) DESC) AS ranking
               FROM emocion e
               JOIN historias_emocionales_emociones hed ON hed.id_emocion = e.id_emocion
               JOIN historia_emocional he ON he.id_historia_emocional = hed.id_historia_emocional
               GROUP BY e.id_emocion, e.descripcion
               ORDER BY ranking, emocion
            """,
            nativeQuery = true
    )
    List<RankingEmocionViewDTO> findRankingEmociones();
}