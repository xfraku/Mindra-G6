import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatTimepickerModule } from '@angular/material/timepicker';
import { Bloqueo } from '../../../models/bloqueo';
import { Bloqueoservice } from '../../../services/bloqueoservice';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Users } from '../../../models/users';
import { Userservice } from '../../../services/userservice';
import { Sitiowebservice } from '../../../services/sitiowebservice';
import { SitioWeb } from '../../../models/sitioweb';

@Component({
  selector: 'app-bloqueoinsert',
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
  templateUrl: './bloqueoinsert.html',
  styleUrl: './bloqueoinsert.css',
})
export class Bloqueoinsert implements OnInit{
form: FormGroup = new FormGroup({});
  b: Bloqueo = new Bloqueo();
  id: number = 0;
  today = new Date();
  listaBloqueos: Bloqueo[] = [];
  listaUsuarios: Users[] = [];
  listaSitiosWeb: SitioWeb[] = [];
  

  edicion: boolean = false;
  estado: boolean = true;

  constructor(
    private bS: Bloqueoservice,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private uS: Userservice,
    private swS: Sitiowebservice,
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });

    this.bS.list().subscribe((data) => {
      this.listaBloqueos = data;
    });

    this.uS.list().subscribe((data) => {
      this.listaUsuarios = data;
    });

    this.swS.list().subscribe((data) => {
      this.listaSitiosWeb = data;
    });

    this.form = this.formBuilder.group({
      id: [''],
      sitioweb: ['', [Validators.required, Validators.maxLength(50)]],
      usuario: ['', [Validators.required, Validators.maxLength(50)]],
      fecha: ['', [Validators.required]],
      razon: ['', [Validators.required, Validators.maxLength(100)]],
    });
  }

  aceptar(): void {
    if (this.form.valid) {
      // Map form values to model
      this.b.idBloqueo = this.form.value.id;
      this.b.sitiosWeb.idSitioWeb = this.form.value.sitioweb;
      this.b.usuario.idUsuario = this.form.value.usuario;
      this.b.fecha = this.form.value.fecha;
      this.b.razon = this.form.value.razon;

      if (this.edicion) {
        this.bS.update(this.b).subscribe(() => {
          this.bS.list().subscribe((data) => {
            this.bS.setList(data);
          });
        });
      } else {
        this.bS.insert(this.b).subscribe((data) => {
          this.bS.list().subscribe((data) => {
            this.bS.setList(data);
          });
        });
      }

      // Navegar a la lista de alertas (ajusta la ruta si tu proyecto la tiene distinta)
      this.router.navigate(['bloqueo']);
    }
  }

  init() {
    if (this.edicion) {
      this.bS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idBloqueo),
          sitioweb: new FormControl(data.sitiosWeb.idSitioWeb),
          usuario: new FormControl(data.usuario.idUsuario),
          fecha: new FormControl(data.fecha),
          razon: new FormControl(data.razon),
        });
      });
    }
  }


}
