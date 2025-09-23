package pe.edu.upc.trabajoaw.dtos;

public class DetalleUsuarioEstudianteDTO {
    private int idDetalle;
    private String centroEstudio;
    private String estadoEmocional;
    private boolean modoEnfoque;
    private boolean riesgoEmocional;
    private int idUsuario;

    public int getIdDetalle() {
        return idDetalle;
    }
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }
    public String getCentroEstudio() {
        return centroEstudio;
    }
    public void setCentroEstudio(String centroEstudio) {
        this.centroEstudio = centroEstudio;
    }
    public String getEstadoEmocional() {
        return estadoEmocional;
    }
    public void setEstadoEmocional(String estadoEmocional) {
        this.estadoEmocional = estadoEmocional;
    }
    public boolean isModoEnfoque() {
        return modoEnfoque;
    }
    public void setModoEnfoque(boolean modoEnfoque) {
        this.modoEnfoque = modoEnfoque;
    }
    public boolean isRiesgoEmocional() {
        return riesgoEmocional;
    }
    public void setRiesgoEmocional(boolean riesgoEmocional) {
        this.riesgoEmocional = riesgoEmocional;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}