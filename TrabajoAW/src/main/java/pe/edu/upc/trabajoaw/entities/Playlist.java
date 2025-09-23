package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPlaylist;

    @Column(name = "url", length = 200, nullable = false)
    private String url;

    @Column(name = "generoMusic", length = 50, nullable = false)
    private String generoMusic;

    public Playlist() {
    }

    public Playlist(int idPlaylist, String url, String generoMusic) {
        this.idPlaylist = idPlaylist;
        this.url = url;
        this.generoMusic = generoMusic;
    }

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
