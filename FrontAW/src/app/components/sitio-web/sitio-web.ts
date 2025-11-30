import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Sitioweblistar } from "./sitioweblistar/sitioweblistar";

@Component({
  selector: 'app-sitio-web',
  imports: [RouterOutlet, Sitioweblistar],
  templateUrl: './sitio-web.html',
  styleUrl: './sitio-web.css',
})
export class SitioWeb {
  constructor(public route: ActivatedRoute) {}
}
