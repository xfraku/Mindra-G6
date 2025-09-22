package pe.edu.upc.trabajoaw.dtos;

import pe.edu.upc.trabajoaw.entities.Usuario;

public class PadreDTO {

    private int idPadre;
    private Usuario usuario;

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
