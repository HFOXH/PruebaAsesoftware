import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServicioDTO } from './models/servicio.model';
import { ComercioDTO } from './models/comercio.model';
import { TurnoDTO } from './models/turno.model';

@Injectable({
  providedIn: 'root'
})
export class ConexionService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getServicios(): Observable<ServicioDTO[]> {
    return this.http.get<ServicioDTO[]>(`${this.baseUrl}/servicios`);
  }

  getComercios(): Observable<ComercioDTO[]> {
    return this.http.get<ComercioDTO[]>(`${this.baseUrl}/comercios`);
  }

  getTodosLosTurnos(): Observable<TurnoDTO[]> {
    return this.http.get<TurnoDTO[]>(`${this.baseUrl}/turnos/all`);
  }

  generarTurnos(servicioId: string, fechaInicio: string, fechaFin: string): Observable<TurnoDTO[]> {
    const params = new HttpParams()
      .set('servicioId', servicioId)
      .set('fechaInicio', fechaInicio)
      .set('fechaFin', fechaFin);

    return this.http.post<TurnoDTO[]>(`${this.baseUrl}/turnos/generar`, null, { params });
  }
}