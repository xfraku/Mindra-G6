package pe.edu.upc.trabajoaw.dtos;

import java.time.Instant;

public class MensajeDTO {
    private int idMensaje;
    private String contenido;
    private int idEstudiante;
    private int idPadre;
    private Instant fecha;
    private boolean leido;
    private String idMensajeRespuesta;

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public String getIdMensajeRespuesta() {
        return idMensajeRespuesta;
    }

    public void setIdMensajeRespuesta(String idMensajeRespuesta) {
        this.idMensajeRespuesta = idMensajeRespuesta;
    }
}
