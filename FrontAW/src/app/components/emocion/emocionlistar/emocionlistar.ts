import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { CommonModule } from '@angular/common';
import { Emocionservice } from '../../../services/emocionservice';
import { Emocion } from '../../../models/Emocion';
@Component({
  selector: 'app-emocionlistar',
  imports: [MatTableModule, CommonModule, RouterLink, MatButtonModule, MatIconModule,MatPaginatorModule],
  templateUrl: './emocionlistar.html',
  styleUrl: './emocionlistar.css',
})
export class Emocionlistar {
  dataSource: MatTableDataSource<Emocion> = new MatTableDataSource();
    displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6'];
  
    @ViewChild(MatPaginator) paginator!: MatPaginator;
  
    constructor(private es: Emocionservice) {}
  
    ngOnInit(): void {
      this.es.list().subscribe((data) => {
        this.dataSource.data = data;
      });
      this.es.getList().subscribe((data) => {
        this.dataSource.data = data;
      });
    }
  
    ngAfterViewInit() {
      this.dataSource.paginator = this.paginator;
    }
  
    eliminar(id: number) {
      this.es.delete(id).subscribe(() => {
        this.es.list().subscribe((data) => {
          this.es.setList(data);
        });
      });
    }
}
