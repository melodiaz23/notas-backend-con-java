USE mi_bd;

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Laptop'),
	(SELECT id FROM clientes WHERE nombre = 'Juan Perez'),
	2,
	(SELECT precio FROM productos WHERE nombre = 'Laptop'),
	(SELECT id FROM empleados WHERE nombre = 'Ana' AND apellido = 'Rodríguez')
);

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Teléfono móvil'),
	(SELECT id FROM clientes WHERE nombre = 'María García'),
	3,
	(SELECT precio FROM productos WHERE nombre = 'Teléfono móvil'),
	(SELECT id FROM empleados WHERE nombre = 'Carlos' AND apellido = 'López')
);

-- 3

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Impresora'),
	(SELECT id FROM clientes WHERE nombre = 'Carlos Sánchez'),
	1,
	(SELECT precio FROM productos WHERE nombre = 'Impresora'),
	(SELECT id FROM empleados WHERE nombre = 'Marta' AND apellido = 'Ramirez')
);

-- 4

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Laptop'),
	(SELECT id FROM clientes WHERE nombre = 'Ana López'),
	1,
	(SELECT precio FROM productos WHERE nombre = 'Laptop'),
	(SELECT id FROM empleados WHERE nombre = 'Carlos' AND apellido = 'López')
);

-- 5

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Tablet'),
	(SELECT id FROM clientes WHERE nombre = 'Juan Perez'),
	2,
	(SELECT precio FROM productos WHERE nombre = 'Tablet'),
	(SELECT id FROM empleados WHERE nombre = 'Luis' AND apellido = 'Fernandez')
);

-- 6 

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Teléfono móvil'),
	(SELECT id FROM clientes WHERE nombre = 'María García'),
	1,
	(SELECT precio FROM productos WHERE nombre = 'Teléfono móvil'),
	(SELECT id FROM empleados WHERE nombre = 'Marta' AND apellido = 'Ramirez')
);


-- 7 

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (
	(SELECT id FROM productos WHERE nombre = 'Impresora'),
	(SELECT id FROM clientes WHERE nombre = 'Carlos Sánchez'),
	2,
	(SELECT precio FROM productos WHERE nombre = 'Impresora'),
	(SELECT id FROM empleados WHERE nombre = 'Lorena' AND apellido = 'Guzmán')
);


SELECT * FROM ventas;












