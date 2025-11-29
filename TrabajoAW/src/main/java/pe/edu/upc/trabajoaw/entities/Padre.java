package pe.edu.upc.trabajoaw.entities;


import jakarta.persistence.*;
import org.springframework.security.core.userdetails.User;

@Entity
@Table(name = "Padre")
public class Padre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPadre;

    @OneToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Users usuario;

    public Padre() {
    }

    public Padre(int idPadre, Users usuario) {
        this.idPadre = idPadre;
        this.usuario = usuario;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
