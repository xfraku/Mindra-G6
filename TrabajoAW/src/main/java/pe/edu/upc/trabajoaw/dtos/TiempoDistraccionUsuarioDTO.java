package pe.edu.upc.trabajoaw.dtos;

import jakarta.persistence.Column;

public class TiempoDistraccionUsuarioDTO {
    private int idUsuario;
    private String nombre;
    private int tiempo_total;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo_total() {
        return tiempo_total;
    }

    public void setTiempo_total(int tiempo_total) {
        this.tiempo_total = tiempo_total;
    }
}
