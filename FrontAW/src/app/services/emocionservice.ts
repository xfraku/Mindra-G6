import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Emocion } from '../models/Emocion';
const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class Emocionservice {
  private url = `${base_url}/emocion`;

  private listaCambio = new Subject<Emocion[]>();
  constructor(private http: HttpClient) {}
  list() {
    return this.http.get<Emocion[]>(`${this.url}/listar`);
  }
  insert(e: Emocion) {
    return this.http.post(`${this.url}/nuevo`, e);
  }
  setList(listaNueva: Emocion[]) {
    this.listaCambio.next(listaNueva);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<Emocion>(`${this.url}/${id}`);
  }
  update(s: Emocion) {
    return this.http.put(`${this.url}/modificar`, s, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
}
