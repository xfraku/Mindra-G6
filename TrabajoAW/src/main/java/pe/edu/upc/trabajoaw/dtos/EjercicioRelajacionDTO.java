package pe.edu.upc.trabajoaw.dtos;

public class EjercicioRelajacionDTO {
    private int idEjercicioRelajacion;
    private String descripcion;
    private String recomendacion;
    private int duracion;

    public int getIdEjercicioRelajacion() {
        return idEjercicioRelajacion;
    }
    public void setIdEjercicioRelajacion(int idEjercicioRelajacion) {
        this.idEjercicioRelajacion = idEjercicioRelajacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getRecomendacion() {
        return recomendacion;
    }
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}