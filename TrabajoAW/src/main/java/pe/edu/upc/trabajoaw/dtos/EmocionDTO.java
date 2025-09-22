package pe.edu.upc.trabajoaw.dtos;

public class EmocionDTO {
    private int idEmocion;
    private String descripcion;
    private String frase;
    private String iconoUrl;

    public int getIdEmocion() {
        return idEmocion;
    }

    public void setIdEmocion(int idEmocion) {
        this.idEmocion = idEmocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getIconoUrl() {
        return iconoUrl;
    }

    public void setIconoUrl(String iconoUrl) {
        this.iconoUrl = iconoUrl;
    }
}
