package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recomendacion")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRecomendacion;

    @Column(name = "descripcion", length = 100,nullable = false)
    private String descripcion;

    public Recomendacion() {
    }

    public Recomendacion(int idRecomendacion, String descripcion) {
        this.idRecomendacion = idRecomendacion;
        this.descripcion = descripcion;
    }

    public int getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
