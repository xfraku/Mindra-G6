package pe.edu.upc.trabajoaw.dtos;

import java.time.Instant;

public class MensajeDTO {
    private int idMensaje;
    private String contenido;
    private int idEmisor;
    private int idReceptor;
    private Instant fecha;
    private boolean leido;
    private Integer idMensajeRespuesta;

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
    public int getIdEmisor() {
        return idEmisor;
    }
    public void setIdEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
    }
    public int getIdReceptor() {
        return idReceptor;
    }
    public void setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
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
    public Integer getIdMensajeRespuesta() {
        return idMensajeRespuesta;
    }
    public void setIdMensajeRespuesta(Integer idMensajeRespuesta) {
        this.idMensajeRespuesta = idMensajeRespuesta;
    }
}