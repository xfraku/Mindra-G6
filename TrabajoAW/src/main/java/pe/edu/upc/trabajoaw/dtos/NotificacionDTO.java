package pe.edu.upc.trabajoaw.dtos;

import java.time.Instant;

public class NotificacionDTO {
    private int idNotificacion;
    private String problema;
    private Instant fecha;
    private int idUsuario;

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
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}