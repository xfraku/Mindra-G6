package pe.edu.upc.trabajoaw.dtos;

import java.time.Instant;
import java.util.List;

public class HistoriaEmocionalDTO {
    private int idHistoriaEmocional;
    private String titulo;
    private String descripcion;
    private Instant fecha;
    private int idUsuario;
    private String notas;
    private String reflexion;
    private List<HistoriaEmocionalDetalleDTO> detalles;

    public int getIdHistoriaEmocional() {
        return idHistoriaEmocional;
    }
    public void setIdHistoriaEmocional(int idHistoriaEmocional) {
        this.idHistoriaEmocional = idHistoriaEmocional;
    }
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
    public Instant getFecha() {
        return fecha;
    }
    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNotas() {
        return notas;
    }
    public void setNotas(String notas) {
        this.notas = notas;
    }
    public String getReflexion() {
        return reflexion;
    }
    public void setReflexion(String reflexion) {
        this.reflexion = reflexion;
    }
    public List<HistoriaEmocionalDetalleDTO> getDetalles() {
        return detalles;
    }
    public void setDetalles(List<HistoriaEmocionalDetalleDTO> detalles) {
        this.detalles = detalles;
    }
}