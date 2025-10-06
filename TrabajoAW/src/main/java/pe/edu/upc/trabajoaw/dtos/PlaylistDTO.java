package pe.edu.upc.trabajoaw.dtos;

public class PlaylistDTO {
    private int idPlaylist;
    private String url;
    private String generoMusic;

    public int getIdPlaylist() {
        return idPlaylist;
    }
    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getGeneroMusic() {
        return generoMusic;
    }
    public void setGeneroMusic(String generoMusic) {
        this.generoMusic = generoMusic;
    }
}