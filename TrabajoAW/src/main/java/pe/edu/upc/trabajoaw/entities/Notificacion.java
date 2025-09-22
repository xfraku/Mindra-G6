package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "Notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idNotificacion;

    @Column(name = "problema", length = 100, nullable = false)
    private String problema;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuarioEstudiantes")
    private Estudiantes estudiantes;

    @ManyToOne
    @JoinColumn(name = "idUsuarioProfesor")
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "idUsuarioPadre")
    private Padre padre;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, String problema, Instant fecha, Estudiantes estudiantes, Profesional profesional, Padre padre) {
        this.idNotificacion = idNotificacion;
        this.problema = problema;
        this.fecha = fecha;
        this.estudiantes = estudiantes;
        this.profesional = profesional;
        this.padre = padre;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Padre getPadre() {
        return padre;
    }

    public void setPadre(Padre padre) {
        this.padre = padre;
    }
}
