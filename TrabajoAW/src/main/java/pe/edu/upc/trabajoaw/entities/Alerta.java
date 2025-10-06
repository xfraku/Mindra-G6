package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "alertas")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAlerta;

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

    @ManyToOne
    @JoinColumn(name = "idRecomendaciones")
    private Recomendacion recomendacion;

    public Alerta() {
    }

    public Alerta(int idAlerta, Instant tiempoEstablecido, String mensaje, String nivelIntervencion, String tipo, boolean visible, LocalTime horaInicio, LocalTime horaFin, Recomendacion recomendacion) {
        this.idAlerta = idAlerta;
        this.tiempoEstablecido = tiempoEstablecido;
        this.mensaje = mensaje;
        this.nivelIntervencion = nivelIntervencion;
        this.tipo = tipo;
        this.visible = visible;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.recomendacion = recomendacion;
    }

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

    public Recomendacion getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(Recomendacion recomendacion) {
        this.recomendacion = recomendacion;
    }
}