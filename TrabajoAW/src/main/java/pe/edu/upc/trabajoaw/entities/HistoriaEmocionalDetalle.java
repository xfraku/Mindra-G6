package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "historialEmocionalDetalle")
public class HistoriaEmocionalDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idHistoriaEmocionalDetalle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idHistorialEmocional")
    private HistoriaEmocional historialEmocional;

    @ManyToOne
    @JoinColumn(name = "idFrase")
    private FraseMotivacional frase;

    @ManyToOne
    @JoinColumn(name = "idEmocion")
    private Emocion emocion;

    @ManyToOne
    @JoinColumn(name = "idEjercicio")
    private EjercicioRelajacion ejercicio;

    @ManyToOne
    @JoinColumn(name = "idSonido")
    private Sonido sonido;

    @ManyToOne
    @JoinColumn(name = "idPlaylist")
    private Playlist playlist;

    public HistoriaEmocionalDetalle() {
    }

    public HistoriaEmocionalDetalle(int idHistoriaEmocionalDetalle, HistoriaEmocional historialEmocional, FraseMotivacional frase, Emocion emocion, EjercicioRelajacion ejercicio, Sonido sonido, Playlist playlist) {
        this.idHistoriaEmocionalDetalle = idHistoriaEmocionalDetalle;
        this.historialEmocional = historialEmocional;
        this.frase = frase;
        this.emocion = emocion;
        this.ejercicio = ejercicio;
        this.sonido = sonido;
        this.playlist = playlist;
    }

    public int getIdHistoriaEmocionalDetalle() {
        return idHistoriaEmocionalDetalle;
    }

    public void setIdHistoriaEmocionalDetalle(int idHistoriaEmocionalDetalle) {
        this.idHistoriaEmocionalDetalle = idHistoriaEmocionalDetalle;
    }

    public HistoriaEmocional getHistorialEmocional() {
        return historialEmocional;
    }

    public void setHistorialEmocional(HistoriaEmocional historialEmocional) {
        this.historialEmocional = historialEmocional;
    }

    public FraseMotivacional getFrase() {
        return frase;
    }

    public void setFrase(FraseMotivacional frase) {
        this.frase = frase;
    }

    public Emocion getEmocion() {
        return emocion;
    }

    public void setEmocion(Emocion emocion) {
        this.emocion = emocion;
    }

    public EjercicioRelajacion getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(EjercicioRelajacion ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Sonido getSonido() {
        return sonido;
    }

    public void setSonido(Sonido sonido) {
        this.sonido = sonido;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
