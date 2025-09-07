package pe.edu.upc.trabajoaw.dtos;

public class EstudiantesDTO {
    private int idUsuario;
    private String centroEstudiantes;
    private String estadoEmocional;
    private boolean modoEnfoque;
    private boolean riesgoEmocional;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCentroEstudiantes() {
        return centroEstudiantes;
    }

    public void setCentroEstudiantes(String centroEstudiantes) {
        this.centroEstudiantes = centroEstudiantes;
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
}
