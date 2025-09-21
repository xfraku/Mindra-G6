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
    @JoinColumn(name = "idUsuarioEstudiantes")
    private Estudiantes estudiantes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuarioPadre")
    private Padre padre;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Column(name = "leido", nullable = false)
    private boolean leido;

    @Column(name = "idMensajeRespuesta", length = 8, nullable = false)
    private String idMensajeRespuesta;

    public Mensaje() {
    }

    public Mensaje(int idMensaje, String contenido, Estudiantes estudiantes, Padre padre, Instant fecha, boolean leido, String idMensajeRespuesta) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.estudiantes = estudiantes;
        this.padre = padre;
        this.fecha = fecha;
        this.leido = leido;
        this.idMensajeRespuesta = idMensajeRespuesta;
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

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Padre getPadre() {
        return padre;
    }

    public void setPadre(Padre padre) {
        this.padre = padre;
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

    public String getIdMensajeRespuesta() {
        return idMensajeRespuesta;
    }

    public void setIdMensajeRespuesta(String idMensajeRespuesta) {
        this.idMensajeRespuesta = idMensajeRespuesta;
    }
}
