package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "Bloqueo")
public class Bloqueo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBloqueo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSitiosWeb")
    private SitiosWeb sitiosWeb;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "razon",length = 100,nullable = false)
    private String razon;

    public Bloqueo() {
    }

    public Bloqueo(int idBloqueo, SitiosWeb sitiosWeb, Usuario usuario, LocalDate fecha, String razon) {
        this.idBloqueo = idBloqueo;
        this.sitiosWeb = sitiosWeb;
        this.usuario = usuario;
        this.fecha = fecha;
        this.razon = razon;
    }

    public int getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(int idBloqueo) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}
