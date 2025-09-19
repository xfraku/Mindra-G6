package pe.edu.upc.trabajoaw.dtos;

import pe.edu.upc.trabajoaw.entities.Usuario;

public class EstudiantesDTO {
    private int idEstudiante;
    private String centroEstudiantes;
    private String estadoEmocional;
    private boolean modoEnfoque;
    private boolean riesgoEmocional;
    private Usuario usuario;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
