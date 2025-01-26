-- Muestra el nombre y apellido de los empleados que pertenecen al departamento de "Recursos Humanos" 
-- y han realizado más de 5 ventas.

SELECT 
   CONCAT(e.nombre, ' ', e.apellido) 'Nombre empleado',
   COUNT(v.id) 'Cant. de Ventas'
FROM ventas v
JOIN empleados e
   ON v.empleado_id = e.id
JOIN departamentos d
   ON e.departamento_id = d.id
   WHERE d.nombre = 'Recursos Humanos'
GROUP BY e.nombre, e.apellido
HAVING COUNT(v.id) > 5;



-- Muestra el nombre y apellido de todos los empleados junto con la cantidad total de ventas que han realizado, 
-- incluso si no han realizado ventas.
SELECT 
   CONCAT(e.nombre, ' ', e.apellido) 'Nombre empleado',
   COUNT(v.id) 'Cant. de Ventas'
FROM empleados e
LEFT JOIN ventas v
   ON v.empleado_id = e.id
GROUP BY e.nombre, e.apellido;


-- Encuentra el empleado más joven de cada departamento y muestra el nombre del departamento 
-- junto con el nombre y la edad del empleado más joven. 
SELECT 
   CONCAT(e.nombre, ' ', e.apellido) "Nombre empleado",
   d.nombre "Nombre departamento",
   e.edad 'Edad'
FROM empleados e
INNER JOIN departamentos d ON e.departamento_id = d.id
   INNER JOIN (
      SELECT e2.departamento_id "Departamento", MIN(e2.edad) AS "Edad Mínima"
      FROM empleados e2
      GROUP BY e2.departamento_id) e_min 
      ON e_min.Departamento = e.departamento_id 
WHERE e.edad = e_min.`Edad Mínima`;

-- Calcula el volumen de productos vendidos por cada producto (por ejemplo, menos de 5 como "bajo", entre 5 y 10 como "medio",
-- y más de 10 como "alto") y muestra la categoría de volumen junto con la cantidad y el nombre del producto.
SELECT p.nombre "Nombre Producto", SUM(v.cantidad) "Cantidad Vendida",
   CASE
      WHEN SUM(v.cantidad) < 5 THEN "Bajo"
      WHEN SUM(v.cantidad) BETWEEN 5 AND 10 THEN "Medio"
      ELSE "Alto"
   END AS "Volumen Venta"
FROM ventas v
INNER JOIN productos p ON p.id = v.producto_id
GROUP BY `Nombre Producto`
ORDER BY `Cantidad Vendida` DESC;



