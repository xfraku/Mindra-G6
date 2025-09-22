package pe.edu.upc.trabajoaw.dtos;

public class EjercicioRelajacionDTO {
    private int idEjercicioRelajacion;
    private String problema;
    private String recomendaciones;
    private String duracion;

    public int getIdEjercicioRelajacion() {
        return idEjercicioRelajacion;
    }

    public void setIdEjercicioRelajacion(int idEjercicioRelajacion) {
        this.idEjercicioRelajacion = idEjercicioRelajacion;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
