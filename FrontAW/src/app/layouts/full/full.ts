import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Menu } from '../../components/menu/menu';

@Component({
  selector: 'app-full',
  imports: [RouterOutlet, Menu],
  templateUrl: './full.html',
  styleUrl: './full.css',
})
export class Full {

}
