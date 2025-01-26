-- Utiliza TABLE para consultar la tabla productos de manera simple, 
-- ordenando los productos de forma descendente por precio y solo 10 filas.

TABLE productos ORDER BY precio DESC LIMIT 10;

-- Crea una tabla temporal de los empleados donde unifiques su nombre y apellido en una sola columna.

DROP TEMPORARY TABLE IF EXISTS temporal_empleados;
CREATE TEMPORARY TABLE temporal_empleados
SELECT CONCAT(nombre, ' ', apellido) AS 'Nombre Completo' FROM empleados;

TABLE temporal_empleados;

-- Crea una tabla temporal de la tabla clientes donde solo tengas la columna nombre.
DROP TEMPORARY TABLE IF EXISTS temp_clientes;
CREATE TEMPORARY TABLE temp_clientes
SELECT nombre FROM clientes;

TABLE temp_clientes;

-- Realiza la unión entre las tablas temporales de empleados y clientes usando TABLE.

TABLE temporal_empleados UNION TABLE temp_clientes;

-- Crea una tabla temporal escuela primaria

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








