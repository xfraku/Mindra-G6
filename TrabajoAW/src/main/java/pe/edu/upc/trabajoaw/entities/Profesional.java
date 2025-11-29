package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Profesional")
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfesional;

    @Column(name = "area", length = 50,nullable = false)
    private String area;

    @OneToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Users usuario;

    public Profesional() {
    }

    public Profesional(int idProfesional, String area, Users usuario) {
        this.idProfesional = idProfesional;
        this.area = area;
        this.usuario = usuario;
    }

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

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}

