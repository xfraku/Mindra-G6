import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Bloqueolistar } from "./bloqueolistar/bloqueolistar";

@Component({
  selector: 'app-bloqueo',
  imports: [RouterOutlet, Bloqueolistar],
  templateUrl: './bloqueo.html',
  styleUrl: './bloqueo.css',
})
export class Bloqueo {
  constructor(public route: ActivatedRoute) {}
}
