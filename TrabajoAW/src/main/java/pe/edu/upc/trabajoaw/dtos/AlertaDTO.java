package pe.edu.upc.trabajoaw.dtos;

import java.time.Instant;
import java.time.LocalTime;

public class AlertaDTO {
    private int idAlerta;
    private Instant tiempoEstablecido;
    private String mensaje;
    private String nivelIntervencion;
    private String tipo;
    private boolean visible;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Instant getTiempoEstablecido() {
        return tiempoEstablecido;
    }

    public void setTiempoEstablecido(Instant tiempoEstablecido) {
        this.tiempoEstablecido = tiempoEstablecido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNivelIntervencion() {
        return nivelIntervencion;
    }

    public void setNivelIntervencion(String nivelIntervencion) {
        this.nivelIntervencion = nivelIntervencion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
