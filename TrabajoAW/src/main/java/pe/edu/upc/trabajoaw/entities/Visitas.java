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
    private Usuario usuario;

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

}
