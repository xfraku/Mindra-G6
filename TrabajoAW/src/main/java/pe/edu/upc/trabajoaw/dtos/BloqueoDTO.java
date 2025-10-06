package pe.edu.upc.trabajoaw.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.trabajoaw.entities.SitiosWeb;
import pe.edu.upc.trabajoaw.entities.Usuario;

import java.time.Instant;

public class BloqueoDTO {
    private int idBloqueo;
    private SitiosWeb sitiosWeb;
    private Usuario usuario;
    private Instant fecha;
    private String razon;

    public int getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(int idBloqueo) {
        this.idBloqueo = idBloqueo;
    }

    public SitiosWeb getSitiosWeb() {
        return sitiosWeb;
    }

    public void setSitiosWeb(SitiosWeb sitiosWeb) {
        this.sitiosWeb = sitiosWeb;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}
