import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { Bloqueo } from '../../../models/bloqueo';
import { Bloqueoservice } from '../../../services/bloqueoservice';

@Component({
  selector: 'app-bloqueolistar',
  imports: [MatTableModule, CommonModule, RouterLink, MatButtonModule, MatIconModule,MatPaginatorModule],
  templateUrl: './bloqueolistar.html',
  styleUrl: './bloqueolistar.css',
})
export class Bloqueolistar implements OnInit{
dataSource: MatTableDataSource<Bloqueo> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private bS: Bloqueoservice) {}

  ngOnInit(): void {
    this.bS.list().subscribe((data) => {
      this.dataSource.data = data;
    });
    this.bS.getList().subscribe((data) => {
      this.dataSource.data = data;
    });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  eliminar(id: number) {
    this.bS.delete(id).subscribe(() => {
      this.bS.list().subscribe((data) => {
        this.bS.setList(data);
      });
    });
  }
}
