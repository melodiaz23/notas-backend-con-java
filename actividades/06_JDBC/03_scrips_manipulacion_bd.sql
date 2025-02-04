
-- Mostrar nombre, apellido y teléfono de todos los clientes

SELECT nombre_contacto, apellido_contacto, telefono
FROM cliente;

-- Mostrar datos del cliente con un código de cliente dado

SELECT *
FROM cliente 
WHERE codigo_cliente=2;

-- Mostrar los datos de los clientes asociados a un empleado en particular.

SELECT 
   nombre_cliente, 
   nombre_contacto, 
   apellido_contacto, 
   telefono, 
   id_empleado
FROM cliente WHERE id_empleado=13;

-- Consultas en tabla producto

-- Listar productos por debajo de un límite de reposición dado

SELECT nombre, cantidad_en_stock
FROM producto
WHERE cantidad_en_stock < 30;

-- Dado el nombre de la gama, mostrar códigos del producto, nombre del producto, código y nombre de la gama.

SELECT 
   p.codigo_producto,
   p.nombre,
   p.id_gama,
   gp.gama
FROM producto p
JOIN gama_producto gp ON gp.id_gama = p.id_gama
WHERE gp.gama = 'Herramientas';

-- Consultas en tabla pedido

-- Visualizar todos los pedidos de un cliente específico
SELECT 
   c.nombre_cliente, 
   p.id_pedido,
   p.estado
FROM pedido p
JOIN cliente c ON c.id_cliente = p.id_cliente
WHERE c.id_cliente = 4;


-- Visualizar todos los pedidos con un estado específico
SELECT 
   c.nombre_cliente, 
   p.id_pedido, 
   p.estado
FROM pedido p
JOIN cliente c ON c.id_cliente = p.id_cliente
WHERE p.estado = 'Entregado';


