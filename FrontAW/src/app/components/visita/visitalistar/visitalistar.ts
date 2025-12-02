import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { Visitas } from '../../../models/visita';
import { Visitaservice } from '../../../services/visitaservice';

@Component({
  selector: 'app-visitalistar',
  imports: [MatTableModule, CommonModule, RouterLink, MatButtonModule, MatIconModule,MatPaginatorModule],
  templateUrl: './visitalistar.html',
  styleUrl: './visitalistar.css',
})
export class Visitalistar implements OnInit{
  dataSource: MatTableDataSource<Visitas> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private vS: Visitaservice) {}

  ngOnInit(): void {
    this.vS.list().subscribe((data) => {
      this.dataSource.data = data;
    });
    this.vS.getList().subscribe((data) => {
      this.dataSource.data = data;
    });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  eliminar(id: number) {
    this.vS.delete(id).subscribe(() => {
      this.vS.list().subscribe((data) => {
        this.vS.setList(data);
      });
    });
  }
}