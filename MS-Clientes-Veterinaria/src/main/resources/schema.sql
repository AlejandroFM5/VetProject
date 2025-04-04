-- PASO 1 : ELIMINAR LA TABLA SI YA EXISTE
DROP TABLE IF EXISTS CLIENTES;

-- PASO 2 : CREAR LA TABLA "CLIENTES"
CREATE TABLE CLIENTES(
	ID_CLIENTE NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NOMBRE NVARCHAR2(50),
    DIRECCION NVARCHAR2(100),
    CONTACTO NUMBER(10),
    CONSTRAINT ID_CLIENTE PRIMARY KEY (ID_CLIENTE)
);