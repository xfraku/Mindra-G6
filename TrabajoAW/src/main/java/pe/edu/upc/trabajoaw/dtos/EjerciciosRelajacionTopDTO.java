package pe.edu.upc.trabajoaw.dtos;

public class EjerciciosRelajacionTopDTO {
    private String titulo;
    private String descripcion;
    private int total_usos;

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

    public int getTotal_usos() {
        return total_usos;
    }

    public void setTotal_usos(int total_usos) {
        this.total_usos = total_usos;
    }
}
