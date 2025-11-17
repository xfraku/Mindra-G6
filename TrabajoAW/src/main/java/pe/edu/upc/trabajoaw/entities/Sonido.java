package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sonidos")
public class
Sonido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSonido;

    @Column(name = "archivoUrl", length = 200, nullable = false)
    private String archivoUrl;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    public Sonido() {
    }

    public Sonido(int idSonido, String archivoUrl, String tipo) {
        this.idSonido = idSonido;
        this.archivoUrl = archivoUrl;
        this.tipo = tipo;
    }

    public int getIdSonido() {
        return idSonido;
    }

    public void setIdSonido(int idSonido) {
        this.idSonido = idSonido;
    }

    public String getArchivoUrl() {
        return archivoUrl;
    }

    public void setArchivoUrl(String archivoUrl) {
        this.archivoUrl = archivoUrl;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
