package pe.edu.upc.trabajoaw.dtos;

import java.util.Set;

public class SitiosWebDTO {
    private int idSitioWeb;
    private String dominio;
    private String nombre;
    private String clasificacion;
    private Set<Integer> alertasIds;

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

    public Set<Integer> getAlertasIds() {
        return alertasIds;
    }

    public void setAlertasIds(Set<Integer> alertasIds) {
        this.alertasIds = alertasIds;
    }
}
