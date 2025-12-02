import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatTimepickerModule } from '@angular/material/timepicker';
import { Alerta } from '../../../models/alerta';
import { Alertaservice } from '../../../services/alertaservice';
import { Recomendacionservice } from '../../../services/recomendacionservice';
import { Recomendacion } from '../../../models/recomendacion';
// ...existing code...

@Component({
  selector: 'app-alertainsert',
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
  ],
  templateUrl: './alertainsert.html',
  styleUrl: './alertainsert.css',
})
export class Alertainsert implements OnInit {
  form: FormGroup = new FormGroup({});
  a: Alerta = new Alerta();
  id: number = 0;
  today = new Date();
  listaRecomendaciones: Recomendacion[] = [];

  edicion: boolean = false;
  estado: boolean = true;

  tipos: { value: string; viewValue: string }[] = [
    { value: 'Advertencia', viewValue: 'Advertencia' },
    { value: 'Peligro', viewValue: 'Peligro' },
    { value: 'Notificacion', viewValue: 'Notificacion' },
  ];

  constructor(
    private aS: Alertaservice,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private rS: Recomendacionservice
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });

    this.rS.list().subscribe((data) => {
      this.listaRecomendaciones = data;
    });

    this.form = this.formBuilder.group({
      id: [''],
      tiempoEstablecido: ['', Validators.required],
      mensaje: ['', Validators.required],
      nivelIntervencion: ['', Validators.required],
      tipo: ['', Validators.required],
      visible: [false, Validators.required],
      horaInicio: ['', Validators.required],
      horaFin: ['', Validators.required],
      recomendacion:['',Validators.required]
    });
  }

  aceptar(): void {
    if (this.form.valid) {
      // Map form values to model
      this.a.idAlerta = this.form.value.id;
      this.a.tiempoEstablecido = this.form.value.tiempoEstablecido;
      this.a.mensaje = this.form.value.mensaje;
      this.a.nivelIntervencion = this.form.value.nivelIntervencion;
      this.a.tipo = this.form.value.tipo;
      this.a.visible = this.form.value.visible;
      // Convert horaInicio (Date or string) to "HH:MM"
      const hi: Date = new Date(this.form.value.horaInicio);
      const hiHoras = hi.getHours().toString().padStart(2, '0');
      const hiMin = hi.getMinutes().toString().padStart(2, '0');
      this.a.horaInicio = `${hiHoras}:${hiMin}`;
      const hf: Date = new Date(this.form.value.horaFin);
      const hfHoras = hf.getHours().toString().padStart(2, '0');
      const hfMin = hf.getMinutes().toString().padStart(2, '0');
      this.a.horaFin = `${hfHoras}:${hfMin}`;
      this.a.recomendacion.idRecomendacion = this.form.value.recomendacion;
      if (this.edicion) {
        this.aS.update(this.a).subscribe(() => {
          this.aS.list().subscribe((data) => {
            this.aS.setList(data);
          });
        });
      } else {
        this.aS.insert(this.a).subscribe((data) => {
          this.aS.list().subscribe((data) => {
            this.aS.setList(data);
          });
        });
      }
      // Navegar a la lista de alertas (ajusta la ruta si tu proyecto la tiene distinta)
      this.router.navigate(['alertas']);
    }
  }

  init() {
    if (this.edicion) {
      this.aS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idAlerta),
          tiempoEstablecido: new FormControl(data.tiempoEstablecido),
          mensaje: new FormControl(data.mensaje),
          nivelIntervencion: new FormControl(data.nivelIntervencion),
          tipo: new FormControl(data.tipo),
          visible: new FormControl(data.visible),
          horaInicio: new FormControl(data.horaInicio),
          horaFin: new FormControl(data.horaFin),
          recomendacion: new FormControl(data.recomendacion.idRecomendacion),
        });
      });
    }
  }
}