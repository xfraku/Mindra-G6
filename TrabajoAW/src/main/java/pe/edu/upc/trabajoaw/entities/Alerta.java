package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalTime;

@Entity
@Table(name = "Alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlerta;

    @Column(name = "tiempoEstablecido", nullable = false)
    private Instant tiempoEstablecido;

    @Column(name = "mensaje", length = 100, nullable = false)
    private String mensaje;

    @Column(name = "nivelIntervencion", length = 20, nullable = false)
    private String nivelIntervencion;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "visible", nullable = false)
    private boolean visible;

    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;

    public Alerta() {
    }

    public Alerta(Instant tiempoEstablecido, String mensaje, String nivelIntervencion, String tipo, boolean visible, LocalTime horaInicio, LocalTime horaFin) {
        this.tiempoEstablecido = tiempoEstablecido;
        this.mensaje = mensaje;
        this.nivelIntervencion = nivelIntervencion;
        this.tipo = tipo;
        this.visible = visible;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y Setters

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
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

    @Override
    public String toString() {
        return "Alerta{" +
                "idAlerta=" + idAlerta +
                ", tiempoEstablecido=" + tiempoEstablecido +
                ", mensaje='" + mensaje + '\'' +
                ", nivelIntervencion='" + nivelIntervencion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", visible=" + visible +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                '}';
    }
}