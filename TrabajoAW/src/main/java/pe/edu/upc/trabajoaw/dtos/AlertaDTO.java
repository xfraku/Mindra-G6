package pe.edu.upc.trabajoaw.dtos;

import java.time.Instant;

public class AlertaDTO {
    private int idAlerta;
    private Instant tiempoEstablecido;
    private String mensaje;
    private String nivelIntervencion;
    private String tipo;
    private boolean visible;
    private Instant horaInicio;
    private Instant horaFin;
    private RecomendacionDTO recomendacion;

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
    public Instant getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }
    public Instant getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }
    public RecomendacionDTO getRecomendacion() {  // Cambié de getIdRecomendacion() a getRecomendacion()
        return recomendacion;
    }

    public void setRecomendacion(RecomendacionDTO recomendacion) {  // También corregí el parámetro
        this.recomendacion = recomendacion;
    }
}