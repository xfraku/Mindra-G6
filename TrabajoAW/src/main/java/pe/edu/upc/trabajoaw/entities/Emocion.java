package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Emocion")
public class Emocion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmocion;

    @Column(name = "descripcion", length = 100,nullable = false)
    private String descripcion;

    @Column(name = "frase", length = 100, nullable = false)
    private String frase;

    @Column(name = "iconoUrl", length = 100, nullable = false)
    private String iconoUrl;

    public Emocion() {
    }

    public Emocion(int idEmocion, String descripcion, String frase, String iconoUrl) {
        this.idEmocion = idEmocion;
        this.descripcion = descripcion;
        this.frase = frase;
        this.iconoUrl = iconoUrl;
    }

    public int getIdEmocion() {
        return idEmocion;
    }

    public void setIdEmocion(int idEmocion) {
        this.idEmocion = idEmocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getIconoUrl() {
        return iconoUrl;
    }

    public void setIconoUrl(String iconoUrl) {
        this.iconoUrl = iconoUrl;
    }
}
