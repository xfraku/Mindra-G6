package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "HistoriaEmocional")
public class HistoriaEmocional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idHistoriaEmocional;

    @Column(name = "titulo",length = 50, nullable = false)
    private String titulo;

    @Column(name = "descripcion",length = 500, nullable = false)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "notas", length = 100, nullable = false)
    private String notas;

    @Column(name = "reflexion", length = 100, nullable = false)
    private String reflexion;

    public HistoriaEmocional() {
    }

    public HistoriaEmocional(int idHistoriaEmocional, String titulo, String descripcion, LocalDate fecha, Usuario usuario, String notas, String reflexion) {
        this.idHistoriaEmocional = idHistoriaEmocional;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.notas = notas;
        this.reflexion = reflexion;
    }

    public int getIdHistoriaEmocional() {
        return idHistoriaEmocional;
    }

    public void setIdHistoriaEmocional(int idHistoriaEmocional) {
        this.idHistoriaEmocional = idHistoriaEmocional;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getReflexion() {
        return reflexion;
    }

    public void setReflexion(String reflexion) {
        this.reflexion = reflexion;
    }
}
