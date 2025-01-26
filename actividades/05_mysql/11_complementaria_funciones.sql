-- Clausula IN

-- Busca los empleados que trabajan en los departamentos 2 o 3.
SELECT CONCAT(nombre, ' ', apellido) Empleado, departamento_id Departamento
FROM empleados
WHERE departamento_id IN (2,3);
-- Trae a los clientes que no tengan los IDs 2, 4 o 6.
SELECT nombre Cliente, id ID
FROM clientes
WHERE id NOT IN (2,4,6);
-- Busca los productos cuyos precios son 350.00, 480.00 o 800.00.
SELECT nombre Nombre, precio Precio
FROM productos
WHERE precio IN (350.00, 480.00, 800.00);

-- Clausula LIKE

-- Busca los empleados cuyos correos electrónicos terminan en "mail.com".
SELECT CONCAT(nombre, ' ', apellido) Empleado, correo_electronico Correo
FROM empleados
WHERE correo_electronico LIKE '%@mail.com';
-- Encuentra los productos cuyos nombres tengan exactamente 6 caracteres.
SELECT nombre Nombre
FROM productos
WHERE LENGTH(nombre) = 6;
-- OR con like: 
SELECT nombre AS Nombre
FROM productos
WHERE nombre LIKE '______';
-- Busca los clientes cuyos nombres tengan una "a" en la tercera posición 
SELECT nombre Cliente
FROM clientes
WHERE nombre LIKE '__a%';

-- Clausula ORDER BY; 

-- Ordena los clientes por nombre de manera ascendente y luego por dirección de manera descendente.
SELECT nombre Cliente, direccion Dirección
FROM clientes
ORDER BY nombre ASC, direccion DESC;
-- Ordena los empleados por fecha_contratación de manera descendente.
SELECT CONCAT(nombre, ' ', apellido) Empleado, fecha_contratacion "Fecha contrato"
FROM empleados
ORDER BY fecha_contratacion DESC;
-- Ordena los productos por precio de manera ascendente.
SELECT nombre Nombre, precio Precio
FROM productos
ORDER BY precio ASC;

-- Función MAX()

-- Encuentra el precio máximo de un producto.
SELECT MAX(precio) "Precio Mayor"
FROM productos;
-- Encuentra el monto total máximo de una venta.
SELECT MAX(monto_total) "Valor máximo"
FROM ventas;
-- Encuentra el ID de cliente con el valor máximo.
SELECT MAX(id) "ID Mayor"
FROM clientes;

-- FUNCION MIN()

-- Encuentra el precio mínimo de un producto.
SELECT MIN(precio) "Precio Min. Productos"
FROM productos;
-- Encuentra el monto total mínimo de una venta.
SELECT MIN(monto_total) "Monto total mínimo"
FROM ventas;
-- Encuentra el ID de cliente con el valor mínimo.
SELECT MIN(id) "ID Mínimo"
FROM clientes;

-- FUNCIÓN COUNT()

-- Cuenta cuántos clientes tienen la palabra "López" en su nombre.
SELECT COUNT(*) "Cant. Apellido López"
FROM clientes
WHERE nombre LIKE '%López%';
-- Cuenta cuántas ventas fueron realizadas por el empleado con el id 9.
SELECT COUNT(*) "Cant. de Ventas"
FROM ventas
WHERE empleado_id = 9;
-- Cuenta cuántos productos tienen un nombre que contiene la palabra "Digital".
SELECT COUNT(*) "Cant. de Productos"
FROM productos
WHERE nombre LIKE '%Digital%';

-- Función SUM()

-- Calcula la suma de cantidades de productos vendidos por empleado.
SELECT empleado_id "ID empleado", SUM(cantidad) "Cant. Productos Vendidos"
FROM ventas
GROUP BY `ID empleado`;
-- Calcula la suma de salarios de empleados en el Departamento 1.
SELECT SUM(salario) "Salario total"
FROM empleados
WHERE departamento_id = 1;
-- Calcula la suma de precios de productos vendidos al cliente con id 2.
SELECT SUM(precio_unitario) "Suma de precios"
FROM ventas
WHERE cliente_id = 2;

-- Función AVG()

