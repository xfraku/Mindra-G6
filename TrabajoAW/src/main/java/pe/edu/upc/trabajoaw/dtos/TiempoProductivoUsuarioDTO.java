package pe.edu.upc.trabajoaw.dtos;

public class TiempoProductivoUsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private int tiempo_total_minutos;

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

    public int getTiempo_total_minutos() {
        return tiempo_total_minutos;
    }

    public void setTiempo_total_minutos(int tiempo_total_minutos) {
        this.tiempo_total_minutos = tiempo_total_minutos;
    }
}
