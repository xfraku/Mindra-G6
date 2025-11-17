import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';import { CommonModule } from '@angular/common';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Alerta } from '../../../models/alerta';
import { Alertaservice } from '../../../services/alertaservice';
@Component({
  selector: 'app-alertasearch',
  imports: [  MatTableModule,
    ReactiveFormsModule,
    CommonModule,
    MatLabel,
    MatFormFieldModule,
    MatInputModule],
  templateUrl: './alertasearch.html',
  styleUrl: './alertasearch.css',
})
export class Alertasearch implements OnInit {
  dataSource: MatTableDataSource<Alerta> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6','c7'];
  nombrebusqueda: string = "";
  mensaje: string = "";  
  form: FormGroup; 

  constructor(private aS: Alertaservice, private fb: FormBuilder) {

    this.form = this.fb.group({
      nombrebusqueda: [''],
    });

  }
  ngOnInit(): void {
    this.aS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
      this.form.get('nombrebusqueda')?.valueChanges.subscribe((value) => {
      this.nombrebusqueda = value; 
      this.buscar(); 
    });
  }
  
buscar() {
  const termino = this.nombrebusqueda.trim();

  if (termino === '') {
    // Si el campo está vacío → listar todos los registros
    this.aS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    return;
  }

  // Si hay texto → buscar coincidencias
  this.aS.searchName(termino).subscribe((data) => {
    this.dataSource = new MatTableDataSource(data);
  });
}
}
