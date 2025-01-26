-- https://app.egg.live/globant-backend-2024/7nmPsnEpTPNVMRPbRCW84l

-- Encuentra los nombres de los clientes que han realizado 
-- compras de productos con un precio superior a la media de precios de todos los productos.

SELECT (SELECT nombre FROM clientes )
FROM ventas v 

SELECT nombre
FROM clientes c
WHERE c.id IN (SELECT ventas.cliente_id 
            FROM ventas 
            WHERE ventas.precio_unitario > (SELECT AVG(precio) FROM productos)); 

