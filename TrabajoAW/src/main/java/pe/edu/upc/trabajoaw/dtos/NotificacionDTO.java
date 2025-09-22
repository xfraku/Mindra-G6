package pe.edu.upc.trabajoaw.dtos;

import pe.edu.upc.trabajoaw.entities.Estudiantes;
import pe.edu.upc.trabajoaw.entities.Padre;
import pe.edu.upc.trabajoaw.entities.Profesional;

import java.time.Instant;

public class NotificacionDTO {
    private int idNotificacion;
    private String problema;
    private Instant fecha;
    private Estudiantes idEstudiante;
    private Profesional idProfesional;
    private Padre idPadre;

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

    public Estudiantes getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiantes idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Profesional getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Profesional idProfesional) {
        this.idProfesional = idProfesional;
    }

    public Padre getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Padre idPadre) {
        this.idPadre = idPadre;
    }
}
