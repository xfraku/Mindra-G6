package pe.edu.upc.trabajoaw.dtos;

public class SonidoDTO {
    private int idSonido;
    private String archivoUrl;
    private String tipo;

    public int getIdSonido() {
        return idSonido;
    }
    public void setIdSonido(int idSonido) {
        this.idSonido = idSonido;
    }
    public String getArchivoUrl() {
        return archivoUrl;
    }
    public void setArchivoUrl(String archivoUrl) {
        this.archivoUrl = archivoUrl;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}