import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ConexionService } from '../conexion.service';
import { ServicioDTO } from '../models/servicio.model';

@Component({
  selector: 'app-turns',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './turns.component.html',
  styleUrl: './turns.component.css'
})
export class TurnsComponent implements OnInit {
  servicios: ServicioDTO[] = [];
  comercios: string[] = [];
  turnos: any[] = [];

  turno: {
    comercio: string;
    servicio: ServicioDTO | null;
    fechaInicio: string;
    fechaFin: string;
  } = {
    comercio: '',
    servicio: null,
    fechaInicio: '',
    fechaFin: '',
  };

  constructor(private conexionService: ConexionService) {}

  ngOnInit(): void {
    this.cargarDatos();
  }

  cargarDatos(): void {
    this.conexionService.getServicios().subscribe({
      next: (data) => {
        this.servicios = data;
        this.comercios = [...new Set(data.map(s => s.nombreComercio))];
      },
      error: (err) => {
        console.error('Error cargando servicios:', err);
      }
    });

    this.conexionService.getTodosLosTurnos().subscribe({
      next: (data) => {
        this.turnos = data.map(t => ({
          comercio: t.comercio,
          servicio: t.servicio,
          fecha: t.fecha,
          horaInicio: t.horaInicio,
          horaFin: t.horaFin
        }));
      },
      error: (err) => {
        console.error('Error cargando turnos:', err);
      }
    });
  }

  generarTurno() {
    if (!this.turno.servicio || !this.turno.fechaInicio || !this.turno.fechaFin) {
      alert('Completa todos los campos para generar los turnos.');
      return;
    }
  
    const servicioId = this.turno.servicio.id
  
    this.conexionService.generarTurnos(servicioId, this.turno.fechaInicio, this.turno.fechaFin)
      .subscribe({
        next: (data) => {
          alert('Turnos generados exitosamente');
          this.cargarDatos();
        },
        error: (err) => {
          console.error('Error generando turnos:', err);
        }
      });
  }
}