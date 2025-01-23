-- Calcular el monto total de ventas por departamento y mostrar el nombre del departamento junto con el monto total de ventas.

SELECT
	d.nombre 'Nombre departamento',
	SUM(v.monto_total) 'Total ventas'
FROM ventas v, departamentos d, empleados e
WHERE e.departamento_id = d.id AND v.empleado_id = e.id
GROUP BY d.nombre;

-- Encontrar el empleado más joven de cada departamento y mostrar el nombre del departamento junto con la edad del empleado más joven.
SELECT 
	d.nombre 'Nombre departamento', 
	MIN(e.edad) 'Edad'
FROM empleados e, departamentos d
WHERE e.departamento_id = d.id
GROUP BY d.nombre;

-- Calcular el volumen de productos vendidos por cada producto (por ejemplo, menos de 5 “bajo”, menos 8 “medio” 
-- y mayor o igual a 8 “alto”) y mostrar la categoría de volumen junto con la cantidad y el nombre del producto.

SELECT 
	p.nombre 'Nombre del producto',
	SUM(v.cantidad) 'Cantidad vendida',
	CASE 
		WHEN SUM(v.cantidad) < 5 THEN 'Bajo'
		WHEN SUM(v.cantidad) < 8 THEN 'Medio'
		ELSE 'Alto'
	END AS 'Volumen'
FROM ventas v, productos p
WHERE v.producto_id = p.id
GROUP BY p.nombre;

-- Encontrar el cliente que ha realizado el mayor monto total de compras y mostrar su nombre y el monto total.
SELECT 
	c.nombre,
	MAX(v.monto_total) 'Monto Compra'
FROM ventas v, clientes c
WHERE v.cliente_id = v.id
GROUP BY c.nombre;


-- Calcular el precio promedio de los productos vendidos por cada empleado y mostrar el nombre del empleado 
-- junto con el precio promedio de los productos que ha vendido.
SELECT 
	e.nombre, 
	AVG(p.precio) 'Precio promedio'
FROM ventas v, empleados e, productos p
WHERE v.empleado_id = e.id AND v.producto_id = p.id
GROUP BY e.nombre;


-- Encontrar el departamento con el salario mínimo más bajo entre los empleados y mostrar el nombre del 
-- departamento junto con el salario mínimo más bajo.
SELECT 
	d.nombre 'Nombre deparatemnto', 
	MIN(e.salario) 'Salario mínimo'
FROM departamentos d, empleados e
WHERE e.departamento_id = d.id
GROUP BY d.nombre;


-- Encuentra el departamento con el salario promedio más alto entre los empleados mayores de 30 años 
-- y muestra el nombre del departamento junto con el salario promedio. 
-- Limita los resultados a mostrar solo los departamentos con el salario promedio mayor a 3320.

SELECT 
	d.nombre 'Nombre departamento',
	AVG(e.salario) 'Salario promedio'
FROM departamentos d, empleados e
WHERE e.departamento_id = d.id AND e.edad > 30
GROUP BY d.nombre
HAVING AVG(e.salario) > 3320;

