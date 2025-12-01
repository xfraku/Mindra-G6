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
  selector: 'app-reportetiempodistraccion',
  imports: [BaseChartDirective, MatIconModule, CommonModule],
  templateUrl: './reportetiempodistraccion.html',
  styleUrl: './reportetiempodistraccion.css',
  providers: [provideCharts(withDefaultRegisterables())],
})
export class Reportetiempodistraccion implements OnInit {
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
        text: 'Tiempo Total en Sitios Distractores por Usuario (minutos)',
      },
    },
    scales: {
      y: {
        beginAtZero: true,
        title: {
          display: true,
          text: 'Minutos',
        },
      },
    },
  };

  barChartLabels: string[] = [];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartData: ChartDataset[] = [];

  constructor(private uS: Userservice) {}

  ngOnInit(): void {
    this.uS.getTiempoDistraccionTodosUsuarios().subscribe((data) => {
      if (data.length > 0) {
        this.hasData = true;
        this.barChartLabels = data.map((item) => item.nombre);
        this.barChartData = [
          {
            data: data.map((item) => Math.round(item.tiempo_total)), // Redondear para mejor visualización
            label: 'Tiempo de distracción (minutos)',
            backgroundColor: '#FF6384',
            borderColor: '#FF6384',
            borderWidth: 1,
          },
        ];
      } else {
        this.hasData = false;
      }
    });
  }
}