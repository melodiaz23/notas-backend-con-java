-- Agrega nuevo cliente

INSERT INTO clientes (nombre, direccion)
VALUES ('Ana Rodríguez', 'San Martín 2515, Mar del Plata');

-- Realiza la excepción entre la tabla temporal de clientes y la de empleados.

DROP TEMPORARY TABLE IF EXISTS temp_clientes;
CREATE TEMPORARY TABLE temp_clientes
SELECT nombre FROM clientes;

TABLE temp_clientes;

DROP TEMPORARY TABLE IF EXISTS temporal_empleados;
CREATE TEMPORARY TABLE temporal_empleados
SELECT CONCAT(nombre, ' ', apellido) AS 'Nombre Completo' FROM empleados;

TABLE temporal_empleados;

SELECT * FROM temporal_empleados INTERSECT SELECT * FROM temp_clientes;

SELECT * FROM temporal_empleados EXCEPT SELECT * FROM temp_clientes;


-- Crea una tabla temporal escuela secundaria y primaria

CREATE TEMPORARY TABLE escuela_secundaria_temp (
    id INT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad INT,
    grado INT
);

INSERT INTO escuela_secundaria_temp (id, nombre, apellido, edad, grado)
VALUES
    (1, 'Eduardo', 'Sánchez', 16, 10),
    (2, 'Camila', 'Martín', 17, 11),
    (3, 'Manuel', 'Gutiérrez', 15, 9),
    (4, 'Laura', 'García', 16, 10),
    (11, 'Pablo', 'Ortega', 17, 11),
    (12, 'Carmen', 'Ramírez', 15, 9),
    (13, 'Carlos', 'Molina', 16, 10),
    (14, 'Ana', 'Ruiz', 17, 11),
    (15, 'Luis', 'Fernández', 15, 9),
    (16, 'María', 'López', 16, 10);

TABLE escuela_secundaria_temp;


DROP TEMPORARY TABLE IF EXISTS escuela_primaria_temp;
CREATE TEMPORARY TABLE escuela_primaria_temp (
   id INT, 
   nombre VARCHAR(50), 
   apellido VARCHAR(50), 
   edad INT, 
   grado INT
);

TABLE escuela_primaria_temp;


INSERT INTO escuela_primaria_temp (id, nombre, apellido, edad, grado)
VALUES 
    (1, "Alejandro", "González", 11, 5),
    (2, "Isabella", "López", 10, 4),
    (3, "Lucas", "Martínez", 11, 5),
    (4, "Sofía", "Rodríguez", 10, 4),
    (5, "Mateo", "Pérez", 12, 6),
    (6, "Valentina", "Fernández", 12, 6),
    (7, "Diego", "Torres", 10, 4),
    (8, "Martina", "Gómez", 11, 5),
    (9, "Joaquín", "Hernández", 10, 4),
    (10, "Valeria", "Díaz", 11, 5);

-- Realiza la intersección de la escuela primaria y escuela secundaria con el nombre y
--  apellido de los alumnos para saber quienes fueron a ambas escuelas.

SELECT nombre, apellido
FROM escuela_primaria_temp
INTERSECT  
SELECT nombre, apellido
FROM escuela_secundaria_temp;

-- Realiza la excepción de la escuela primaria con la secundaria para saber quienes no 
-- siguieron cursando en dicha escuela secundaria.

-- EXCEPT: Devuelve las filas de la primera consulta que no existen en la segunda consulta. 
-- En este caso, obtiene los alumnos que están en la escuela_primaria_temp pero no en la escuela_secundaria_temp.

SELECT nombre, apellido
FROM escuela_primaria_temp
EXCEPT   
SELECT nombre, apellido
FROM escuela_secundaria_temp;

-- Realiza la excepción de la escuela secundaria con la primaria para saber quienes no siguieron cursando en
-- dicha escuela secundaria.

SELECT nombre, apellido
FROM escuela_secundaria_temp
EXCEPT   
SELECT nombre, apellido
FROM escuela_primaria_temp;

-- Realiza la unión de la escuela primaria y secundaria con la columna grado para saber cuáles son 
-- los grados que abarcan ambas escuelas, y ordénalos de forma descendente.

SELECT grado
FROM escuela_primaria_temp
UNION
SELECT grado
FROM escuela_secundaria_temp
ORDER BY grado DESC;
