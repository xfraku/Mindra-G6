import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './landing.html',
  styleUrls: ['./landing.css'],
})
export class Landing implements OnInit {
  menuOpen = false;
  greeting = '';
  heroBg = "linear-gradient(rgba(255,255,255,0.5), rgba(255,255,255,0.5)), url('assets/images/hero.jpg')";
  showLoginModal = false;
  showRegisterModal = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    const h = new Date().getHours();
    this.greeting = h < 12 ? 'Buenos días' : h < 18 ? 'Buenas tardes' : 'Buenas noches';
  }

  // navegación a rutas (usa Autenticador y Register)
  goLogin(): void {
    console.log('goLogin clicked');
    // Si prefieres abrir modal en pagina, usa: this.showLoginModal = true;
    this.router.navigate(['/login']);
  }

  goRegister(): void {
    console.log('goRegister clicked');
    // Si prefieres abrir modal en pagina, usa: this.showRegisterModal = true;
    this.router.navigate(['/register']);
  }

  goHome(): void {
    this.router.navigate(['/landing']);
  }

  // scroll a secciones locales
  scrollTo(id: string): void {
    const el = document.getElementById(id);
    if (el) el.scrollIntoView({ behavior: 'smooth', block: 'start' });
  }

  toggleMenu(): void {
    this.menuOpen = !this.menuOpen;
  }

  // modales locales (opcionales)
  openLoginModal(): void { this.showLoginModal = true; }
  openRegisterModal(): void { this.showRegisterModal = true; }
  closeModals(): void { this.showLoginModal = this.showRegisterModal = false; }

  submitLogin(): void {
    // ejemplo: redirigir al componente autenticador para procesamiento
    this.closeModals();
    this.router.navigate(['/login']);
  }

  submitRegister(): void {
    // ejemplo: redirigir al registro real
    this.closeModals();
    this.router.navigate(['/register']);
  }
}