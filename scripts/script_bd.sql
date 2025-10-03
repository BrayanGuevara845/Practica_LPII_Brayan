CREATE DATABASE IF NOT EXISTS bd_lpii;

USE bd_lpii;

DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS categoria;

CREATE TABLE categoria (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL
);

CREATE TABLE producto (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  categoria_id INT,
  FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

INSERT INTO categoria (id, nombre) VALUES (1, 'Electrónica');

INSERT INTO producto (nombre, precio, categoria_id) VALUES
('Laptop', 3500, 1),
('Mouse', 50, 1),
('Teclado', 120, 1);
