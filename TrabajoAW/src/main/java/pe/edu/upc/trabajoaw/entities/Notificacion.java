package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idNotificacion;

    @Column(name = "problema", length = 100, nullable = false)
    private String problema;

    @Column(name = "fecha", nullable = false)
    private LocalTime fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, String problema, LocalTime fecha, Usuario usuario) {
        this.idNotificacion = idNotificacion;
        this.problema = problema;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
