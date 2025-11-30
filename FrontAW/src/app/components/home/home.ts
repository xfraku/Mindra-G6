import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { Deezer } from "../deezer/deezer";

@Component({
  selector: 'app-home',
  imports: [MatCardModule, MatIconModule, RouterLink, CommonModule, Deezer],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  
}
