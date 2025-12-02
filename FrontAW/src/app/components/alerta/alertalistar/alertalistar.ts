import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { Alertaservice } from '../../../services/alertaservice';
import { Alerta } from '../../../models/alerta';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';

@Component({
  selector: 'app-alertalistar',
  imports: [MatTableModule,CommonModule,RouterLink,MatButtonModule,MatIconModule,MatPaginatorModule],
  templateUrl: './alertalistar.html',
  styleUrl: './alertalistar.css',
})
export class Alertalistar implements OnInit {
  dataSource: MatTableDataSource<Alerta> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7','c8','c9','c10'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private aS: Alertaservice) {}

  ngOnInit(): void {
    this.aS.list().subscribe({
      next: (data) => {
        console.log('✅ Datos recibidos:', data);
        console.log('📊 Cantidad de alertas:', data.length);
        console.log('🔍 Primera alerta:', data[0]);
        this.dataSource.data = data;
      },
      error: (error) => {
        console.error('❌ Error al cargar alertas:', error);
      }
    });

    this.aS.getList().subscribe((data) => {
      console.log('📢 Actualización desde Subject:', data);
      this.dataSource.data = data;
    });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  eliminar(id:number){
    this.aS.delete(id).subscribe(data=>{
      this.aS.list().subscribe(data=>{
        this.aS.setList(data)
      })
    })
  }
}
