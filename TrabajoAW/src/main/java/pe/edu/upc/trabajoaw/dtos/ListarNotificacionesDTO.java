package pe.edu.upc.trabajoaw.dtos;

import pe.edu.upc.trabajoaw.entities.Estudiantes;
import pe.edu.upc.trabajoaw.entities.Padre;
import pe.edu.upc.trabajoaw.entities.Profesional;

import java.time.Instant;

public class ListarNotificacionesDTO {
    private int idNotificacion;
    private String problema;
    private Instant fecha;
    private Estudiantes estudiantes;
    private Profesional profesional;
    private Padre padre;
    // Nuevos campos: IDs de las relaciones
    private Integer idEstudiantes;
    private Integer idPadre;
    private Integer idProfesional;

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

    public Integer getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(Integer idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Integer getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Integer idProfesional) {
        this.idProfesional = idProfesional;
    }
}