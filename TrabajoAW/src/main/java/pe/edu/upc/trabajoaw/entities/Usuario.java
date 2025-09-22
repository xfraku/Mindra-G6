package pe.edu.upc.trabajoaw.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido",length = 50,nullable = false)
    private String apellido;

    @Column(name = "correo",length = 50,nullable = false)
    private String correo;

    @Column(name = "contrasenia",length = 50,nullable = false)
    private String contrasenia;

    @Column(name = "telefono",length = 9,nullable = true)
    private String telefono;

    @Column(name = "genero",length = 50,nullable = true)
    private String genero;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellido, String correo, String contrasenia, String telefono, String genero) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.genero = genero;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
