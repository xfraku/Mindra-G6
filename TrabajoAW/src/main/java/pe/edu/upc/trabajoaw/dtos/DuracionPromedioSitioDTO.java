package pe.edu.upc.trabajoaw.dtos;

public class DuracionPromedioSitioDTO {
    private Integer idSitioWeb;
    private String nombre;
    private Double duracionPromedioSegundos;
    private String duracionPromedioHHMMSS;

    public Integer getIdSitioWeb() {
        return idSitioWeb;
    }

    public void setIdSitioWeb(Integer idSitioWeb) {
        this.idSitioWeb = idSitioWeb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDuracionPromedioSegundos() {
        return duracionPromedioSegundos;
    }

    public void setDuracionPromedioSegundos(Double duracionPromedioSegundos) {
        this.duracionPromedioSegundos = duracionPromedioSegundos;
    }

    public String getDuracionPromedioHHMMSS() {
        return duracionPromedioHHMMSS;
    }

    public void setDuracionPromedioHHMMSS(String duracionPromedioHHMMSS) {
        this.duracionPromedioHHMMSS = duracionPromedioHHMMSS;
    }
}