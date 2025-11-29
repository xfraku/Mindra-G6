package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.User;

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
    @JoinColumn(name = "idUsuarioEmisor")
    private Users emisor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuarioReceptor")
    private Usuario receptor;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Column(name = "leido", nullable = false)
    private boolean leido;

    @ManyToOne
    @JoinColumn(name = "idMensajeRespuesta")
    private Mensaje mensajeRespuesta;

    public Mensaje() {
    }

    public Mensaje(int idMensaje, String contenido, Users emisor, Usuario receptor, Instant fecha, boolean leido, Mensaje mensajeRespuesta) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
        this.fecha = fecha;
        this.leido = leido;
        this.mensajeRespuesta = mensajeRespuesta;
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

    public Users getEmisor() {
        return emisor;
    }

    public void setEmisor(Users emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
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

    public Mensaje getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(Mensaje mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }
}
