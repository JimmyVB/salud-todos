-- INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamerica');
-- INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamerica');
-- INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamerica');
-- INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
-- INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
-- INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
-- INSERT INTO regiones (id, nombre) VALUES (7, 'Oceania');
-- INSERT INTO regiones (id, nombre) VALUES (8, 'Antartida');
--
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (1, 'Jimmy', 'Valdez', 'jimmy@gmail.com', '2020-01-01');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (2, 'Richard', 'Blas1', 'richard1@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Antonio', 'Blas2', 'richar2d@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Manuel', 'Blas3', 'richard3@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Francisco', 'Blas4', 'richa4rd@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'David', 'Blas5', 'richar5d@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Juan', 'Blas6', 'richard6@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Javier', 'Blas7', 'richard7@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Daniel', 'Blas8', 'richard8@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (5, 'Carmen', 'Blas9', 'richard9@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (6, 'Ana', 'Blas10', 'richar10d@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7, 'Josefa', 'Blas11', 'richa11rd@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7, 'Eloy', 'Blas12', 'richard12@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7, 'Eduardo', 'Blas13', 'richar13d@gmail.com', '2020-02-02');
-- INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (8, 'Enrique', 'Blas14', 'richard14@gmail.com', '2020-02-02');
--
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('jimmy', '$2a$10$bVhqWTj/R/dF6NcUwv4Ig.R0UHjesXKpH7RJ8SdoKBOwyBIUUJ3ne', 1, 'Jimmy' , 'Valdez', 'jimmy@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$3Rnj9yhWdHysH/Td9sohTuC0DtpHg0O9HTfauOxgj3PXtikbLbCV.', 1, 'Richard', 'Blas', 'richard@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);
--
-- /* Creamos los prodcuto */
--
INSERT INTO productos (nombre, precio, create_at, stock, usuario_id) VALUES ('Panasonic Pantalla LCD', 5000, NOW(), 10, 2);
INSERT INTO productos (nombre, precio, create_at, stock, usuario_id) VALUES ('Laptop Sony', 4500, NOW(), 5, 2);
INSERT INTO productos (nombre, precio, create_at, stock, usuario_id) VALUES ('Iphone 12 Pro', 5500, NOW(), 15, 2);
INSERT INTO productos (nombre, precio, create_at, stock, usuario_id) VALUES ('PlayStation 4', 1200, NOW(), 10, 2);
INSERT INTO productos (nombre, precio, create_at, stock, usuario_id) VALUES ('Monitor 32 Samsung', 2700, NOW(), 20, 2);
INSERT INTO productos (nombre, precio, create_at, stock, usuario_id) VALUES ('Parlante JBL', 3300, NOW(), 25, 2);
INSERT INTO productos (nombre, precio, create_at, stock, usuario_id) VALUES ('MacBook Pro 2020', 6500, NOW(), 30, 2);


-- /* Creamos las facturas */
--
-- INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipos de oficina', null, 1, NOW());
-- INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 1);
-- INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2, 1, 4);
-- INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 5);
-- INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 7);
--
-- INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura Bicicleta', 'Alguna observacion', 1, NOW());
-- INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (3, 2, 6);
--
