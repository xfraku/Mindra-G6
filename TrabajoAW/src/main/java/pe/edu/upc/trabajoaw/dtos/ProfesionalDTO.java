package pe.edu.upc.trabajoaw.dtos;

import pe.edu.upc.trabajoaw.entities.Usuario;

public class ProfesionalDTO {

    private int idProfesional;
    private String area;
    private Usuario usuario;

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
