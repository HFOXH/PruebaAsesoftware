CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Tabla: comercio
CREATE TABLE comercio (
                          id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                          nombre VARCHAR(255) NOT NULL
);

-- Tabla: servicio
CREATE TABLE servicio (
                          id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                          nombre VARCHAR(255) NOT NULL,
                          hora_apertura TIME NOT NULL,
                          hora_cierre TIME NOT NULL,
                          duracion_minutos INT NOT NULL,
                          comercio_id UUID REFERENCES comercio(id)
);

-- Tabla: turno
CREATE TABLE turno (
                       id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                       fecha DATE NOT NULL,
                       hora_inicio TIME NOT NULL,
                       hora_fin TIME NOT NULL,
                       servicio_id UUID REFERENCES servicio(id),
                       comercio_id UUID REFERENCES comercio(id)
);
