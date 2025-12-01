import { SitioWeb } from "./sitioweb";
import { Users } from "./users";

export class Bloqueo {
  idBloqueo : number = 0;
  sitiosWeb: SitioWeb = new SitioWeb();
  usuario: Users = new Users();
  fecha: Date = new Date();
  razon: string = '';
}