-- Encontrar la cantidad de productos vendidos por cada empleado y mostrar el nombre del empleado junto con la 
-- cantidad de productos vendidos.

SELECT e.nombre, SUM(v.cantidad)
FROM ventas v, empleados e
WHERE v.empleado_id = e.id
GROUP BY e.nombre;

-- Calcular el monto total de ventas por cada cliente y mostrar el nombre del cliente junto con 
-- el monto total de sus compras.
SELECT c.nombre, SUM(v.monto_total)
FROM clientes c, ventas v
WHERE v.cliente_id = c.id
GROUP BY c.nombre;

-- Encontrar el producto más caro vendido y mostrar su nombre y precio.
SELECT p.nombre, v.precio_unitario
FROM ventas v, productos p
WHERE v.producto_id = p.id
ORDER BY v.precio_unitario DESC LIMIT 1;

-- Calcular el salario promedio de los empleados en cada departamento y mostrar el nombre del departamento junto con el salario promedio.
SELECT d.nombre, AVG(e.salario)
FROM departamentos d, empleados e
WHERE e.departamento_id = d.id
GROUP BY d.nombre;

-- Encontrar la cantidad total de ventas realizadas por cada empleado y mostrar el nombre y apellido
-- del empleado junto con la cantidad total de ventas.
SELECT CONCAT(e.nombre, ' ', e.apellido) "Nombre empleado", COUNT(v.id) "Cant. Ventas"
FROM empleados e, ventas v
WHERE e.id = v.empleado_id
GROUP BY `Nombre empleado`;

-- Limita los resultados a mostrar solo a los empleados que hayan realizado más de 5 ventas y 
-- ordenarlos de forma descendente con respecto a la cantidad de ventas.
SELECT CONCAT(e.nombre, ' ', e.apellido) "Nombre empleado", COUNT(v.id) "Cant. Ventas"
FROM empleados e, ventas v
WHERE e.id = v.empleado_id
GROUP BY `Nombre empleado`
HAVING `Cant. Ventas` > 5
ORDER BY `Cant. Ventas` DESC;


-- Calcula el monto total vendido por cada empleado y muestra el nombre del empleado junto con el monto total. 
-- Usa la cláusula HAVING para filtrar a aquellos empleados que hayan vendido más de 10 productos en total. 
-- Muestra el resultado en orden descendente según el monto total vendido.
SELECT CONCAT(e.nombre, ' ', e.apellido) "Nombre empleado", SUM(v.monto_total) "Total Venta"
FROM empleados e, ventas v
WHERE e.id = v.empleado_id
GROUP BY `Nombre empleado`
HAVING SUM(v.cantidad) > 10
ORDER BY `Total Venta` DESC;


-- Encuentra el monto total vendido a cada cliente y muestra el nombre del cliente junto con el monto total. 
-- Usa la cláusula HAVING para filtrar a aquellos clientes cuyo monto total promedio en sus compras sea superior a $1500.
-- Muestra el resultado en orden descendente según el monto total vendido.
SELECT c.nombre, SUM(v.monto_total) "Total Venta"
FROM clientes c, ventas v
WHERE c.id = v.empleado_id
GROUP BY c.nombre
HAVING AVG(v.monto_total) > 1500.00
ORDER BY `Total Venta` DESC;



-- Calcula la cantidad total de ventas realizadas a cada cliente y muestra el nombre del cliente junto con 
-- la cantidad total de ventas. Limita los resultados a mostrar solo a los clientes que hayan realizado 
-- más de 3 ventas ordénalos de forma descendente según la cantidad de ventas.
SELECT c.nombre, COUNT(v.id) "Cant. Venta"
FROM clientes c, ventas v
WHERE c.id = v.empleado_id
GROUP BY c.nombre
HAVING `Cant. Venta` > 3
ORDER BY `Cant. Venta` DESC;


-- Encuentra los productos más caros vendidos (precio mayor a 1000), muestra su nombre y precio y 
-- ordenarlos de forma descendente por precio.
SELECT DISTINCT p.nombre, v.precio_unitario
FROM productos p, ventas v
WHERE v.producto_id = p.id AND v.precio_unitario > 1000
ORDER BY v.precio_unitario DESC;


