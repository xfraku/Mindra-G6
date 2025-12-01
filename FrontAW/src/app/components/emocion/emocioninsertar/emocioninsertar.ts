import { Component,OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatTimepickerModule } from '@angular/material/timepicker';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Emocion } from '../../../models/Emocion';
import { Emocionservice } from '../../../services/emocionservice';
@Component({
  selector: 'app-emocioninsertar',
  imports: [MatFormFieldModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatRadioModule,
    MatTimepickerModule,
    CommonModule],
  templateUrl: './emocioninsertar.html',
  styleUrl: './emocioninsertar.css',
})
export class Emocioninsertar {
  form: FormGroup = new FormGroup({});
  e: Emocion = new Emocion();
  id: number = 0;
  today = new Date();
  listaEmocion: Emocion[] = [];

  edicion: boolean = false;

  constructor(
      private es: Emocionservice,
      private router: Router,
      private formBuilder: FormBuilder,
      private route: ActivatedRoute
    ) {}

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });

    this.es.list().subscribe((data) => {
      this.listaEmocion = data;
    });

    this.form = this.formBuilder.group({
      id: [''],
      descripcion: ['', [Validators.required, Validators.maxLength(50)]],
      fraseRelacionada: ['', [Validators.required, Validators.maxLength(50)]],
      iconoUrl: ['', [Validators.required, Validators.maxLength(20)]],
    });
  }
  aceptar(): void {
    if (this.form.valid) {
      // Map form values to model
      this.e.idEmocion = this.form.value.id;
      this.e.descripcion = this.form.value.descripcion;
      this.e.fraseRelacionada = this.form.value.fraseRelacionada;
      this.e.iconoUrl = this.form.value.iconoUrl;

      if (this.edicion) {
        this.es.update(this.e).subscribe(() => {
          this.es.list().subscribe((data) => {
            this.es.setList(data);
          });
        });
      } else {
        this.es.insert(this.e).subscribe((data) => {
          this.es.list().subscribe((data) => {
            this.es.setList(data);
          });
        });
      }

      // Navegar a la lista de alertas (ajusta la ruta si tu proyecto la tiene distinta)
      this.router.navigate(['emocion']);
    }
  }

  init() {
    if (this.edicion) {
      this.es.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idEmocion),
          descripcion: new FormControl(data.descripcion),
          fraseRelacionada: new FormControl(data.fraseRelacionada),
          iconoUrl: new FormControl(data.iconoUrl),
        });
      });
    }
  }

  get descripcion() { 
    return this.form.get('descripcion'); 
  }
  
  get fraseRelacionada() { 
    return this.form.get('fraseRelacionada'); 
  }
  
  get iconoUrl() { 
    return this.form.get('iconoUrl'); 
  }
}
