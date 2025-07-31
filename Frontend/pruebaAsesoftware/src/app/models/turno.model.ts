export interface TurnoDTO {
    comercio: any;
    id: string;
    fecha: string;
    horaInicio: string;
    horaFin: string;
    servicio: {
      id: string;
      nombre: string;
    };
  }