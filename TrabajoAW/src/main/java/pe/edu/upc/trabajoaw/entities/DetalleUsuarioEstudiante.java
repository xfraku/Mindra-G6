package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleUsuarioEstudiante")
public class DetalleUsuarioEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDetalle;

    @Column(name = "centroEstudio", length = 50, nullable = false)
    private String centroEstudio;

    @Column(name = "estadoEmocional", length = 50, nullable = false)
    private String estadoEmocional;

    @Column(name = "modoEnfoque", nullable = false)
    private boolean modoEnfoque;

    @Column(name = "riesgoEmocional", nullable = false)
    private boolean riesgoEmocional;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Users usuario;

    public DetalleUsuarioEstudiante() {
    }

    public DetalleUsuarioEstudiante(int idDetalle, String centroEstudio, String estadoEmocional, boolean modoEnfoque, boolean riesgoEmocional, Users usuario) {
        this.idDetalle = idDetalle;
        this.centroEstudio = centroEstudio;
        this.estadoEmocional = estadoEmocional;
        this.modoEnfoque = modoEnfoque;
        this.riesgoEmocional = riesgoEmocional;
        this.usuario = usuario;
    }

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

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
