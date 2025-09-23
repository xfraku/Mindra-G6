package pe.edu.upc.trabajoaw.dtos;

public class HistoriaEmocionalDetalleDTO {
    private int idHistoriaEmocionalDetalle;
    private int idHistorialEmocional;
    private Integer idFrase;
    private Integer idEmocion;
    private Integer idEjercicio;
    private Integer idSonido;
    private Integer idPlaylist;

    public int getIdHistoriaEmocionalDetalle() {
        return idHistoriaEmocionalDetalle;
    }
    public void setIdHistoriaEmocionalDetalle(int idHistoriaEmocionalDetalle) {
        this.idHistoriaEmocionalDetalle = idHistoriaEmocionalDetalle;
    }
    public int getIdHistorialEmocional() {
        return idHistorialEmocional;
    }
    public void setIdHistorialEmocional(int idHistorialEmocional) {
        this.idHistorialEmocional = idHistorialEmocional;
    }
    public Integer getIdFrase() {
        return idFrase;
    }
    public void setIdFrase(Integer idFrase) {
        this.idFrase = idFrase;
    }
    public Integer getIdEmocion() {
        return idEmocion;
    }
    public void setIdEmocion(Integer idEmocion) {
        this.idEmocion = idEmocion;
    }
    public Integer getIdEjercicio() {
        return idEjercicio;
    }
    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }
    public Integer getIdSonido() {
        return idSonido;
    }
    public void setIdSonido(Integer idSonido) {
        this.idSonido = idSonido;
    }
    public Integer getIdPlaylist() {
        return idPlaylist;
    }
    public void setIdPlaylist(Integer idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
}