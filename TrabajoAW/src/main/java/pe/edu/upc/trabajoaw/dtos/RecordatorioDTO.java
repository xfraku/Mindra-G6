package pe.edu.upc.trabajoaw.dtos;

public class RecordatorioDTO {
    private int idRecordatorio;
    private String titulo;
    private String descripcion;
    private String diaElegido;
    private boolean activo;
    private int idUsuario;

    public int getIdRecordatorio() {
        return idRecordatorio;
    }
    public void setIdRecordatorio(int idRecordatorio) {
        this.idRecordatorio = idRecordatorio;
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
    public String getDiaElegido() {
        return diaElegido;
    }
    public void setDiaElegido(String diaElegido) {
        this.diaElegido = diaElegido;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}