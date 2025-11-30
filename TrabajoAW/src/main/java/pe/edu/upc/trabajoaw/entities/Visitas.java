package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "Visitas")
public class Visitas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVisita;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSitiosWeb")
    private SitiosWeb sitiosWeb;

    @Column(name = "fechaEntrada", nullable = false)
    private LocalDate fechaEntrada;

    @Column(name = "fechaSalida", nullable = false)
    private LocalDate fechaSalida;

    @ManyToOne
    @JoinColumn(name = "idRecomendacion")
    private Recomendacion recomendacion;

    public Visitas() {
    }

    public Visitas(int idVisita, Usuario usuario, SitiosWeb sitiosWeb, LocalDate fechaEntrada, LocalDate fechaSalida, Recomendacion recomendacion) {
        this.idVisita = idVisita;
        this.usuario = usuario;
        this.sitiosWeb = sitiosWeb;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.recomendacion = recomendacion;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public SitiosWeb getSitiosWeb() {
        return sitiosWeb;
    }

    public void setSitiosWeb(SitiosWeb sitiosWeb) {
        this.sitiosWeb = sitiosWeb;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Recomendacion getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(Recomendacion recomendacion) {
        this.recomendacion = recomendacion;
    }
}
