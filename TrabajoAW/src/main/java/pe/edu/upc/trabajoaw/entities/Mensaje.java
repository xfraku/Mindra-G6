package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "Mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMensaje;

    @Column(name = "contenido",length = 100, nullable = false)
    private String contenido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Column(name = "leido", nullable = false)
    private boolean leido;

    public Mensaje() {
    }

    public Mensaje(int idMensaje, String contenido, Usuario usuario, Instant fecha, boolean leido) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.usuario = usuario;
        this.fecha = fecha;
        this.leido = leido;
    }

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

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
