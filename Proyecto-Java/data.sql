DROP DATABASE IF EXISTS empleadoscrud;
CREATE DATABASE  empleadoscrud;
USE empleadoscrud;

CREATE TABLE login (
id int auto_increment primary key,
nombre varchar (100),
email varchar (100),
usuario varchar (100),
contrasenia varchar (100)
);

CREATE TABLE generos (
id_genero int auto_increment primary key,
nombre varchar (20)
);

CREATE TABLE empleados (
id_empleado int auto_increment primary key,
nombre varchar (100),
domicilio varchar (100),
telefono varchar (15),
email varchar (100),
fecha_de_nacimiento date,
id_genero int,
CONSTRAINT empleado_id_genero_generos_id_genero
FOREIGN KEY (id_genero)
REFERENCES generos(id_genero)
);


INSERT INTO generos VALUES
(null, "MASCULINO"),
(null, "FEMENINO");

INSERT INTO empleados VALUES (null,"ISAI MANJARRES","Av Santa Ursula 125","58-98-45-63-10","isai@test.com","1998-02-14",2);
INSERT INTO empleados VALUES (null, "Juan Pérez", "Calle Principal 123", "55-1234-5678", "juan@example.com", "1990-05-20", 1);
INSERT INTO empleados VALUES (null, "María Rodríguez", "Avenida Reforma 456", "55-9876-5432", "maria@example.com", "1985-09-10", 2);
INSERT INTO empleados VALUES (null, "Carlos Sánchez", "Colonia Juárez 789", "55-5555-5555", "carlos@example.com", "1988-03-15", 1);
INSERT INTO empleados VALUES (null, "Laura Gómez", "Paseo de la Reforma 987", "55-1111-2222", "laura@example.com", "1992-11-30", 2);
INSERT INTO empleados VALUES (null, "Pedro López", "Insurgentes Sur 321", "55-7777-8888", "pedro@example.com", "1982-07-05", 1);
INSERT INTO empleados VALUES (null, "Ana Martínez", "Calle Revolución 654", "55-4444-3333", "ana@example.com", "1995-02-25", 2);
INSERT INTO empleados VALUES (null, "Miguel Torres", "Avenida Hidalgo 987", "55-6666-9999", "miguel@example.com", "1980-12-12", 1);
INSERT INTO empleados VALUES (null, "Sofía Ramírez", "Paseo de los Tamarindos 456", "55-2222-1111", "sofia@example.com", "1993-08-18", 2);
INSERT INTO empleados VALUES (null, "Jorge Herrera", "Calle Chapultepec 789", "55-8888-7777", "jorge@example.com", "1987-04-03", 1);
INSERT INTO empleados VALUES (null, "Elena Castro", "Avenida Insurgentes Norte 123", "55-3333-4444", "elena@example.com", "1991-06-28", 2);

INSERT INTO login VALUES 
(null, 'Isai', 'Isai@test.com', 'root', 'root' );
-- quiubo x2