-- Este script crea la base de datos y la tabla empleados
CREATE DATABASE IF NOT EXISTS mi_bd;

USE mi_bd;

CREATE TABLE IF NOT EXISTS empleados(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad INT,
    salario DECIMAL(10,2) DEFAULT 0.00,
    fecha_contratacion DATE
);
