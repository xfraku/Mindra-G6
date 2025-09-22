package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.time.Instant;
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
    private Instant fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "notas", length = 100, nullable = false)
    private String notas;

    @Column(name = "reflexion", length = 100, nullable = false)
    private String reflexion;

    @ManyToMany
    @JoinTable(
            name = "HistoriasEmocionales_Emociones",
            joinColumns = @JoinColumn(name = "idHistoriaEmocional"),
            inverseJoinColumns = @JoinColumn(name = "idEmocion")
    )
    private Set<Emocion> emociones = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "HistoriasEmocionales_EjerciciosRelajacion",
            joinColumns = @JoinColumn(name = "idHistoriaEmocional"),
            inverseJoinColumns = @JoinColumn(name = "idEjercicios")
    )
    private Set<EjercicioRelajacion> ejercicios = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "HistoriasEmocionales_FrasesMotivac",
            joinColumns = @JoinColumn(name = "idHistoriaEmocional"),
            inverseJoinColumns = @JoinColumn(name = "idFraseMotivacional")
    )
    private Set<FraseMotivacional> frasesMotivacionales = new HashSet<>();

    public HistoriaEmocional() {
    }

    public HistoriaEmocional(int idHistoriaEmocional, String titulo, String descripcion, Instant fecha, Usuario usuario, String notas, String reflexion, Set<Emocion> emociones, Set<EjercicioRelajacion> ejercicios, Set<FraseMotivacional> frasesMotivacionales) {
        this.idHistoriaEmocional = idHistoriaEmocional;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.notas = notas;
        this.reflexion = reflexion;
        this.emociones = emociones;
        this.ejercicios = ejercicios;
        this.frasesMotivacionales = frasesMotivacionales;
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

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
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

    public Set<Emocion> getEmociones() {
        return emociones;
    }

    public void setEmociones(Set<Emocion> emociones) {
        this.emociones = emociones;
    }

    public Set<EjercicioRelajacion> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(Set<EjercicioRelajacion> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public Set<FraseMotivacional> getFrasesMotivacionales() {
        return frasesMotivacionales;
    }

    public void setFrasesMotivacionales(Set<FraseMotivacional> frasesMotivacionales) {
        this.frasesMotivacionales = frasesMotivacionales;
    }
}
