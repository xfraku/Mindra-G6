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
                    e.id_emocion AS idEmocion,
                    e.descripcion AS emocion,
                    c.id_usuario AS usuario,
                    c.total_registros,
                    ROW_NUMBER() OVER (
                      PARTITION BY c.id_emocion
                      ORDER BY c.total_registros DESC, c.id_usuario
                    ) AS ranking
                  FROM conteo c
                  JOIN emocion e ON e.id_emocion = c.id_emocion
                )
                SELECT emocion, idEmocion, usuario, total_registros, ranking
                FROM ranked
                ORDER BY emocion, ranking
            """,
            nativeQuery = true
    )
    List<UsuarioRegistroViewDTO> findUsuariosMasRegistrosPorEmocion();

    @Query(
            value = """
               -- Ranking de emociones por número de usuarios únicos que las registraron
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