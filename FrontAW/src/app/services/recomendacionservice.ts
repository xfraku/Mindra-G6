import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Recomendacion } from '../models/recomendacion';
const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class Recomendacionservice {
  private url = `${base_url}/recomendacion`;

  private listaCambio = new Subject<Recomendacion[]>();
  constructor(private http: HttpClient) {}
  list() {
    return this.http.get<Recomendacion[]>(this.url);
  }
  insert(s: Recomendacion) {
    return this.http.post(this.url, s);
  }
  setList(listaNueva: Recomendacion[]) {
    this.listaCambio.next(listaNueva);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<Recomendacion>(`${this.url}/${id}`);
  }
  update(s: Recomendacion) {
    return this.http.put(`${this.url}`, s, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
}
