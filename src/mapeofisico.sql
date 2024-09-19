CREATE DATABASE sistema_revistas;
USE sistema_revistas;

CREATE TABLE usuarios (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          password VARCHAR(100) NOT NULL,
                          rol ENUM('SUSCRIPTOR', 'EDITOR', 'ADMINISTRADOR') NOT NULL
);

CREATE TABLE revistas (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          titulo VARCHAR(100) NOT NULL,
                          descripcion TEXT NOT NULL,
                          categoria VARCHAR(50) NOT NULL,
                          autor INT,  -- Relación con el usuario
                          costo_por_dia DECIMAL(10, 2) NOT NULL,
                          FOREIGN KEY (autor) REFERENCES usuarios(id) ON DELETE CASCADE
);

CREATE TABLE suscripciones (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               id_suscriptor INT,  -- Relación con el usuario
                               id_revista INT,      -- Relación con la revista
                               fecha_suscripcion DATE NOT NULL,
                               FOREIGN KEY (id_suscriptor) REFERENCES usuarios(id) ON DELETE CASCADE,
                               FOREIGN KEY (id_revista) REFERENCES revistas(id) ON DELETE CASCADE
);

CREATE TABLE anuncios (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          tipo ENUM('Texto', 'Texto e Imagen', 'Video') NOT NULL,
                          contenido TEXT NOT NULL,
                          fecha_inicio DATE NOT NULL,
                          fecha_fin DATE NOT NULL,
                          precio DECIMAL(10, 2) NOT NULL
);
