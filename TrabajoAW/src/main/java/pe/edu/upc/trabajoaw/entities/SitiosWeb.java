package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SitiosWeb")
public class SitiosWeb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSitioWeb;

    @Column(name = "dominio", length = 50,nullable = false)
    private String dominio;

    @Column(name = "nombre", length = 50,nullable = false)
    private String nombre;

    @Column(name = "clasificacion", length = 20,nullable = false)
    private String clasificacion;

    @ManyToMany
    @JoinTable(
            name = "SitiosWeb_Alertas",
            joinColumns = @JoinColumn(name = "idSitioWeb"),
            inverseJoinColumns = @JoinColumn(name = "idAlerta")
    )
    private Set<Alerta> alertas = new HashSet<>();

    public SitiosWeb() {
    }

    public SitiosWeb(int idSitioWeb, String dominio, String nombre, String clasificacion, Set<Alerta> alertas) {
        this.idSitioWeb = idSitioWeb;
        this.dominio = dominio;
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.alertas = alertas;
    }

    public int getIdSitioWeb() {
        return idSitioWeb;
    }

    public void setIdSitioWeb(int idSitioWeb) {
        this.idSitioWeb = idSitioWeb;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Set<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(Set<Alerta> alertas) {
        this.alertas = alertas;
    }
}
