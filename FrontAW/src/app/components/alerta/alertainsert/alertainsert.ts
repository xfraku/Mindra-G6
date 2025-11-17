import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { Alerta } from '../../../models/alerta';
import { Alertaservice } from '../../../services/alertaservice';
import { Recomendacionservice } from '../../../services/recomendacionservice';
import { Recomendacion } from '../../../models/recomendacion';

@Component({
  selector: 'app-alertainsert',
  imports: [MatFormFieldModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatRadioModule],
  templateUrl: './alertainsert.html',
  styleUrl: './alertainsert.css',
})
export class Alertainsert implements OnInit {
  form: FormGroup = new FormGroup({});
  soft: Alerta = new Alerta();
  id: number = 0;
  today = new Date();
  listaRecomendaciones:Recomendacion[]=[]

  edicion: boolean = false;
  estado: boolean = true;

  tipos: { value: string; viewValue: string }[] = [
    { value: 'OpenSource', viewValue: 'OpenSource' },
    { value: 'Privado', viewValue: 'Privado' },
  ];

  constructor(
    private aS: Alertaservice,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private rS: Recomendacionservice,
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });

   this.rS.list().subscribe(data=>{
    this.listaRecomendaciones=data
   })

    this.form = this.formBuilder.group({
      id: [''],
      nombre: ['', Validators.required],
      version: ['', Validators.required],
      tipo: ['', Validators.required],
      licencia: ['', Validators.required],
      estado: [false, Validators.required],
      fecha: ['', Validators.required],
      foraneo:['',Validators.required]
    });
  }
  aceptar(): void {
    if (this.form.valid) {
      this.soft.idAlerta = this.form.value.id;
      this.soft.tiempoEstablecido = this.form.value.tiempoEstablecido;
      this.soft.mensaje = this.form.value.mensaje;
      this.soft.nivelIntervencion = this.form.value.nivelIntervencion;
      this.soft.tipo = this.form.value.tipo;
      this.soft.visible = this.form.value.visible;
      this.soft.horaInicio = this.form.value.horaInicio;
      this.soft.horaFin = this.form.value.horaFin;
      this.soft.recomendacion.idRecomendacion=this.form.value.foraneo
      if (this.edicion) {
        this.aS.update(this.soft).subscribe(() => {
          this.aS.list().subscribe((data) => {
            this.aS.setList(data);
          });
        });
      } else {
        this.aS.insert(this.soft).subscribe((data) => {
          this.aS.list().subscribe((data) => {
            this.aS.setList(data);
          });
        });
      }
      this.router.navigate(['recomendacion']);
    }
  }
  init() {
    if (this.edicion) {
      this.aS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idAlerta),
          testablecido: new FormControl(data.tiempoEstablecido),
          mensaje: new FormControl(data.mensaje),
          nivelIntervencion: new FormControl(data.nivelIntervencion),
          tipo: new FormControl(data.tipo),
          visible: new FormControl(data.visible),
          horaInicio: new FormControl(data.horaInicio),
          horaFin: new FormControl(data.horaFin),
          foraneo:new FormControl(data.recomendacion.idRecomendacion)
        });
      });
    }
  }
}
