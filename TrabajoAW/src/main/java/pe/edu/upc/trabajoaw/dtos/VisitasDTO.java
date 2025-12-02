package pe.edu.upc.trabajoaw.dtos;

import pe.edu.upc.trabajoaw.entities.Recomendacion;

import java.time.Instant;

public class VisitasDTO {
    private int idVisita;
    private int idUsuario;
    private int idSitioWeb;
    private Instant fechaEntrada;
    private Instant fechaSalida;

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSitioWeb() {
        return idSitioWeb;
    }

    public void setIdSitioWeb(int idSitioWeb) {
        this.idSitioWeb = idSitioWeb;
    }

    public Instant getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Instant fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Instant getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Instant fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}