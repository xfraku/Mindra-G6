package pe.edu.upc.trabajoaw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EjercicioRelajacion")
public class EjercicioRelajacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEjercicioRelajacion;

    @Column(name = "problema", length = 100, nullable = false)
    private String problema;

    @Column(name = "recomendaciones", length = 100, nullable = false)
    private String recomendaciones;

    @Column(name = "duracion", nullable = false)
    private String duracion;

    public EjercicioRelajacion() {
    }

    public EjercicioRelajacion(int idEjercicioRelajacion, String problema, String recomendaciones, String duracion) {
        this.idEjercicioRelajacion = idEjercicioRelajacion;
        this.problema = problema;
        this.recomendaciones = recomendaciones;
        this.duracion = duracion;
    }

    public int getIdEjercicioRelajacion() {
        return idEjercicioRelajacion;
    }

    public void setIdEjercicioRelajacion(int idEjercicioRelajacion) {
        this.idEjercicioRelajacion = idEjercicioRelajacion;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
