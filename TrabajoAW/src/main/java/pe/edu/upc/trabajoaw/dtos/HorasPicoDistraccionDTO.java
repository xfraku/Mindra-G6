package pe.edu.upc.trabajoaw.dtos;

public class HorasPicoDistraccionDTO {
    private int horaDia;
    private Double segundosTotales;
    private Double horasTotales;

    public int getHoraDia() {
        return horaDia;
    }

    public void setHoraDia(int horaDia) {
        this.horaDia = horaDia;
    }

    public Double getSegundosTotales() {
        return segundosTotales;
    }

    public void setSegundosTotales(Double segundosTotales) {
        this.segundosTotales = segundosTotales;
    }

    public Double getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(Double horasTotales) {
        this.horasTotales = horasTotales;
    }
}