-- Calcula el precio promedio de productos con un precio superior a $200.
SELECT AVG(precio) "Precio Promedio"
FROM productos
WHERE precio > 200;
-- Calcula el salario promedio de los empleados en el Departamento 1.
SELECT AVG(salario) "Salario Promedio"
FROM empleados
WHERE departamento_id = 1;
-- Calcula la cantidad promedio de productos vendidos por empleado.
SELECT empleado_id, AVG(cantidad) "Cantidad Promedio"
FROM ventas 
GROUP BY empleado_id;

-- Función GROUP BY()

-- Agrupa las ventas por cliente y muestra el monto total gastado por cada cliente.
SELECT cliente_id "ID del cliente", SUM(monto_total) "Monto gastado"
FROM ventas
GROUP BY cliente_id;
-- Encuentra el salario máximo por departamento.
SELECT departamento_id "ID departamento", MAX(salario) "Salario Máximo"
FROM empleados
GROUP BY departamento_id;
-- Encuentra el salario mínimo por departamento.
SELECT departamento_id "ID departamento", MIN(salario) "Salario Mínimo"
FROM empleados
GROUP BY departamento_id;
-- Obtén la suma total de salarios por departamento.
SELECT departamento_id "ID departamento", SUM(salario) "Salario Total"
FROM empleados
GROUP BY departamento_id;
-- Encuentra la cantidad total de productos vendidos por empleado.
SELECT empleado_id "ID Empleado", SUM(cantidad) "Cant. Vendida"
FROM ventas
GROUP BY `ID Empleado`;

-- Función HAVING()

-- Encuentra los departamentos con al menos 2 empleados con una edad menor de 30 años.
SELECT departamento_id "ID departamento", COUNT(*) "Cantidad Empleados"
FROM empleados
WHERE edad < 30
GROUP BY departamento_id
HAVING COUNT(*) >= 2;
-- Muestra los clientes que han gastado más de $2,000 en total en compras.
SELECT cliente_id "ID del Cliente", SUM(monto_total) "Total Gastado"
FROM ventas
GROUP BY `ID del Cliente`
HAVING SUM(monto_total) > 200;

-- AS

-- Crea una consulta que muestre la edad de los empleados junto con la edad aumentada en 5 años 
-- y que esta nueva columna se llame “Edad en 5 años”.
SELECT edad, edad+5 AS "Edad Aumentada"
FROM empleados;
-- Muestra el monto total de ventas junto con el monto total aumentado en un 21%  
-- y que esta nueva columna se llame “Precio + IVA”.
SELECT SUM(monto_total) "Monto total", SUM(monto_total) * 1.21 AS "Precio + IVA"
FROM ventas;
-- Crea una consulta que muestre el nombre del producto y su precio unitario 
-- precedido con el signo “$ ” y que esta nueva columna se llame “precio con formato”.
SELECT nombre, CONCAT('$ ',precio) AS "Precio con formato"
FROM productos;


-- Función LIMIT()

-- Muestra los 5 clientes con los IDs más bajos.
SELECT id, nombre
FROM clientes 
ORDER BY id LIMIT 5;
-- Muestra los 3 productos más vendidos.
SELECT p.nombre "Producto", SUM(v.cantidad) "Cant. Vendida"
FROM ventas v
JOIN productos p ON v.producto_id = p.id
GROUP BY `Producto`
ORDER BY SUM(v.cantidad) DESC LIMIT 3;

-- Muestra los 5 empleados más jóvenes.
SELECT nombre, edad
FROM empleados
ORDER BY edad LIMIT 5; 

-- Función CASE()

-- Crea una consulta que muestre el nombre de los productos y los categorice como "Laptop" 
-- si el nombre contiene la palabra "Laptop", "Teléfono" si contiene la palabra "Teléfono",
-- y "Otros" en otros casos.
SELECT nombre, 
   case 
      WHEN nombre LIKE "%Laptop%" THEN "Laptop"
      WHEN nombre LIKE "%Teléfono%" THEN "Teléfono"
      ELSE "Otros"
   end AS "Categoría"
FROM productos;
-- Crea una consulta que muestre el ID del producto y los clasifique en categorías según la 
-- cantidad total de ventas de cada producto en la tabla 'ventas'.
-- Si la suma de la cantidad de ventas (SUM(cantidad)) es mayor o igual a 9, 
-- la categoría es 'Alto Volumen'. 
-- Si la suma de la cantidad de ventas está entre 4 y 8 (inclusive), 
-- la categoría es 'Medio Volumen'.
-- En otros casos, la categoría es 'Bajo Volumen'.
-- Recuerda agrupar por producto_id y mostrar el resultado en orden descendente por la suma de
-- la cantidad de ventas.
SELECT producto_id "ID del producto", SUM(cantidad) "Cant. Vendida", 
   case 
      WHEN SUM(cantidad) >= 9 THEN "Alto Volumen" 
      WHEN SUM(cantidad) > 4 AND SUM(cantidad) <=8 THEN "Medio Volumen"
      ELSE "Bajo Volumen"
   end AS "Categoría"
