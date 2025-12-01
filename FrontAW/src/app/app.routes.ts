import { Routes } from '@angular/router';
import { Alertainsert } from './components/alerta/alertainsert/alertainsert';
import { Recomendacioninsert } from './components/recomendacion/recomendacioninsert/recomendacioninsert';
import { Autenticador } from './components/autenticador/autenticador';
import { seguridadGuard } from './guard/seguridad-guard';
import { Home } from './components/home/home';

export const routes: Routes = [
  {
    path: '',
    component: Empty,
    children: [
      { path: '', redirectTo: 'landing', pathMatch: 'full' },
      { path: 'landing', component: Landing },
      { path: 'login', component: Autenticador },
      { path: 'register', component: Register }
    ],
  },
  {
    path: '',
    component: Full,
    children: [
      {
        path: 'alertas',
        component: Alerta,
        children: [
          { path: 'news', component: Alertainsert },
          { path: 'edits/:id', component: Alertainsert },
        ],
        canActivate: [seguridadGuard],
      },
      {
        path: 'recomendacion',
        component: Recomendacion,
        children: [
          { path: 'news', component: Recomendacioninsert },
          { path: 'edits/:id', component: Recomendacioninsert },
    ],
      canActivate: [seguridadGuard],
    },
    {
       
    path: 'sitiosweb',
    component: SitioWeb,
      children: [
      { path: 'news', component: Sitiowebinsert },
      { path: 'edits/:id', component: Sitiowebinsert },

    ],
      canActivate: [seguridadGuard],
    },
    {
       
    path: 'visitas',
    component: Visita,
      children: [
      { path: 'news', component: Visitainsert },
      { path: 'edits/:id', component: Visitainsert },

    ],
      canActivate: [seguridadGuard],
    },
    {
       
    path: 'bloqueo',
    component: Bloqueo,
      children: [
      { path: 'news', component: Bloqueoinsert },
      { path: 'edits/:id', component: Bloqueoinsert },

    ],
      canActivate: [seguridadGuard],
    },
    {
       
    path: 'usuario',
    component: Usuario,
      children: [
      { path: 'totalTiempoDistraccionUsuario', component: Reportetiempodistraccion },
      { path: 'tiempoProductivoUsuario', component: Reportetiempoproductivo }

        ],
        canActivate: [seguridadGuard],
      },
      {
        path: 'homes',
        component: Home,
        canActivate: [seguridadGuard],
      },
    ],
  },
];
