package pe.edu.upc.trabajoaw.dtos;

public class RankingEmocionViewDTO {

    private int idEmocion;
    private String emocion;
    private long usuariosUnicos;
    private long ranking;

    // 🔹 Constructor vacío (necesario para serialización)
    public RankingEmocionViewDTO() {
    }

    // 🔹 Constructor con parámetros
    public RankingEmocionViewDTO(int idEmocion, String emocion, long usuariosUnicos, long ranking) {
        this.idEmocion = idEmocion;
        this.emocion = emocion;
        this.usuariosUnicos = usuariosUnicos;
        this.ranking = ranking;
    }

    public int getIdEmocion() {
        return idEmocion;
    }

    public void setIdEmocion(int idEmocion) {
        this.idEmocion = idEmocion;
    }

    public St
