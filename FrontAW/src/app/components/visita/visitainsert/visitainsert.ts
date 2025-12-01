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
import { MatSelectModule } from '@angular/material/select';
import { Visitas } from '../../../models/visita';
import { Visitaservice } from '../../../services/visitaservice';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Users } from '../../../models/users';
import { SitioWeb } from '../../../models/sitioweb';
import { Userservice } from '../../../services/userservice';
import { Sitiowebservice } from '../../../services/sitiowebservice';

@Component({
  selector: 'app-visitainsert',
  imports: [
    MatFormFieldModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    CommonModule
  ],
  templateUrl: './visitainsert.html',
  styleUrl: './visitainsert.css',
})
export class Visitainsert implements OnInit {
  form: FormGroup = new FormGroup({});
  visita: Visitas = new Visitas();
  id: number = 0;
  today = new Date();
  listaUsuarios: Users[] = [];
  listaSitiosWeb: SitioWeb[] = [];

  edicion: boolean = false;

  constructor(
    private vS: Visitaservice,
    private uS: Userservice,
    private swS: Sitiowebservice,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      id: [''],
      idUsuario: ['', Validators.required],
      idSitioWeb: ['', Validators.required],
      fechaEntrada: ['', Validators.required],
      fechaSalida: ['', Validators.required],
    });

    this.uS.list().subscribe((data) => {
      this.listaUsuarios = data;
    });

    this.swS.list().subscribe((data) => {
      this.listaSitiosWeb = data;
    });

    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });
  }

  aceptar(): void {
    if (this.form.valid) {
      const fechaEntrada = new Date(this.form.value.fechaEntrada);
      const fechaSalida = new Date(this.form.value.fechaSalida);

      if (fechaSalida <= fechaEntrada) {
        alert('La fecha de salida debe ser posterior a la fecha de entrada');
        return;
      }

      this.visita.idVisita = this.form.value.id;
      this.visita.idUsuario = this.form.value.idUsuario;
      this.visita.idSitioWeb = this.form.value.idSitioWeb;
      this.visita.fechaEntrada = this.form.value.fechaEntrada;
      this.visita.fechaSalida = this.form.value.fechaSalida;

      if (this.edicion) {
        this.vS.update(this.visita).subscribe(() => {
          this.vS.list().subscribe((data) => {
            this.vS.setList(data);
          });
          this.router.navigate(['visitas']);
        });
      } else {
        this.vS.insert(this.visita).subscribe(() => {
          this.vS.list().subscribe((data) => {
            this.vS.setList(data);
          });
          this.router.navigate(['visitas']);
        });
      }
    }
  }

  init() {
    if (this.edicion) {
      this.vS.listId(this.id).subscribe((data) => {
        this.form.patchValue({
          id: data.idVisita,
          idUsuario: data.idUsuario,
          idSitioWeb: data.idSitioWeb,
          fechaEntrada: data.fechaEntrada,
          fechaSalida: data.fechaSalida,
        });
      });
    }
  }

  get idUsuario() { 
    return this.form.get('idUsuario'); 
  }
  
  get idSitioWeb() { 
    return this.form.get('idSitioWeb'); 
  }
  
  get fechaEntrada() { 
    return this.form.get('fechaEntrada'); 
  }

  get fechaSalida() { 
    return this.form.get('fechaSalida'); 
  }
}