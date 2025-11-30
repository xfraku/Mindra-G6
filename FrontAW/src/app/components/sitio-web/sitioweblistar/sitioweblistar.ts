import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { SitioWeb } from '../../../models/sitioweb';
import { Sitiowebservice } from '../../../services/sitiowebservice';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';

@Component({
  selector: 'app-sitioweblistar',
  imports: [MatTableModule, CommonModule, RouterLink, MatButtonModule, MatIconModule,MatPaginatorModule],
  templateUrl: './sitioweblistar.html',
  styleUrl: './sitioweblistar.css',
})
export class Sitioweblistar implements OnInit{
  dataSource: MatTableDataSource<SitioWeb> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private swS: Sitiowebservice) {}

  ngOnInit(): void {
    this.swS.list().subscribe((data) => {
      this.dataSource.data = data;
    });
    this.swS.getList().subscribe((data) => {
      this.dataSource.data = data;
    });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  eliminar(id: number) {
    this.swS.delete(id).subscribe(() => {
      this.swS.list().subscribe((data) => {
        this.swS.setList(data);
      });
    });
  }
}
