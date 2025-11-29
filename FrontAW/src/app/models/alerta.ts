import{Recomendacion}from'./recomendacion';

export class Alerta{
    idAlerta:number = 0;
    tiempoEstablecido:Date = new Date();
    mensaje:String = '';
    nivelIntervencion:String = '';
    tipo:String = '';
    visible:Boolean = true;
    horaInicio: String = '';
    horaFin: String = '';
    recomendacion: Recomendacion = new Recomendacion();
}