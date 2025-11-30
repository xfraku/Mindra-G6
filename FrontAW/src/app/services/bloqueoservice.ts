import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Subject } from 'rxjs';
import { Bloqueo } from '../models/bloqueo';
import { HttpClient } from '@angular/common/http';
const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class Bloqueoservice {
  private url = `${base_url}/bloqueo`;

  private listaCambio = new Subject<Bloqueo[]>();
  constructor(private http: HttpClient) {}
  list() {
    return this.http.get<Bloqueo[]>(`${this.url}/listar`);
  }
  insert(b: Bloqueo) {
    return this.http.post(`${this.url}/nuevo`, b);
  }
  setList(listaNueva: Bloqueo[]) {
    this.listaCambio.next(listaNueva);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<Bloqueo>(`${this.url}/${id}`);
  }
  update(b: Bloqueo) {
    return this.http.put(`${this.url}/modificar`, b, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
}
