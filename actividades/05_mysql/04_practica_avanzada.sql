USE mi_bd;

CREATE TABLE clientes(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50), 
    direccion VARCHAR(50)
);

CREATE TABLE productos(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50), 
    precio DECIMAL(10,2)
);

CREATE TABLE ventas(
	id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT, 
    cliente_id INT, 
    cantidad INT, 
    precio_unitario DECIMAL(10,2),
    monto_total DECIMAL(10,2),
    empleado_id INT
);

ALTER TABLE ventas
ADD FOREIGN KEY (producto_id) REFERENCES productos(id);

ALTER TABLE ventas
ADD FOREIGN KEY (cliente_id) REFERENCES clientes(id);

ALTER TABLE ventas
ADD FOREIGN KEY (empleado_id) REFERENCES empleados(id);

INSERT INTO clientes (nombre, direccion)
VALUES ('Juan Perez', 'Libertad 3215, Mar del Plata');

INSERT INTO productos (nombre, precio)
VALUES ('Laptop', 1200.00);

ALTER TABLE ventas
MODIFY monto_total INT GENERATED ALWAYS AS (cantidad * precio_unitario) STORED;

INSERT INTO ventas (cliente_id, producto_id, cantidad, precio_unitario, empleado_id)
VALUES (1, 1, 2, 1200.00, 1);