FROM ventas
GROUP BY producto_id
ORDER BY SUM(cantidad) DESC;

-- Crea una consulta que muestre el ID de la venta y los categorice como "Venta pequeña"
-- si el monto total es menor que $500, "Venta mediana" si es mayor o igual a $500 y menor que $1500,
-- y "Venta grande" en otros casos.
SELECT id "ID de venta", SUM(monto_total) "Monto Total", 
   CASE 
      WHEN SUM(monto_total) < 500.00 THEN "Venta Pequeña" 
      WHEN SUM(monto_total) >= 500.00 AND SUM(monto_total) < 1500.00 THEN "Venta Mediana"
      ELSE "Venta grande"
   END AS "Categoría"
FROM ventas
GROUP BY id
ORDER BY SUM(monto_total) DESC;

-- Crea una consulta que muestre el nombre de los clientes y los categorice como "Dirección larga" si 
-- la longitud de su dirección es mayor o igual a 30 caracteres, "Dirección mediana" si es mayor o 
-- igual a 20 y menor que 30 caracteres, y "Dirección corta" en otros casos.
SELECT nombre "Nombre Cliente", 
   CASE 
      WHEN LENGTH(direccion) >= 30 THEN "Dirección Larga"
      WHEN LENGTH(direccion) >= 20 AND LENGTH(direccion) < 30 THEN "Direccion Mediana"
      ELSE "Dirección Corta"
   END AS "Categoría dirección"
FROM clientes;

-- Crea una consulta que muestre el nombre de los empleados y los categorice como "Ventas" 
-- si pertenecen al departamento 1, "Recursos Humanos" si pertenecen al departamento 2, y "Contabilidad" 
-- si pertenecen al departamento 3.
SELECT nombre,
   CASE
      WHEN departamento_id = 1 THEN "Ventas"
      WHEN departamento_id = 2 THEN "Recursos Humanos"
      WHEN departamento_id = 3 THEN "Contabilidad"
   END AS Departamento
FROM empleados;


-- Crea una consulta que muestre el nombre de los productos y los categorice de la siguiente manera:
-- Si el nombre del producto está en la lista ('Laptop', 'Reloj de Pulsera Inteligente', 
-- 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital',
-- 'Impresora', 'Tablet', 'Teléfono móvil') y el precio es mayor o igual a 1000, 
-- la categoría es 'Tecnología cara'.

-- Si el nombre del producto está en la lista anterior y el precio está entre 500 y 999 (inclusive),
-- la categoría es 'Tecnología gama media'.

-- Si el nombre del producto está en la lista anterior y el precio es menor a 500, 
-- la categoría es 'Tecnología barata'.

-- Si el precio es mayor o igual a 1000 y el nombre del producto no está en la lista, la categoría es 'Caro'.

-- Si el precio está entre 500 y 999 (inclusive) y el nombre del producto no está en la lista, 
-- la categoría es 'Medio'.

-- Si el precio es menor a 500 y el nombre del producto no está en la lista, la categoría es 'Barato'.

SELECT nombre,
   CASE
      WHEN nombre IN ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') 
         AND precio >= 1000  THEN "Tecnología Cara"
      WHEN nombre IN ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') 
         AND precio BETWEEN 500 AND 999 THEN "Tecnología Gama Media"
      WHEN nombre IN ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') 
         AND precio < 500  THEN "Tecnología Barata"
      WHEN nombre NOT IN ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') 
         AND precio >= 1000  THEN "Caro"
      WHEN nombre NOT IN ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') 
         AND precio BETWEEN 500 AND 999 THEN "Medio"
      WHEN nombre NOT IN ('Laptop', 'Reloj de Pulsera Inteligente', 'Reproductor de Blu-ray', 'Auriculares Bluetooth', 'Smart TV 55 Pulgadas', 'Cámara Digital', 'Impresora', 'Tablet', 'Teléfono móvil') 
         AND precio < 500  THEN "Barato"
   END AS "Categoría"
FROM productos;