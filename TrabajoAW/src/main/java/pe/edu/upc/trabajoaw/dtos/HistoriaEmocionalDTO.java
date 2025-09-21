package pe.edu.upc.trabajoaw.dtos;

import pe.edu.upc.trabajoaw.entities.Usuario;

import java.time.Instant;
import java.util.Set;

public class HistoriaEmocionalDTO {
    private int idHistoriaEmocional;
    private String titulo;
    private String descripcion;
    private Instant fecha;
    private Usuario usuario;
    private String notas;
    private String reflexion;
    private Set<Integer> emocionesIds;
    private Set<Integer> ejerciciosIds;
    private Set<Integer> frasesMotivacionalesIds;

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

    public Set<Integer> getEmocionesIds() {
        return emocionesIds;
    }

    public void setEmocionesIds(Set<Integer> emocionesIds) {
        this.emocionesIds = emocionesIds;
    }

    public Set<Integer> getEjerciciosIds() {
        return ejerciciosIds;
    }

    public void setEjerciciosIds(Set<Integer> ejerciciosIds) {
        this.ejerciciosIds = ejerciciosIds;
    }

    public Set<Integer> getFrasesMotivacionalesIds() {
        return frasesMotivacionalesIds;
    }

    public void setFrasesMotivacionalesIds(Set<Integer> frasesMotivacionalesIds) {
        this.frasesMotivacionalesIds = frasesMotivacionalesIds;
    }
}
