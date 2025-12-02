import { Component, OnInit, ViewChild } from '@angular/core';
import { Recomendacion } from '../../../models/recomendacion';
import { Recomendacionservice } from '../../../services/recomendacionservice';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatPaginator } from "@angular/material/paginator";

@Component({
  selector: 'app-recomendacionlistar',
  imports: [MatTableModule, CommonModule, RouterLink, MatButtonModule, MatIconModule, MatPaginator,MatPaginatorModule],
  templateUrl: './recomendacionlistar.html',
  styleUrl: './recomendacionlistar.css',
})
export class Recomendacionlistar implements OnInit {
  dataSource: MatTableDataSource<Recomendacion> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private rS: Recomendacionservice) {}

  ngOnInit(): void {
    this.rS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    this.rS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  eliminar(id: number) {
    this.rS.delete(id).subscribe(() => {
      this.rS.list().subscribe((data) => {
        this.rS.setList(data);
      });
    });
  }
}