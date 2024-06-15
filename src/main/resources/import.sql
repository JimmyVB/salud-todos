
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('jimmy', '$2a$10$bVhqWTj/R/dF6NcUwv4Ig.R0UHjesXKpH7RJ8SdoKBOwyBIUUJ3ne', true, 'Jimmy' , 'Valdez', 'jimmy@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$3Rnj9yhWdHysH/Td9sohTuC0DtpHg0O9HTfauOxgj3PXtikbLbCV.', true, 'Richard', 'Blas', 'richard@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);
