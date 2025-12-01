import { Component, OnInit } from '@angular/core';
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
import { SitioWeb } from '../../../models/sitioweb';
import { Sitiowebservice } from '../../../services/sitiowebservice';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sitiowebinsert',
  imports: [
    MatFormFieldModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatRadioModule,
    MatTimepickerModule,
    CommonModule
  ],
  templateUrl: './sitiowebinsert.html',
  styleUrl: './sitiowebinsert.css',
})
export class Sitiowebinsert implements OnInit {
  form: FormGroup = new FormGroup({});
  sw: SitioWeb = new SitioWeb();
  id: number = 0;
  today = new Date();
  listaSitiosWeb: SitioWeb[] = [];

  edicion: boolean = false;
  estado: boolean = true;

  tipos: { value: string; viewValue: string }[] = [
    { value: 'Productivo', viewValue: 'Productivo' },
    { value: 'Improductivo', viewValue: 'Improductivo' },
  ];

  constructor(
    private swS: Sitiowebservice,
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

    this.swS.list().subscribe((data) => {
      this.listaSitiosWeb = data;
    });

    this.form = this.formBuilder.group({
      id: [''],
      dominio: ['', [Validators.required, Validators.maxLength(50)]],
      nombre: ['', [Validators.required, Validators.maxLength(50)]],
      clasificacion: ['', [Validators.required, Validators.maxLength(20)]],
    });
  }

  aceptar(): void {
    if (this.form.valid) {
      // Map form values to model
      this.sw.idSitioWeb = this.form.value.id;
      this.sw.dominio = this.form.value.dominio;
      this.sw.nombre = this.form.value.nombre;
      this.sw.clasificacion = this.form.value.clasificacion;

      if (this.edicion) {
        this.swS.update(this.sw).subscribe(() => {
          this.swS.list().subscribe((data) => {
            this.swS.setList(data);
          });
        });
      } else {
        this.swS.insert(this.sw).subscribe((data) => {
          this.swS.list().subscribe((data) => {
            this.swS.setList(data);
          });
        });
      }

      // Navegar a la lista de alertas (ajusta la ruta si tu proyecto la tiene distinta)
      this.router.navigate(['sitiosweb']);
    }
  }

  init() {
    if (this.edicion) {
      this.swS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idSitioWeb),
          dominio: new FormControl(data.dominio),
          nombre: new FormControl(data.nombre),
          clasificacion: new FormControl(data.clasificacion),
        });
      });
    }
  }

  get dominio() { 
    return this.form.get('dominio'); 
  }
  
  get nombre() { 
    return this.form.get('nombre'); 
  }
  
  get clasificacion() { 
    return this.form.get('clasificacion'); 
  }
}
