import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { Deezer } from "../deezer/deezer";
import { Loginservice } from '../../services/loginservice';

@Component({
  selector: 'app-home',
  imports: [MatCardModule, MatIconModule, RouterLink, CommonModule, Deezer],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  role: string = '';

  constructor(private loginService: Loginservice) {
    this.role = this.loginService.showRole();
  }

  isAdmin() {
    return this.role === 'ADMIN';
  }

  isEstudiante() {
    return this.role === 'ESTUDIANTE';
  }
}
