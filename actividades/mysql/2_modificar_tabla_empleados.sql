USE mi_bd;

ALTER TABLE empleados 
MODIFY edad INT NOT NULL;

ALTER TABLE empleados
MODIFY salario DECIMAL(10,2) DEFAULT 0.00;

ALTER TABLE empleados
ADD departamento VARCHAR(50);

ALTER TABLE empleados
ADD correo_electronico VARCHAR(100);

ALTER TABLE empleados
DROP fecha_contratacion;

-- Crear nuevamente, columna fecha_contratacion;

ALTER TABLE empleados
ADD fecha_contratacion DATE DEFAULT(current_date()); -- Se puede usar NOW() si se desea incluir fecha y hora.

-- Crear una nueva tabla;

CREATE TABLE IF NOT EXISTS departamentos(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

-- Crear columna y asociar id como clave foranea en empleados;

ALTER TABLE empleados
ADD departamento_id INT;

ALTER TABLE empleados
ADD FOREIGN KEY (departamento_id) REFERENCES departamentos(id);

-- Eliminar columna departamento en empleados

ALTER TABLE empleados
DROP departamento;