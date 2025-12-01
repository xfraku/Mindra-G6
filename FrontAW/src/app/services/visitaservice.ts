import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Subject } from 'rxjs';
import { Visitas } from '../models/visita';
import { HttpClient } from '@angular/common/http';
const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class Visitaservice {
  private url = `${base_url}/visitas`;

  private listaCambio = new Subject<Visitas[]>();
  constructor(private http: HttpClient) {}
  list() {
    return this.http.get<Visitas[]>(`${this.url}/listar`);
  }
  insert(v: Visitas) {
    return this.http.post(`${this.url}/nuevo`, v);
  }
  setList(listaNueva: Visitas[]) {
    this.listaCambio.next(listaNueva);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<Visitas>(`${this.url}/${id}`);
  }
  update(v: Visitas) {
    return this.http.put(`${this.url}/modificar`, v, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
}
