import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Reportetiempodistraccion } from "./reportetiempodistraccion/reportetiempodistraccion";

@Component({
  selector: 'app-usuario',
  imports: [RouterOutlet, Reportetiempodistraccion],
  templateUrl: './usuario.html',
  styleUrl: './usuario.css',
})
export class Usuario {
  constructor(public route: ActivatedRoute) {}
}
