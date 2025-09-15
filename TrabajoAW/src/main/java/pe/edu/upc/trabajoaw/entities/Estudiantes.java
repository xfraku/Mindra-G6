package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="Estudiantes")
public class Estudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;

    @Column(name = "centroEstudiantes", length = 40,nullable = false)
    private String centroEstudiantes;

    @Column(name = "estadoEmocional",length =40,nullable = false)
    private String estadoEmocional;

    @Column(name = "modoEnfoque",nullable = false)
    private boolean modoEnfoque;

    @Column(name = "riesgoEmocional", nullable = false)
    private boolean riesgoEmocional;

    public Estudiantes() {
    }

    public Estudiantes(int idUsuario, String centroEstudiantes, String estadoEmocional, boolean modoEnfoque, boolean riesgoEmocional) {
        this.idUsuario = idUsuario;
        this.centroEstudiantes = centroEstudiantes;
        this.estadoEmocional = estadoEmocional;
        this.modoEnfoque = modoEnfoque;
        this.riesgoEmocional = riesgoEmocional;
    }

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
