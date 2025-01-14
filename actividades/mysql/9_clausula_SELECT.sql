SELECT *
FROM empleados
WHERE id IN (1,3,5);


SELECT *
FROM productos
WHERE id IN (2,4,6);

SELECT *
FROM ventas
WHERE cliente_id IN (1,3,5);


-- Clausula like
SELECT * 
FROM empleados
WHERE UPPER(nombre) LIKE 'L%';

-- Alternativa UPPER/LOWER
SELECT *
FROM productos
WHERE nombre COLLATE utf8mb4_general_ci LIKE '%Telefono%';


SELECT *
FROM clientes
WHERE direccion LIKE '%calle%';

-- Order By

SELECT *
FROM empleados
ORDER BY salario; 

SELECT *
FROM productos
ORDER BY nombre DESC;

SELECT *
FROM ventas 
ORDER BY cantidad ASC, precio_unitario DESC;

-- Limit

SELECT *
FROM productos
ORDER BY precio DESC 
LIMIT 5;

SELECT *
FROM empleados
ORDER BY apellido 
LIMIT 10; 

SELECT *
FROM ventas
ORDER BY monto_total DESC 
LIMIT 3;

-- Ejercicios AS

SELECT nombre, salario, salario * 1.10 AS 'Aumento del 10%'
FROM empleados;

SELECT (SELECT nombre FROM clientes WHERE id = ventas.cliente_id) AS 'Cliente', 
		SUM(monto_total) AS 'Monto total gastado'
FROM ventas
GROUP BY cliente_id;

SELECT CONCAT(nombre, ' ', apellido) AS 'Nombre y apellido'
FROM empleados;

-- Ejercicios CASE

SELECT nombre, precio,
CASE
WHEN precio >= 500 THEN 'Caro'
WHEN precio >= 200 AND precio < 500 THEN 'Medio'
ELSE 'Bajo'
END AS "Categoria Precio"

FROM productos ORDER BY precio DESC;


SELECT nombre,edad,
CASE
WHEN edad < 30 THEN 'Joven'
WHEN edad >= 30 AND edad <= 40 THEN 'Adulto'
ELSE 'Mayor'
END AS "Categoria Edad"

FROM empleados ORDER BY edad DESC;

SELECT id,cantidad,
CASE
WHEN cantidad < 3 THEN 'Poca cantidad'
WHEN cantidad >= 3 AND cantidad < 6 THEN 'Cantidad moderada'
ELSE 'Mucha cantidad'
END AS "Tamaño venta"

FROM ventas ORDER BY SUM(cantidad) DESC;

SELECT nombre,
CASE
WHEN nombre LIKE "A%" THEN 'Empieza por A'
WHEN nombre LIKE "M%" THEN 'Empieza por M'
ELSE 'Otro'
END AS "Inicial"

FROM clientes ORDER BY nombre ASC;

SELECT nombre,salario,
CASE
WHEN salario >=3500 THEN 'Salario alto'
WHEN salario >=3000 AND salario <3500 THEN 'Salario medio'
ELSE 'Salario Bajo'
END AS "Categoria Salario"

FROM empleados ORDER BY salario ASC;
