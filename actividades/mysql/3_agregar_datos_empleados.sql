USE mi_bd;

INSERT INTO departamentos (nombre)
VALUES ('Ventas'); 

INSERT INTO departamentos (nombre)
VALUES ('Recursos Humanos'); 

-- En caso de Error Code: 1175. You are using safe update mode
-- SET SQL_SAFE_UPDATES = 0;

-- Insertar empleado: Ana Rodriguez
INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Ana', 'Rodriguez', 28, 3000.00, 'anarodriguez@mail.com', 1);

-- Insertar empleado: Carlos López
INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Carlos', 'López', 32, 3200.50, 'carloslopez@mail.com', 2);

-- Insertar empleado: Laura Pérez
INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Laura', 'Pérez', 26, 2800.75, 'lauraperez@mail.com', 1);

-- Insertar empleado: Martín González
INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Martín', 'González', 30, 3100.25, 'martingonzalez@mail.com', 2);

-- Actualiza el salario del empleado con nombre "Ana" para aumentarlo en un 10%.
UPDATE empleados
SET salario = salario + (salario*0.10)
WHERE nombre = 'Ana';

-- Crea un departamento llamado “Contabilidad”. 
INSERT INTO departamentos (nombre)
VALUES ('Contabilidad'); 

-- Cambia el departamento del empleado con nombre "Carlos" de "Recursos Humanos" a "Contabilidad"
UPDATE empleados
SET departamento_id = 3
WHERE nombre = 'Carlos';

-- Elimina al empleado con nombre "Laura"
DELETE FROM empleados
WHERE nombre = 'Laura';

