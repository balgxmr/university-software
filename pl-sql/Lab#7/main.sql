-- Lab 7 BASE DE DATOS

-- -captura del modelo E/R

-- -captura modelo logico relacional normalizado

-- - modelo fisico / creacion de las tablas

CREATE TABLE Cliente (
    id_cliente NUMBER PRIMARY KEY,
    Cedula VARCHAR2(20),
    Nombre VARCHAR2(50),
    Apellido VARCHAR2(50),
    Fecha_de_nacimiento DATE,
    Sexo VARCHAR2(10),
    Profesion VARCHAR2(50)
);

CREATE TABLE Tipo_Telefono (
    id_Telefono NUMBER PRIMARY KEY,
    Descripcion VARCHAR2(50)
);

CREATE TABLE Telefono (
    Num_Telefono VARCHAR2(15) PRIMARY KEY,
    Tipo_Telefono_ID NUMBER,
    id_cliente NUMBER,
    FOREIGN KEY (Tipo_Telefono_ID) REFERENCES Tipo_Telefono(id_Telefono),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Tipo_Email (
    id_Email NUMBER PRIMARY KEY,
    Descripcion VARCHAR2(50)
);

CREATE TABLE Email (
    Email VARCHAR2(100) PRIMARY KEY,
    Tipo_Email_ID NUMBER,
    id_cliente NUMBER,
    FOREIGN KEY (Tipo_Email_ID) REFERENCES Tipo_Email(id_Email),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Tipo_Prestamo (
    Id_Prestamo NUMBER PRIMARY KEY,
    Tipo_Prestamo VARCHAR2(50)
);

CREATE TABLE Prestamo (
    num_Prestamo NUMBER PRIMARY KEY,
    Monto_aproved NUMBER(10), 
    letra_Mensual NUMBER(10), 
    monto_Pago NUMBER(10),
    tasa_Interes NUMBER(5), 
    fecha_Aprob DATE,
    fecha_Pago DATE,
    id_cliente NUMBER,
    Tipo_Prestamo_ID NUMBER,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (Tipo_Prestamo_ID) REFERENCES Tipo_Prestamo(Id_Prestamo)
);

CREATE TABLE Profesion (
    id_cliente NUMBER,
    id_profesion NUMBER,
    tipo_profesion VARCHAR2(50),
    PRIMARY KEY (id_cliente, id_profesion),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-agregar edad a la tabla cliente

ALTER TABLE Cliente ADD edad NUMBER;



-captura del modelo fisico actualizado
-captura del modelo relacional actualizado

-agregar la tabla sucursal

CREATE TABLE Sucursal (
    cod_sucursal NUMBER PRIMARY KEY,
    nombre_sucursal VARCHAR2(100) NOT NULL,
    tipo_prestamo NUMBER NOT NULL,
    monto_prestamos NUMBER(15) NOT NULL,
    FOREIGN KEY (tipo_prestamo) REFERENCES Tipo_Prestamo(Id_Prestamo)
);

-Agregar a la tabla clientes y préstamos el atributo de código de sucursal

-- Agregar la columna cod_sucursal a la tabla Cliente
ALTER TABLE Cliente ADD cod_sucursal NUMBER;

-- Agregar la columna cod_sucursal a la tabla Prestamo
ALTER TABLE Prestamo ADD cod_sucursal NUMBER;

-- Crear la relación de clave foránea en la tabla Cliente
ALTER TABLE Cliente ADD CONSTRAINT fk_cliente_sucursal FOREIGN KEY (cod_sucursal) REFERENCES Sucursal(cod_sucursal);

-- Crear la relación de clave foránea en la tabla Prestamo
ALTER TABLE Prestamo ADD CONSTRAINT fk_prestamo_sucursal FOREIGN KEY (cod_sucursal) REFERENCES Sucursal(cod_sucursal);


- Agregar a la tabla del prestamos los siguientes atributos:

ALTER TABLE Prestamo
    ADD (
        saldo_actual NUMBER(10),
        interes_pagado NUMBER(10),
        fecha_modificacion VARCHAR2(14),
        usuario VARCHAR2(50)
    );

-agregar una tabla transaccional:

CREATE TABLE Transacpagos (
    cod_sucursal NUMBER,
    id_transaccion NUMBER PRIMARY KEY,
    id_cliente NUMBER,
    tipoprestamo NUMBER,
    fechatransaccion TIMESTAMP,
    monto_pago NUMBER(10),
    fechainsercion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario VARCHAR2(50),
    FOREIGN KEY (cod_sucursal) REFERENCES Sucursal(cod_sucursal),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (tipoprestamo) REFERENCES Tipo_Prestamo(Id_Prestamo)
);

-Creando secuencias para las tablas:

CREATE SEQUENCE seq_IdCliente
START WITH 1
INCREMENT BY 1
MAXVALUE 99999
MINVALUE 1;

CREATE SEQUENCE seq_IdPrestamo
START WITH 1
INCREMENT BY 1
MAXVALUE 99999
MINVALUE 1;

CREATE SEQUENCE seq_IdSucursal
START WITH 1
INCREMENT BY 1
MAXVALUE 99999
MINVALUE 1;

CREATE SEQUENCE seq_IdTransacpagos
START WITH 1
INCREMENT BY 1
MAXVALUE 99999
MINVALUE 1;

Procedimiento para insertar datos en las tablas parametricas:
CREATE OR REPLACE PROCEDURE insertar_Tipo_Telefono (
    p_id_Telefono IN Tipo_Telefono.id_Telefono%TYPE,
    p_Descripcion IN Tipo_Telefono.Descripcion%TYPE
) IS
BEGIN
    INSERT INTO Tipo_Telefono (id_Telefono, Descripcion)
    VALUES (p_id_Telefono, p_Descripcion);
END insertar_Tipo_Telefono;
/

CREATE OR REPLACE PROCEDURE insertar_Tipo_Email (
    p_id_Email IN Tipo_Email.id_Email%TYPE,
    p_Descripcion IN Tipo_Email.Descripcion%TYPE
) IS
BEGIN
    INSERT INTO Tipo_Email (id_Email, Descripcion)
    VALUES (p_id_Email, p_Descripcion);
END insertar_Tipo_Email;
/

CREATE OR REPLACE PROCEDURE insertar_Tipo_Prestamo (
    p_Id_Prestamo IN Tipo_Prestamo.Id_Prestamo%TYPE,
    p_Tipo_Prestamo IN Tipo_Prestamo.Tipo_Prestamo%TYPE
) IS
BEGIN
    INSERT INTO Tipo_Prestamo (Id_Prestamo, Tipo_Prestamo)
    VALUES (p_Id_Prestamo, p_Tipo_Prestamo);
END insertar_Tipo_Prestamo;
/

CREATE OR REPLACE PROCEDURE insertar_Profesion (
    p_id_cliente IN Profesion.id_cliente%TYPE,
    p_id_profesion IN Profesion.id_profesion%TYPE,
    p_tipo_profesion IN Profesion.tipo_profesion%TYPE
) IS
BEGIN
    INSERT INTO Profesion (id_cliente, id_profesion, tipo_profesion)
    VALUES (p_id_cliente, p_id_profesion, p_tipo_profesion);
END insertar_Profesion;
/

CREATE OR REPLACE PROCEDURE insertar_Sucursal (
    p_nombre_sucursal IN Sucursal.nombre_sucursal%TYPE,
    p_tipo_prestamo IN Sucursal.tipo_prestamo%TYPE,
    p_monto_prestamos IN Sucursal.monto_prestamos%TYPE
) IS
BEGIN
    INSERT INTO Sucursal (cod_sucursal, nombre_sucursal, tipo_prestamo, monto_prestamos)
    VALUES (seq_IdSucursal.NEXTVAL, p_nombre_sucursal, p_tipo_prestamo, p_monto_prestamos);
END insertar_Sucursal;
/

- llamado a los procedimientos de insertar en esas tablas:

-- Insertar datos en Tipo_Telefono
BEGIN
    insertar_Tipo_Telefono(1, 'Celular');
    insertar_Tipo_Telefono(2, 'Residencia');
    insertar_Tipo_Telefono(3, 'Celular del familiar más cercano');
    insertar_Tipo_Telefono(4, 'Celular del conyugue');
    insertar_Tipo_Telefono(5, 'Otro');
END;
/

-- Insertar datos en Tipo_Email
BEGIN
    insertar_Tipo_Email(1, 'Personal');
    insertar_Tipo_Email(2, 'Laboral');
    insertar_Tipo_Email(3, 'Académico');
    insertar_Tipo_Email(4, 'Corporativo');
    insertar_Tipo_Email(5, 'Otro');
END;
/

-- Insertar datos en Tipo_Prestamo
BEGIN
    insertar_Tipo_Prestamo(1, 'Hipotecario');
    insertar_Tipo_Prestamo(2, 'Automotriz');
    insertar_Tipo_Prestamo(3, 'Personal');
    insertar_Tipo_Prestamo(4, 'Estudiantil');
    insertar_Tipo_Prestamo(5, 'Comercial');
END;
/

-- primero cliente/prestamo antes de esto
-- Insertar datos en Profesion
BEGIN
    insertar_Profesion(1, 1, 'Ingeniero');
    insertar_Profesion(2, 2, 'Médico');
    insertar_Profesion(3, 3, 'Abogado');
    insertar_Profesion(4, 4, 'Contador');
    insertar_Profesion(5, 5, 'Profesor');
END;
/

-- Insertar datos en Sucursal
BEGIN
    insertar_Sucursal('Sucursal Central', 1, 1000000.00);
    insertar_Sucursal('Sucursal Norte', 2, 2000000.00);
    insertar_Sucursal('Sucursal Sur', 3, 1500000.00);
    insertar_Sucursal('Sucursal Este', 4, 1200000.00);
    insertar_Sucursal('Sucursal Oeste', 5, 1300000.00);
END;
/

-Funcion para calcular edad

CREATE OR REPLACE FUNCTION calcular_edad(
    p_fecha_nacimiento IN DATE
) RETURN NUMBER IS
    v_edad NUMBER;
BEGIN
    SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, p_fecha_nacimiento) / 12)
    INTO v_edad
    FROM DUAL;
    RETURN v_edad;
END calcular_edad;
/

-Procedimiento para insertar datos en la tabla cliente

CREATE OR REPLACE PROCEDURE insertar_Cliente (
    p_Cedula IN Cliente.Cedula%TYPE,
    p_Nombre IN Cliente.Nombre%TYPE,
    p_Apellido IN Cliente.Apellido%TYPE,
    p_Fecha_de_nacimiento IN Cliente.Fecha_de_nacimiento%TYPE,
    p_Sexo IN Cliente.Sexo%TYPE,
    p_Profesion IN Cliente.Profesion%TYPE,
    p_cod_sucursal IN Cliente.cod_sucursal%TYPE
) IS
    v_edad NUMBER;
BEGIN
    -- Invocar la función para calcular la edad
    v_edad := calcular_edad(p_Fecha_de_nacimiento);

    -- Insertar el cliente en la tabla
    INSERT INTO Cliente (
        id_cliente, Cedula, Nombre, Apellido, Fecha_de_nacimiento, Sexo, Profesion, cod_sucursal, edad
    ) VALUES (
        seq_IdCliente.NEXTVAL, p_Cedula, p_Nombre, p_Apellido, p_Fecha_de_nacimiento, p_Sexo, p_Profesion, p_cod_sucursal, v_edad
    );

    -- Confirmación de inserción exitosa
    DBMS_OUTPUT.PUT_LINE('Cliente insertado correctamente.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Violación de restricción de clave única. No se pueden insertar registros duplicados.');
    WHEN PROGRAM_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('Error: Error en el programa PL/SQL.');
    WHEN STORAGE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('Error: Error de almacenamiento en la base de datos.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el proceso general: ' || SQLERRM);
END insertar_Cliente;
/

-llamar al procedimiento

BEGIN
    insertar_Cliente('1234567890', 'Richard', 'Herranz', TO_DATE('1985-05-20', 'YYYY-MM-DD'), 'Masculino', 'Ingeniero', 1);
    insertar_Cliente('2345678901', 'Jonathan', 'Nunez', TO_DATE('1990-08-15', 'YYYY-MM-DD'), 'Femenino', 'Médico', 2);
    insertar_Cliente('3456789012', 'Jose', 'Encalada', TO_DATE('1975-02-10', 'YYYY-MM-DD'), 'Masculino', 'Abogado', 3);
    insertar_Cliente('4567890123', 'Miguel', 'Ortega', TO_DATE('1988-12-05', 'YYYY-MM-DD'), 'Femenino', 'Contador', 4);
    insertar_Cliente('5678901234', 'Luis', 'Martínez', TO_DATE('1995-03-25', 'YYYY-MM-DD'), 'Masculino', 'Profesor', 5);
END;
/

-Procedimiento para insertar en la tabla prestamos y actualizar la tabla sucursales

CREATE OR REPLACE PROCEDURE insertar_Prestamo (
    p_Monto_aproved IN Prestamo.Monto_aproved%TYPE,
    p_letra_Mensual IN Prestamo.letra_Mensual%TYPE,
    p_monto_Pago IN Prestamo.monto_Pago%TYPE,
    p_tasa_Interes IN Prestamo.tasa_Interes%TYPE,
    p_fecha_Aprob IN Prestamo.fecha_Aprob%TYPE,
    p_fecha_Pago IN Prestamo.fecha_Pago%TYPE,
    p_id_cliente IN Prestamo.id_cliente%TYPE,
    p_Tipo_Prestamo_ID IN Prestamo.Tipo_Prestamo_ID%TYPE,
    p_cod_sucursal IN Prestamo.cod_sucursal%TYPE,
    p_saldo_actual IN Prestamo.saldo_actual%TYPE,
    p_interes_pagado IN Prestamo.interes_pagado%TYPE,
    p_fecha_modificacion IN Prestamo.fecha_modificacion%TYPE,
    p_usuario IN Prestamo.usuario%TYPE
) IS
BEGIN
    -- Insertar el préstamo en la tabla Prestamo
    INSERT INTO Prestamo (
        num_Prestamo, Monto_aproved, letra_Mensual, monto_Pago, tasa_Interes, 
        fecha_Aprob, fecha_Pago, id_cliente, Tipo_Prestamo_ID, cod_sucursal, 
        saldo_actual, interes_pagado, fecha_modificacion, usuario
    ) VALUES (
        seq_IdPrestamo.NEXTVAL, p_Monto_aproved, p_letra_Mensual, p_monto_Pago, p_tasa_Interes, 
        p_fecha_Aprob, p_fecha_Pago, p_id_cliente, p_Tipo_Prestamo_ID, p_cod_sucursal, 
        p_saldo_actual, p_interes_pagado, p_fecha_modificacion, p_usuario
    );

    -- Actualizar la información de préstamo en la tabla Sucursal
    UPDATE Sucursal
    SET monto_prestamos = monto_prestamos + p_Monto_aproved
    WHERE cod_sucursal = p_cod_sucursal;

    EXCEPTION
   WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Violación de restricción de clave única. No se pueden insertar registros duplicados.');
    WHEN PROGRAM_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('Error: Error en el programa PL/SQL.');
    WHEN STORAGE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('Error: Error de almacenamiento en la base de datos.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el proceso general');
END insertar_Prestamo;
/

-llamada al procedimiento

BEGIN
    insertar_Prestamo(5000, 100, 150, 5, TO_DATE('2024-06-04', 'YYYY-MM-DD'), TO_DATE('2024-07-04', 'YYYY-MM-DD'), 1, 1, 1, 5000, 0, '2024-06-04', 'Usuario1');
    insertar_Prestamo(8000, 200, 180, 6, TO_DATE('2024-06-05', 'YYYY-MM-DD'), TO_DATE('2024-07-05', 'YYYY-MM-DD'), 2, 2, 2, 8000, 0, '2024-06-05', 'Usuario2');
    insertar_Prestamo(10000, 250, 200, 7, TO_DATE('2024-06-06', 'YYYY-MM-DD'), TO_DATE('2024-07-06', 'YYYY-MM-DD'), 3, 3, 3, 10000, 0, '2024-06-06', 'Usuario3');
END;
/

-procedimiento para insertar en la tabla transacpagos

CREATE OR REPLACE PROCEDURE insertar_Pago (
    p_id_transaccion IN Transacpagos.id_transaccion%TYPE,
    p_id_cliente IN Transacpagos.id_cliente%TYPE,
    p_tipoprestamo IN Transacpagos.tipoprestamo%TYPE,
    p_fechatransaccion IN Transacpagos.fechatransaccion%TYPE,
    p_monto_pago IN Transacpagos.monto_pago%TYPE,
    p_fechainsercion IN VARCHAR2,
    p_usuario IN Transacpagos.usuario%TYPE
) IS
BEGIN
    -- Insertar el pago en la tabla Transacpagos
    INSERT INTO Transacpagos (
        cod_sucursal, id_transaccion, id_cliente, tipoprestamo, fechatransaccion, monto_pago, fechainsercion, usuario
    ) VALUES (
        seq_IdTransacpagos.NEXTVAL, p_id_transaccion, p_id_cliente, p_tipoprestamo, p_fechatransaccion, p_monto_pago, TO_DATE(p_fechainsercion, 'DD/MM/YYYY HH24:MI:SS'), p_usuario
    );

    EXCEPTION
   WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Violación de restricción de clave única. No se pueden insertar registros duplicados.');
    WHEN PROGRAM_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('Error: Error en el programa PL/SQL.');
    WHEN STORAGE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('Error: Error de almacenamiento en la base de datos.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error en el proceso general');
END insertar_Pago;
/

-llamada al procedimiento con cada tipo diferente

-- Ejemplo de llamada para un pago de tipo préstamo hipotecario
BEGIN
    insertar_Pago(1, 1, 1, TO_DATE('2024-06-04', 'YYYY-MM-DD'), 500, '04/06/2024 10:30:00', 'Usuario1');
END;
/

-- Ejemplo de llamada para un pago de tipo préstamo automotriz
BEGIN
    insertar_Pago(2, 2, 2, TO_DATE('2024-06-05', 'YYYY-MM-DD'), 800, '05/06/2024 11:45:00', 'Usuario2');
END;
/

-- Ejemplo de llamada para un pago de tipo préstamo personal
BEGIN
    insertar_Pago(3, 3, 3, TO_DATE('2024-06-06', 'YYYY-MM-DD'), 1000, '06/06/2024 09:15:00', 'Usuario3');
END;
/

- funcion

CREATE OR REPLACE FUNCTION calcular_interes(
    p_monto_pago IN NUMBER,
    p_tipo_prestamo IN VARCHAR2
) RETURN NUMBER IS
    v_tasa_interes NUMBER(5);
BEGIN
    -- Obtener la tasa de interés del tipo de préstamo
    SELECT tasa_Interes INTO v_tasa_interes
    FROM Tipo_Prestamo
    WHERE Tipo_Prestamo = p_tipo_prestamo;

    -- Calcular el interés
    RETURN p_monto_pago * v_tasa_interes / 100;
END calcular_interes;
/

CREATE OR REPLACE FUNCTION calcular_interes(
  p_monto_Pago IN NUMBER,
  p_TasaInteres IN NUMBER
)
RETURN Prestamo.Monto_aproved%TYPE
IS
  v_Interes Prestamo.tasa_Interes%TYPE;
BEGIN
  v_Interes := p_monto_Pago * p_TasaInteres;

  RETURN v_Interes;
    
END calcular_interes;
/

-Procedimiento cursor
CREATE OR REPLACE PROCEDURE actualizar_Pagos
IS
  v_Prestamo Prestamo%ROWTYPE;

  v_Interes Prestamo.interes_pagado%TYPE;
  v_MontoACapital Prestamo.saldo_actual%TYPE;
  v_NuevoInteresPagado Prestamo.interes_pagado%TYPE;
  v_NuevoSaldo Prestamo.saldo_actual%TYPE;
  v_NuevoMontoPagado Prestamo.monto_Pago%TYPE;

  CURSOR c_Pagos IS
    SELECT * FROM Transacpagos;
BEGIN
  FOR pago IN c_pagos LOOP
    SELECT * INTO v_Prestamo
      FROM Prestamo
      WHERE id_cliente = pago.id_cliente
	AND Tipo_Prestamo_Id = pago.tipoprestamo;

    v_Interes := calcular_interes(v_Prestamo.saldo_actual, v_Prestamo.tasa_Interes);

    IF pago.monto_pago >= v_Interes THEN
      v_MontoACapital := pago.monto_pago - v_Interes;
      v_NuevoSaldo := v_Prestamo.saldo_actual - v_MontoACapital;
    ELSE
      v_MontoACapital := 0;
      v_NuevoSaldo := v_Prestamo.saldo_actual;
    END IF;

    v_NuevoInteresPagado := v_Prestamo.interes_pagado + v_Interes;
    v_NuevoMontoPagado := v_Prestamo.monto_Pago + v_MontoACapital;

    UPDATE Prestamo
      SET
        saldo_actual = v_NuevoSaldo,
        monto_pago = v_NuevoMontoPagado,
        interes_pagado = v_NuevoInteresPagado,
        fecha_modificacion = SYSDATE,
        usuario = SYS_CONTEXT('USERENV','SESSION_USER')
        WHERE id_cliente = pago.id_cliente
	AND Tipo_Prestamo_Id = pago.tipoprestamo;
  END LOOP;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: Violación de restricción de clave única. No se pueden insertar registros duplicados.');
  WHEN PROGRAM_ERROR THEN
    DBMS_OUTPUT.PUT_LINE('Error: Error en el programa PL/SQL.');
  WHEN STORAGE_ERROR THEN
    DBMS_OUTPUT.PUT_LINE('Error: Error de almacenamiento en la base de datos.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error en el proceso general');
END actualizar_Pagos;
/

CREATE VIEW v_Cliente_Prestamo_Sucursal AS
SELECT
  c.Cedula,
  c.Nombre,
  c.Apellido,
  c.Fecha_de_nacimiento,
  c.Sexo,
  c.Profesion,
  c.cod_sucursal,
  s.nombre_sucursal,
  p.num_Prestamo,
  p.Monto_aproved,
  p.letra_Mensual,
  p.monto_Pago,
  p.tasa_Interes,
  p.fecha_Aprob,
  p.fecha_Pago,
  p.saldo_actual,
  p.interes_pagado,
  p.fecha_modificacion,
  p.usuario
FROM Cliente c
JOIN Prestamo p ON c.id_cliente = p.id_cliente
JOIN Sucursal s ON c.cod_sucursal = s.cod_sucursal;