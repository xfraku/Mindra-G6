import { Routes } from '@angular/router';
import { Alerta } from './models/alerta';
import { Alertainsert } from './components/alerta/alertainsert/alertainsert';
import { Recomendacion } from './models/recomendacion';
import { Recomendacioninsert } from './components/recomendacion/recomendacioninsert/recomendacioninsert';
import { Autenticador } from './components/autenticador/autenticador';
import { seguridadGuard } from './guard/seguridad-guard';
import { Home } from './components/home/home';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  }
  ,
  {
    path: 'login',
    component: Autenticador,
  },
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
];
