import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Alerta } from '../models/alerta';
const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class Alertaservice {
  private url = `${base_url}/alertas`;

  private listaCambio = new Subject<Alerta[]>();
  constructor(private http: HttpClient) {}
  list() {
    return this.http.get<Alerta[]>(`${this.url}/listar`);
  }
  insert(a: Alerta) {
    return this.http.post(`${this.url}/nuevo`, a);
  }
  setList(listaNueva: Alerta[]) {
    this.listaCambio.next(listaNueva);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<Alerta>(`${this.url}/${id}`);
  }
  update(a: Alerta) {
    return this.http.put(`${this.url}/modificar`, a, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
}
