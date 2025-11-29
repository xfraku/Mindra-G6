package pe.edu.upc.trabajoaw.dtos;

public class RankingEmocionViewDTO {

    private int idEmocion;
    private String emocion;
    private long usuariosUnicos;
    private long ranking;

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

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public long getUsuariosUnicos() {
        return usuariosUnicos;
    }

    public void setUsuariosUnicos(long usuariosUnicos) {
        this.usuariosUnicos = usuariosUnicos;
    }

    public long getRanking() {
        return ranking;
    }

    public void setRanking(long ranking) {
        this.ranking = ranking;
    }
}