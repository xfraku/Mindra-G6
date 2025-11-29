package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "Visitas")
public class Visitas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVisita;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Users usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSitiosWeb")
    private SitiosWeb sitiosWeb;

    @Column(name = "fechaEntrada", nullable = false)
    private Instant fechaEntrada;

    @Column(name = "fechaSalida", nullable = false)
    private Instant fechaSalida;

    @ManyToOne
    @JoinColumn(name = "idRecomendacion")
    private Recomendacion recomendacion;

    public Visitas() {
    }

    public Visitas(int idVisita, Users usuario, SitiosWeb sitiosWeb, Instant fechaEntrada, Instant fechaSalida, Recomendacion recomendacion) {
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

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public SitiosWeb getSitiosWeb() {
        return sitiosWeb;
    }

    public void setSitiosWeb(SitiosWeb sitiosWeb) {
        this.sitiosWeb = sitiosWeb;
    }

    public Instant getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Instant fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Instant getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Instant fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Recomendacion getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(Recomendacion recomendacion) {
        this.recomendacion = recomendacion;
    }
}
