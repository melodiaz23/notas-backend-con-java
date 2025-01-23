-- Encuentra el nombre y apellido de los empleados junto con la cantidad total de ventas que han realizado.
SELECT 
   CONCAT(e.nombre, ' ', e.apellido) 'Nombre empleado', 
   SUM(v.cantidad) 'Cantidad de Unidades'
FROM empleados e
JOIN ventas v
ON v.empleado_id = e.id
GROUP BY e.nombre, e.apellido;

-- Calcula el monto total vendido a cada cliente y muestra el nombre del cliente, su dirección y el monto total.

SELECT 
   c.nombre, 
   c.direccion, 
   SUM(v.monto_total) 'Monto total'
FROM ventas v
JOIN clientes c
ON v.cliente_id = c.id 
GROUP BY v.cliente_id
ORDER BY SUM(v.monto_total) DESC;

-- Encuentra los productos vendidos por cada empleado en el departamento de "Ventas" y 
-- muestra el nombre del empleado junto con el nombre de los productos que han vendido.

SELECT 
   concat(e.nombre," ",e.apellido) Empleado, 
   p.nombre 'Producto', 
   COUNT(p.nombre) 'Cant. de productos' -- Se agrupa para contar la cantidad de productos vendidos por empleado
FROM ventas v
JOIN empleados e 
   ON v.empleado_id = e.id
JOIN productos p 
   ON v.producto_id = p.id
JOIN departamentos d
   ON e.departamento_id = d.id
   WHERE d.nombre = 'Ventas'
GROUP BY e.nombre, e.apellido, p.nombre
ORDER BY Empleado;


-- Encuentra el nombre del cliente, el nombre del producto y
-- la cantidad comprada de productos con un precio superior a $500.

SELECT 
   c.nombre Cliente, 
   p.nombre Producto, 
   SUM(v.cantidad) 'Cantidad de productos' 
FROM ventas v
JOIN productos p 
   ON v.producto_id = p.id 
JOIN clientes c 
   ON v.cliente_id = c.id
   WHERE p.precio > 500
GROUP BY c.nombre, 
         p.nombre;

-- Parte 2

-- Calcula la cantidad de ventas por departamento, incluso si el departamento no tiene ventas.

SELECT 
   d.nombre 'Departamento', 
   COUNT(v.id) 'Cantidad Ventas'
FROM departamentos d
LEFT JOIN empleados e 
   ON d.id = e.departamento_id
LEFT JOIN ventas v 
   ON e.id = v.empleado_id
GROUP BY d.nombre;


-- Encuentra el nombre y la dirección de los clientes que han comprado más de 3 productos distintos 
-- y muestra la cantidad de productos comprados.

SELECT 
   c.nombre 'Nombre cliente', 
   c.direccion 'Direccion', 
   COUNT(DISTINCT v.producto_id) 'Cant. Productos'
FROM clientes c
JOIN ventas v ON c.id = v.cliente_id
GROUP BY c.nombre, c.direccion
HAVING count(DISTINCT v.producto_id) > 3 ; 

-- Calcula el monto total de ventas realizadas por cada departamento 
-- y muestra el nombre del departamento junto con el monto total de ventas.

SELECT 
   d.nombre 'Nombre departamento', 
   SUM(v.monto_total) 'Suma total'
FROM departamentos d
LEFT JOIN empleados e 
   ON e.departamento_id = d.id
LEFT JOIN ventas v 
   ON v.empleado_id = e.id
GROUP BY d.nombre;










