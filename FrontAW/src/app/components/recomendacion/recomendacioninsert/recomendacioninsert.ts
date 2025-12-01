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
import { Recomendacion } from '../../../models/recomendacion';
import { Recomendacionservice } from '../../../services/recomendacionservice';
// ...existing code...

@Component({
  selector: 'app-recomendacioninsert',
  imports: [
    MatFormFieldModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatRadioModule,
  ],
  templateUrl: './recomendacioninsert.html',
  styleUrl: './recomendacioninsert.css',
})
export class Recomendacioninsert implements OnInit {
  form: FormGroup = new FormGroup({});
  r: Recomendacion = new Recomendacion();
  id: number = 0;

  edicion: boolean = false;

  constructor(
    private rS: Recomendacionservice,
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

    this.form = this.formBuilder.group({
      id: [''],
      descripcion: ['', Validators.required],
    });
  }

  aceptar(): void {
    if (this.form.valid) {
      this.r.idRecomendacion = this.form.value.id;
      this.r.descripcion = this.form.value.descripcion;

      if (this.edicion) {
        this.rS.update(this.r).subscribe(() => {
          this.rS.list().subscribe((data) => {
            this.rS.setList(data);
          });
        });
      } else {
        this.rS.insert(this.r).subscribe(() => {
          this.rS.list().subscribe((data) => {
            this.rS.setList(data);
          });
        });
      }

      this.router.navigate(['recomendacion']);
    }
  }

  init() {
    if (this.edicion) {
      this.rS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idRecomendacion),
          descripcion: new FormControl(data.descripcion),
        });
      });
    }
  }
}