import { Recomendacion } from "./recomendacion";

export class Alerta{
    idAlerta: number = 0;
    tiempoEstablecido: Date = new Date();
    mensaje: string = '';
    nivelIntervencion: string = '';
    tipo: string = '';
    visible: boolean = true;
    horaInicio: string = '';
    horaFin: string = '';
    recomendacion: Recomendacion = new Recomendacion();
}