-- Agrega nuevo cliente

INSERT INTO clientes (nombre, direccion)
VALUES ('Ana Rodríguez', 'San Martín 2515, Mar del Plata');

-- actualizar valores

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



-- Encuentra los nombres de los clientes que han realizado 
-- compras de productos con un precio superior a la media de precios de todos los productos.

SELECT (SELECT nombre FROM clientes )
FROM ventas v 

SELECT nombre
FROM clientes c
WHERE c.id IN (SELECT ventas.cliente_id 
				FROM ventas 
				WHERE ventas.precio_unitario > (SELECT AVG(precio) FROM productos)); 

