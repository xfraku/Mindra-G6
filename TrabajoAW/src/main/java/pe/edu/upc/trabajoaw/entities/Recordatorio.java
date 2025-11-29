package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recordatorio")
public class Recordatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRecordatorio;

    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "diaElegido",length = 20, nullable = false)
    private String diaElegido;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private Users usuario;

    public Recordatorio() {
    }

    public Recordatorio(int idRecordatorio, String titulo, String descripcion, String diaElegido, boolean activo, Users usuario) {
        this.idRecordatorio = idRecordatorio;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.diaElegido = diaElegido;
        this.activo = activo;
        this.usuario = usuario;
    }

    public int getIdRecordatorio() {
        return idRecordatorio;
    }

    public void setIdRecordatorio(int idRecordatorio) {
        this.idRecordatorio = idRecordatorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiaElegido() {
        return diaElegido;
    }

    public void setDiaElegido(String diaElegido) {
        this.diaElegido = diaElegido;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
