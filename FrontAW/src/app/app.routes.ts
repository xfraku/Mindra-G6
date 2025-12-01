import { Routes } from '@angular/router';
import { Alertainsert } from './components/alerta/alertainsert/alertainsert';
import { Recomendacioninsert } from './components/recomendacion/recomendacioninsert/recomendacioninsert';
import { Autenticador } from './components/autenticador/autenticador';
import { seguridadGuard } from './guard/seguridad-guard';
import { Home } from './components/home/home';
import { Alerta } from './components/alerta/alerta';
import { Recomendacion } from './components/recomendacion/recomendacion';
import { Empty } from './layouts/empty/empty';
import { Landing } from './components/landing/landing';
import { Full } from './layouts/full/full';
import { Register } from './components/register/register';

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
        path: 'homes',
        component: Home,
        canActivate: [seguridadGuard],
      },
    ],
  },
];
