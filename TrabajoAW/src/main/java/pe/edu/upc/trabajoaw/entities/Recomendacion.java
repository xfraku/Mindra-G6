package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recomendacion")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRecomendacion;

    @Column(name = "titulo", length = 50,nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 100,nullable = false)
    private String descripcion;

    public Recomendacion() {
    }

    public Recomendacion(int idRecomendacion, String titulo, String descripcion) {
        this.idRecomendacion = idRecomendacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
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
}
