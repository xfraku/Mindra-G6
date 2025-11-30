import { MatIconModule } from '@angular/material/icon';
import { Userservice } from '../../../services/userservice';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { Component, OnInit } from '@angular/core';
import {
  BaseChartDirective,
  provideCharts,
  withDefaultRegisterables,
} from 'ng2-charts';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-reportetiempoproductivo',
  imports: [BaseChartDirective, MatIconModule, CommonModule],
  templateUrl: './reportetiempoproductivo.html',
  styleUrl: './reportetiempoproductivo.css',
  providers: [provideCharts(withDefaultRegisterables())],
})
export class Reportetiempoproductivo implements OnInit {
  hasData = false;

  barChartOptions: ChartOptions = {
    responsive: true,
    plugins: {
      legend: {
        display: true,
        position: 'top',
      },
      title: {
        display: true,
        text: 'Tiempo Productivo por Usuario (minutos)',
      },
    },
  };

  barChartLabels: string[] = [];
  barChartType: ChartType = 'pie';
  barChartLegend = true;
  barChartData: ChartDataset[] = [];

  constructor(private uS: Userservice) {}

  ngOnInit(): void {
    this.uS.getTiempoProductivoTodosUsuarios().subscribe((data) => {
      if (data.length > 0) {
        this.hasData = true;
        this.barChartLabels = data.map(
          (item) => `${item.nombre} ${item.apellido}`
        );
        this.barChartData = [
          {
            data: data.map((item) => Math.round(item.tiempo_total_minutos)),
            label: 'Tiempo productivo (minutos)',
            backgroundColor: [
              '#4CAF50',
              '#8BC34A',
              '#CDDC39',
              '#009688',
              '#00BCD4',
              '#03A9F4',
              '#2196F3',
              '#3F51B5',
              '#673AB7',
              '#9C27B0',
            ],
            borderColor: '#fff',
            borderWidth: 2,
          },
        ];
      } else {
        this.hasData = false;
      }
    });
  }
}