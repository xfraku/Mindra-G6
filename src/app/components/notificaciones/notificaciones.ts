import { Component } from '@angular/core';

@Component({
  selector: 'app-notificaciones',
  imports: [],
  templateUrl: './notificaciones.html',
  styleUrl: './notificaciones.css',
})
export class Notificaciones {

  idNotificacion:number=0
  problema:string=""
  fecha:Date=new Date()
  usuario:string=""
  
}
