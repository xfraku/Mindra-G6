package pe.edu.upc.trabajoaw.dtos;

import pe.edu.upc.trabajoaw.entities.Usuario;

public class RecordatorioDTO {
    private int idRecordatorio;
    private String titulo;
    private String descripcion;
    private String diaElegido;
    private String activo;
    private Usuario usuario;

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

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
