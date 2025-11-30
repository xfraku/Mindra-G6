import { Routes } from '@angular/router';
import { Alerta } from './models/alerta';
import { Alertainsert } from './components/alerta/alertainsert/alertainsert';
import { Recomendacion } from './models/recomendacion';
import { Recomendacioninsert } from './components/recomendacion/recomendacioninsert/recomendacioninsert';
import { Autenticador } from './components/autenticador/autenticador';
import { seguridadGuard } from './guard/seguridad-guard';
import { Home } from './components/home/home';
import { SitioWeb } from './components/sitio-web/sitio-web';
import { Sitiowebinsert } from './components/sitio-web/sitiowebinsert/sitiowebinsert';
import { Visita } from './components/visita/visita';
import { Visitainsert } from './components/visita/visitainsert/visitainsert';
import { Bloqueo } from './components/bloqueo/bloqueo';
import { Bloqueoinsert } from './components/bloqueo/bloqueoinsert/bloqueoinsert';
import { Usuario } from './components/usuario/usuario';
import { Reportetiempodistraccion } from './components/usuario/reportetiempodistraccion/reportetiempodistraccion';
import { Reportetiempoproductivo } from './components/usuario/reportetiempoproductivo/reportetiempoproductivo';

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
];
