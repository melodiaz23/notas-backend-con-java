-- Une las tablas de empleados con departamentos y solo muestra las columnas nombre, apellido, 
-- edad, salario de empleados y la columna nombre de departamentos.

SELECT e.nombre, e.apellido, d.nombre FROM empleados e, departamentos d
WHERE e.departamento_id  = d.id; 

-- Une las tablas ventas con la tabla empleados donde se muestren todas las columnas de ventas exceptuando la columna empleado_id y en su lugar 
-- muestres el nombre y apellido de la tabla empleados.

SELECT v.id , v.producto_id , v.cliente_id , v.cantidad , v.precio_unitario , v.monto_total, e.nombre , e.apellido 
FROM empleados e, ventas v 
WHERE v.empleado_id = e.id;

-- Une las tablas ventas con la tabla productos donde se muestren todas las columnas de ventas exceptuando la columna producto_id y en su lugar 
-- muestres la columna nombre de la tabla productos.

SELECT v.id, p.nombre , v.cliente_id , v.cantidad , v.precio_unitario , v.monto_total , v.empleado_id 
FROM ventas v , productos p 
WHERE v.producto_id = p.id ;

-- Une las tablas ventas con la tabla clientes donde se muestren todas las columnas de ventas exceptuando la columna cliente_id y en su 
-- lugar muestres la columna nombre de la tabla clientes.

SELECT v.id , v.producto_id , c.nombre , v.cantidad , v.precio_unitario , v.monto_total , v.empleado_id 
FROM ventas v, clientes c 
WHERE v.cliente_id = c.id;

-- Une las tablas ventas con la tablas empleados y departamentos donde se muestren todas las columnas de ventas exceptuando la columna 
-- empleado_id y en su lugar muestres el nombre y apellido de la tabla empleados y además muestres la columna nombre de la tabla departamentos.

SELECT 
    v.id, 
    v.producto_id, 
    v.cliente_id, 
    v.cantidad, 
    v.precio_unitario, 
    v.monto_total, 
    CONCAT(e.nombre, ' ', e.apellido) AS nombre_empleado, 
    d.nombre AS nombre_departamento
FROM ventas v , empleados e , departamentos d 
WHERE v.empleado_id = e.id AND e.departamento_id = d.id; 


-- Une las tablas ventas, empleados, productos y clientes donde se muestren las columnas de la tabla ventas 
-- reemplazando sus columnas de FOREIGN KEYs con las respectivas columnas de “nombre” de las otras tablas.

SELECT 
	v.id,
	p.nombre Producto,
	c.nombre 'Nombre Cliente',
	v.cantidad,
	v.precio_unitario,
	v.monto_total,
	CONCAT(e.nombre, ' ', e.apellido) 'Nombre Empleado'
FROM ventas v , productos p , clientes c, empleados e  
WHERE v.producto_id = p.id AND v.cliente_id = c.id AND e.departamento_id = e.id;

-- Calcular el salario máximo de los empleados en cada departamento y mostrar el nombre del departamento junto con el salario máximo.

SELECT 
	d.nombre 'Nombre departamento', 
	MAX(e.salario) 'Salario máximo'
FROM empleados e, departamentos d
WHERE e.departamento_id = d.id
GROUP BY d.nombre;

