--  Calcula la fecha del primer y último pago realizado por cada uno de los clientes. 
-- El listado deberá mostrar el nombre y los apellidos de cada cliente.
SELECT 
   CONCAT(c.nombre_contacto, ' ', c.apellido_contacto) "Nombre Contacto",
   MIN(p2.fecha_pago) "Primer Pago", 
   MAX(p2.fecha_pago) "Último pago"
FROM cliente c
JOIN pedido p ON c.codigo_cliente = p.codigo_cliente
JOIN pago p2 ON c.codigo_cliente = p2.codigo_cliente
GROUP BY `Nombre Contacto`;

-- Lista las ventas totales de los productos que hayan facturado más de 3000 euros.
-- Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).

SELECT 
   p2.nombre, 
   SUM(dp.cantidad) "Cantidad Total", 
   SUM(dp.precio_unidad*dp.cantidad) "Total Facturado",
   SUM(dp.precio_unidad*dp.cantidad)*1.21 "Total + Iva" 
FROM pedido p
JOIN detalle_pedido dp ON dp.codigo_pedido = p.codigo_pedido
JOIN producto p2 ON dp.codigo_producto = p2.codigo_producto
GROUP BY p2.nombre
HAVING SUM(dp.precio_unidad*dp.cantidad) > 3000;

-- Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER JOIN).
SELECT 
   CONCAT(c.nombre_contacto, ' ', c.apellido_contacto) "Nombre Contacto",
   c.limite_credito "Límite crédito", 
   SUM(p.total) "Total pagos"
FROM cliente c, pago p
WHERE c.codigo_cliente = p.codigo_cliente
GROUP BY `Nombre Contacto`, `Límite crédito`
HAVING c.limite_credito > `Total pagos`;


-- Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria.
SELECT 
   CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) "Nombre Empleado",
   e.email "Email"
FROM empleado e
WHERE e.codigo_jefe = (SELECT e2.codigo_empleado FROM empleado e2
                     WHERE e2.nombre = "Alberto" AND e2.apellido1="Soria");


-- Devuelve un listado que muestre solamente los clientes que sí han realizado ningún pago.
-- (Recomendamos resolver este ejercicio con Subconsultas del tipo IN y NOT IN).

SELECT CONCAT (c.nombre_contacto, ' ', c.apellido_contacto) "Nombre Cliente"
FROM cliente c
WHERE c.codigo_cliente NOT IN (SELECT DISTINCT p.codigo_cliente FROM pago p);




