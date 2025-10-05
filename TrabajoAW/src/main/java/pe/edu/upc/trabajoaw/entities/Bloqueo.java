package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "Bloqueo")
public class Bloqueo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloqueo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSitiosWeb", nullable = false)
    private SitiosWeb sitiosWeb;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Column(name = "razon", length = 100, nullable = false)
    private String razon;

    public Bloqueo() {
    }

    public Bloqueo(SitiosWeb sitiosWeb, Usuario usuario, Instant fecha, String razon) {
        this.sitiosWeb = sitiosWeb;
        this.usuario = usuario;
        this.fecha = fecha;
        this.razon = razon;
    }

    // Getters y Setters

    public Long getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(Long idBloqueo) {
        this.idBloqueo = idBloqueo;
    }

    public SitiosWeb getSitiosWeb() {
        return sitiosWeb;
    }

    public void setSitiosWeb(SitiosWeb sitiosWeb) {
        this.sitiosWeb = sitiosWeb;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    @Override
    public String toString() {
        return "Bloqueo{" +
                "idBloqueo=" + idBloqueo +
                ", sitiosWeb=" + sitiosWeb +
                ", usuario=" + usuario +
                ", fecha=" + fecha +
                ", razon='" + razon + '\'' +
                '}';
    }
}