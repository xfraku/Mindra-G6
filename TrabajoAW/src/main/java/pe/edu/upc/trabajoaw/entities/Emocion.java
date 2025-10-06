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

    @Column(name = "fraseRelacionada", length = 100, nullable = false)
    private String fraseRelacionada;

    @Column(name = "iconoUrl", length = 100, nullable = false)
    private String iconoUrl;

    public Emocion() {
    }

    public Emocion(int idEmocion, String descripcion, String fraseRelacionada, String iconoUrl) {
        this.idEmocion = idEmocion;
        this.descripcion = descripcion;
        this.fraseRelacionada = fraseRelacionada;
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

    public String getFraseRelacionada() {
        return fraseRelacionada;
    }

    public void setFraseRelacionada(String fraseRelacionada) {
        this.fraseRelacionada = fraseRelacionada;
    }

    public String getIconoUrl() {
        return iconoUrl;
    }

    public void setIconoUrl(String iconoUrl) {
        this.iconoUrl = iconoUrl;
    }
}
