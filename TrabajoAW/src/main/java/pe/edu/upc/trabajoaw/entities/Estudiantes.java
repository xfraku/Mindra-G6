package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="Estudiantes")
public class Estudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstudiante;

    @Column(name = "centroEstudiantes", length = 40,nullable = false)
    private String centroEstudiantes;

    @Column(name = "estadoEmocional",length =40,nullable = false)
    private String estadoEmocional;

    @Column(name = "modoEnfoque",nullable = false)
    private boolean modoEnfoque;

    @Column(name = "riesgoEmocional", nullable = false)
    private boolean riesgoEmocional;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    public Estudiantes() {
    }

    public Estudiantes(int idEstudiante, String centroEstudiantes, String estadoEmocional, boolean modoEnfoque, boolean riesgoEmocional, Usuario usuario) {
        this.idEstudiante = idEstudiante;
        this.centroEstudiantes = centroEstudiantes;
        this.estadoEmocional = estadoEmocional;
        this.modoEnfoque = modoEnfoque;
        this.riesgoEmocional = riesgoEmocional;
        this.usuario = usuario;
    }

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
