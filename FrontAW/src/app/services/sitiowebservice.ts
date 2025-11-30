import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SitioWeb } from '../models/sitioweb';
const base_url = environment.base;

@Injectable({
  providedIn: 'root',
})
export class Sitiowebservice {
  private url = `${base_url}/sitiosweb`;

  private listaCambio = new Subject<SitioWeb[]>();
  constructor(private http: HttpClient) {}
  list() {
    return this.http.get<SitioWeb[]>(`${this.url}/listar`);
  }
  insert(s: SitioWeb) {
    return this.http.post(`${this.url}/nuevo`, s);
  }
  setList(listaNueva: SitioWeb[]) {
    this.listaCambio.next(listaNueva);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<SitioWeb>(`${this.url}/${id}`);
  }
  update(s: SitioWeb) {
    return this.http.put(`${this.url}/modificar`, s, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
}
