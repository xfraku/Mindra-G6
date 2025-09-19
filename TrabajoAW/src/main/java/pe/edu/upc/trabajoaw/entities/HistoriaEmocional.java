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

}
