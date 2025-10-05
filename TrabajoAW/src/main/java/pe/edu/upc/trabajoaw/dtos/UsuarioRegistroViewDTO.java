package pe.edu.upc.trabajoaw.dtos;

public class UsuarioRegistroViewDTO {

    private String emocion;
    private int codigoEmocion;
    private int usuario;
    private long totalRegistros;
    private long posicion;

    // 🔹 Constructor vacío (recomendado para frameworks y serialización)
    public UsuarioRegistroViewDTO() {
    }

    // 🔹 Constructor con parámetros
    public UsuarioRegistroViewDTO(String emocion, int codigoEmocion, int usuario, long totalRegistros, long posicion) {
        this.emocion = emocion;
        this.codigoEmocion = codigoEmocion;
        this.usuario = usuario;
        this.totalRegistros = totalRegistros;
        this.posicion = posicion;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public int getCodigoEmocion() {
        return codigoEmocion;
    }

    public void setCodigoEmocion(int codigoEmocion) {
        this.codigoEmocion = codigoEmocion;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public long getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public long getPosicion() {
        return posicion;
    }

    public void setPosicion(long posicion) {
        this.posicion = posicion;
    }

    // 🔹 Método toString() para depuración
    @Override
    public String toString() {
        return "UsuarioRegistroViewDTO{" +
                "emocion='" + emocion + '\'' +
                ", codigoEmocion=" + codigoEmocion +
                ", usuario=" + usuario +
                ", totalRegistros=" + totalRegistros +
                ", posicion=" + posicion +
                '}';
    }
}
