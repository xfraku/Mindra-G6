import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Emocionlistar } from './emocionlistar/emocionlistar';

@Component({
  selector: 'app-emocion',
  imports: [RouterOutlet, Emocionlistar],
  templateUrl: './emocion.html',
  styleUrl: './emocion.css',
})
export class Emocion {
  constructor(public route: ActivatedRoute) {}
}
