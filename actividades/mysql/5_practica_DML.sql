USE mi_bd;

INSERT INTO productos(nombre, precio)
VALUES ('Teléfono móvil', 450.00);

INSERT INTO clientes(nombre, direccion)
VALUES ('María García', 'Constitución 456, Luján');

ALTER TABLE empleados 
MODIFY correo_electronico VARCHAR(100)
GENERATED ALWAYS AS (concat(nombre, apellido, '@mail.com')) STORED;

INSERT INTO empleados(nombre, apellido, edad, salario, departamento_id)
VALUES ('Luis', 'Fernandez', 28, 2800.00, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

UPDATE productos
SET precio = 1350.00
WHERE nombre = 'Laptop';

UPDATE clientes
SET direccion = 'Alberti 1789, Mar del Plata'
WHERE nombre = 'Juan Perez';

UPDATE empleados
SET salario = salario * 1.05;

INSERT INTO productos(nombre, precio)
VALUES ('Tablet', 350.00);

INSERT INTO clientes(nombre, direccion)
VALUES ('Ana López', 'Beltrán 1452, Godoy Cruz');

INSERT INTO empleados(nombre, apellido, edad, salario, departamento_id)
VALUES ('Marta', 'Ramirez', 32, 3100.00, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

UPDATE productos
SET precio = 480.00
WHERE nombre = 'Teléfono móvil';

UPDATE clientes
SET direccion = 'Avenida 789, Ciudad del Este'
WHERE nombre = 'María García';

UPDATE empleados
SET salario = salario * 1.07
WHERE departamento_id = (SELECT id FROM departamentos WHERE nombre = 'Ventas');

INSERT INTO productos(nombre, precio)
VALUES ('Impresora', 280.00);

INSERT INTO clientes(nombre, direccion)
VALUES ('Carlos Sánchez', 'Saavedra 206, Las Heras');


INSERT INTO empleados(nombre, apellido, edad, salario, departamento_id)
VALUES ('Lorena', 'Guzmán', 26, 2600.00, (SELECT id FROM departamentos WHERE nombre = 'Ventas'));

SELECT * FROM empleados; 

SELECT * FROM clientes;

SELECT * FROM productos;





