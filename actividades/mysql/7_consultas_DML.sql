USE mi_bd; 

SELECT DISTINCT nombre
FROM empleados;

SELECT DISTINCT correo_electronico
FROM empleados;

SELECT DISTINCT edad
FROM empleados;

SELECT nombre
FROM empleados
WHERE salario > 3200.00;

SELECT *
FROM empleados
WHERE edad = 28;

SELECT *
FROM empleados
WHERE salario < 2700.00;

SELECT *
FROM ventas
WHERE cantidad > 2;

SELECT *
FROM ventas
WHERE precio_unitario = 480.00;

SELECT *
FROM ventas
WHERE monto_total < 1000.00;

SELECT *
FROM ventas
WHERE empleado_id = 1;

SELECT nombre
FROM empleados
WHERE departamento_id = 1 AND salario > 3000.00;


SELECT *
FROM empleados
WHERE departamento_id = 3 OR edad = 32;


SELECT *
FROM ventas
WHERE producto_id = 1 AND cantidad >= 2;


SELECT *
FROM ventas
WHERE empleado_id = 2 OR cliente_id = 1;


SELECT *
FROM ventas
WHERE cliente_id = 2 AND cantidad > 2;


SELECT *
FROM ventas
WHERE empleado_id = 1 AND monto_total > 2000.00;

SELECT nombre
FROM empleados
WHERE edad BETWEEN 29 AND 33;

SELECT *
FROM ventas
WHERE cantidad BETWEEN 2 AND 3;

SELECT *
FROM ventas
WHERE precio_unitario BETWEEN 300.00 AND 500.00;


