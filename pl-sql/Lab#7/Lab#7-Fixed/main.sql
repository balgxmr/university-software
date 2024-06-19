CREATE TABLE Sucursal (
    Cod_Sucursal VARCHAR2(10) PRIMARY KEY,
    nombre_sucursal VARCHAR2(50)
);

CREATE TABLE Cliente (
    Id_cliente VARCHAR2(10) PRIMARY KEY,
    Apellido VARCHAR2(50),
    Nombre VARCHAR2(50),
    Cedula VARCHAR2(20),
    Fecha_nac DATE,
    sexo CHAR(1)
);

CREATE TABLE Tipo_Prestamo (
    Id_Prestamo VARCHAR2(10) PRIMARY KEY,
    Tipo_Prestamo VARCHAR2(50)
);

CREATE TABLE Prestamo (
    id_Cliente VARCHAR2(10),
    id_prestamo VARCHAR2(10),
    monto_aproved NUMBER,
    letra_mensual NUMBER,
    num_prestamo NUMBER PRIMARY KEY,
    monto_pago NUMBER,
    Tasa_interes NUMBER,
    fecha_pago DATE,
    fecha_aprob DATE,
    CONSTRAINT fk_prestamo_cliente FOREIGN KEY (id_Cliente) REFERENCES Cliente (Id_cliente),
    CONSTRAINT fk_prestamo_tipoprestamo FOREIGN KEY (id_prestamo) REFERENCES Tipo_Prestamo (Id_Prestamo)
);

CREATE TABLE Tipo_Email (
    Id_Email VARCHAR2(10) PRIMARY KEY,
    descripcion VARCHAR2(50)
);

CREATE TABLE Email (
    Id_Cliente VARCHAR2(10),
    Id_Email VARCHAR2(10),
    Email VARCHAR2(100),
    PRIMARY KEY (Id_Cliente, Id_Email),
    CONSTRAINT fk_email_cliente FOREIGN KEY (Id_Cliente) REFERENCES Cliente (Id_cliente),
    CONSTRAINT fk_email_tipoemail FOREIGN KEY (Id_Email) REFERENCES Tipo_Email (Id_Email)
);

CREATE TABLE Tipo_Telefono (
    Id_Telefono VARCHAR2(10) PRIMARY KEY,
    descripcion VARCHAR2(50)
);

CREATE TABLE Telefono (
    Id_Cliente VARCHAR2(10),
    Id_Telefono VARCHAR2(10),
    Telefono VARCHAR2(20),
    PRIMARY KEY (Id_Cliente, Id_Telefono),
    CONSTRAINT fk_telefono_cliente FOREIGN KEY (Id_Cliente) REFERENCES Cliente (Id_cliente),
    CONSTRAINT fk_telefono_tipotelefono FOREIGN KEY (Id_Telefono) REFERENCES Tipo_Telefono (Id_Telefono)
);

CREATE TABLE Profesion (
    Id_Cliente VARCHAR2(10),
    Id_profesion VARCHAR2(10),
    tipo_profesion VARCHAR2(50),
    PRIMARY KEY (Id_Cliente, Id_profesion),
    CONSTRAINT fk_profesion_cliente FOREIGN KEY (Id_Cliente) REFERENCES Cliente (Id_cliente)
);

CREATE TABLE Tipo_prestamo_sucursal (
    cod_sucursal VARCHAR2(10),
    Id_prestamo VARCHAR2(10),
    monto_prest NUMBER,
    PRIMARY KEY (cod_sucursal, Id_prestamo),
    CONSTRAINT fk_tps_sucursal FOREIGN KEY (cod_sucursal) REFERENCES Sucursal (Cod_Sucursal),
    CONSTRAINT fk_tps_prestamo FOREIGN KEY (Id_prestamo) REFERENCES Tipo_Prestamo (Id_Prestamo)
);


ALTER TABLE Cliente ADD edad NUMBER;

ALTER TABLE Cliente ADD cod_sucursal VARCHAR2(10);
ALTER TABLE Prestamo ADD cod_sucursal VARCHAR2(10);

ALTER TABLE Cliente ADD CONSTRAINT fk_cliente_sucursal FOREIGN KEY (cod_sucursal) REFERENCES Sucursal(cod_sucursal);

ALTER TABLE Prestamo ADD CONSTRAINT fk_prestamo_sucursal FOREIGN KEY (cod_sucursal) REFERENCES Sucursal(cod_sucursal);

ALTER TABLE Prestamo
    ADD (
        saldo_actual NUMBER(10),
        interes_pagado NUMBER(10),
        fecha_modificacion VARCHAR2(14),
        usuario VARCHAR2(50)
    );

CREATE TABLE Transacpagos (
    id_transaccion VARCHAR2(10) PRIMARY KEY,
    monto_pago NUMBER,
    fecha_transaccion DATE,
    fecha_insercion DATE,
    usuario VARCHAR2(50),
    id_cliente VARCHAR2(10),
    cod_sucursal VARCHAR2(10),
    id_prestamo NUMBER,
    CONSTRAINT fk_transacpagos_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente (Id_cliente),
    CONSTRAINT fk_transacpagos_sucursal FOREIGN KEY (cod_sucursal) REFERENCES Sucursal (Cod_Sucursal),
    CONSTRAINT fk_transacpagos_prestamo FOREIGN KEY (id_prestamo) REFERENCES Prestamo (num_prestamo)
);


-- Secuencia para Cliente
CREATE SEQUENCE seq_cliente
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Secuencia para Prestamo
CREATE SEQUENCE seq_prestamo
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Secuencia para Transacpagos
CREATE SEQUENCE seq_transaccion
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE FUNCTION calcular_edad(p_fecha_nac DATE) 
RETURN NUMBER IS
    v_edad NUMBER;
BEGIN
    SELECT TRUNC((SYSDATE - p_fecha_nac) / 365.25) INTO v_edad FROM dual;
    RETURN v_edad;
END;
/

CREATE OR REPLACE PROCEDURE insertar_cliente_completo (
    p_apellido VARCHAR2,
    p_nombre VARCHAR2,
    p_cedula VARCHAR2,
    p_fecha_nac DATE,
    p_sexo CHAR,
    p_cod_sucursal VARCHAR2
) AS
    v_id_cliente VARCHAR2(10);
    v_edad NUMBER;
BEGIN
    -- Generar ID de Cliente
    SELECT seq_cliente.NEXTVAL INTO v_id_cliente FROM dual;

    -- Calcular la edad del cliente
    v_edad := calcular_edad(p_fecha_nac);

    -- Insertar en la tabla Cliente
    INSERT INTO Cliente (Id_cliente, Apellido, Nombre, Cedula, Fecha_nac, sexo, edad, cod_sucursal) 
    VALUES (v_id_cliente, p_apellido, p_nombre, p_cedula, p_fecha_nac, p_sexo, v_edad, p_cod_sucursal);

    -- Commit de la transacción
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE insertar_sucursal (
    p_cod_sucursal VARCHAR2,
    p_nombre_sucursal VARCHAR2
) AS
BEGIN
    INSERT INTO Sucursal (Cod_Sucursal, nombre_sucursal)
    VALUES (p_cod_sucursal, p_nombre_sucursal);
END;
/


BEGIN
    insertar_sucursal('SUC1', 'Sucursal Principal');
    insertar_sucursal('SUC2', 'Sucursal Norte');
    insertar_sucursal('SUC3', 'Sucursal Sur');
    insertar_sucursal('SUC4', 'Sucursal Este');
    insertar_sucursal('SUC5', 'Sucursal Oeste');
    insertar_sucursal('SUC6', 'Sucursal Centro');
    insertar_sucursal('SUC7', 'Sucursal Industrial');
    insertar_sucursal('SUC8', 'Sucursal Comercial');
    insertar_sucursal('SUC9', 'Sucursal Residencial');
    insertar_sucursal('SUC10', 'Sucursal Ejecutiva');
END;
/

BEGIN
    insertar_cliente_completo('López', 'Juan', '123456789', TO_DATE('1990-05-15', 'YYYY-MM-DD'), 'M', 'SUC1');
    insertar_cliente_completo('Gómez', 'María', '987654321', TO_DATE('1985-09-20', 'YYYY-MM-DD'), 'F', 'SUC2');
    insertar_cliente_completo('Martínez', 'Pedro', '456789123', TO_DATE('1987-11-10', 'YYYY-MM-DD'), 'M', 'SUC3');
    insertar_cliente_completo('Rodríguez', 'Ana', '789123456', TO_DATE('1995-03-25', 'YYYY-MM-DD'), 'F', 'SUC1');
    insertar_cliente_completo('Pérez', 'Carlos', '321654987', TO_DATE('1982-07-12', 'YYYY-MM-DD'), 'M', 'SUC2');
    insertar_cliente_completo('Sánchez', 'Laura', '654987321', TO_DATE('1989-12-08', 'YYYY-MM-DD'), 'F', 'SUC3');
    insertar_cliente_completo('Fernández', 'Diego', '234567890', TO_DATE('1984-04-30', 'YYYY-MM-DD'), 'M', 'SUC1');
    insertar_cliente_completo('García', 'Sofía', '876543210', TO_DATE('1993-06-17', 'YYYY-MM-DD'), 'F', 'SUC2');
    insertar_cliente_completo('Torres', 'Elena', '567890123', TO_DATE('1986-08-22', 'YYYY-MM-DD'), 'F', 'SUC3');
    insertar_cliente_completo('Ruiz', 'Javier', '109876543', TO_DATE('1991-10-05', 'YYYY-MM-DD'), 'M', 'SUC1');
END;
/

CREATE OR REPLACE PROCEDURE insertar_tipo_telefono (
    p_id_telefono VARCHAR2,
    p_descripcion VARCHAR2
) AS
BEGIN
    INSERT INTO Tipo_Telefono (Id_Telefono, descripcion) 
    VALUES (p_id_telefono, p_descripcion);
END;
/

BEGIN
    insertar_tipo_telefono('TEL1', 'Teléfono personal');
    insertar_tipo_telefono('TEL2', 'Teléfono trabajo');
    insertar_tipo_telefono('TEL3', 'Teléfono emergencia');
    insertar_tipo_telefono('TEL4', 'Teléfono familiar');
    insertar_tipo_telefono('TEL5', 'Teléfono móvil');
    insertar_tipo_telefono('TEL6', 'Teléfono oficina');
    insertar_tipo_telefono('TEL7', 'Teléfono secundario');
    insertar_tipo_telefono('TEL8', 'Teléfono casa');
    insertar_tipo_telefono('TEL9', 'Teléfono principal');
    insertar_tipo_telefono('TEL10', 'Teléfono negocio');
END;
/

CREATE OR REPLACE PROCEDURE insertar_tipo_email (
    p_id_email VARCHAR2,
    p_descripcion VARCHAR2
) AS
BEGIN
    INSERT INTO Tipo_Email (Id_Email, descripcion) 
    VALUES (p_id_email, p_descripcion);
END;
/

BEGIN
    insertar_tipo_email('EMAIL1', 'Correo personal');
    insertar_tipo_email('EMAIL2', 'Correo trabajo');
    insertar_tipo_email('EMAIL3', 'Correo emergencia');
    insertar_tipo_email('EMAIL4', 'Correo familiar');
    insertar_tipo_email('EMAIL5', 'Correo secundario');
    insertar_tipo_email('EMAIL6', 'Correo administrativo');
    insertar_tipo_email('EMAIL7', 'Correo oficial');
    insertar_tipo_email('EMAIL8', 'Correo ventas');
    insertar_tipo_email('EMAIL9', 'Correo soporte');
    insertar_tipo_email('EMAIL10', 'Correo información');
END;
/

CREATE OR REPLACE PROCEDURE insertar_profesion (
    p_id_cliente VARCHAR2,
    p_id_profesion VARCHAR2,
    p_tipo_profesion VARCHAR2
) AS
BEGIN
    INSERT INTO Profesion (Id_Cliente, Id_profesion, tipo_profesion) 
    VALUES (p_id_cliente, p_id_profesion, p_tipo_profesion);
END;
/

BEGIN
    insertar_profesion('1', 'PROF1', 'Abogado');
    insertar_profesion('2', 'PROF2', 'Ingeniero');
    insertar_profesion('3', 'PROF3', 'Médico');
    insertar_profesion('4', 'PROF4', 'Profesor');
    insertar_profesion('5', 'PROF5', 'Arquitecto');
    insertar_profesion('6', 'PROF6', 'Contador');
    insertar_profesion('7', 'PROF7', 'Diseñador');
    insertar_profesion('8', 'PROF8', 'Programador');
    insertar_profesion('9', 'PROF9', 'Economista');
    insertar_profesion('10', 'PROF10', 'Psicólogo');
END;
/

CREATE OR REPLACE PROCEDURE insertar_tipo_prestamo (
    p_id_prestamo VARCHAR2,
    p_tipo_prestamo VARCHAR2
) AS
BEGIN
    INSERT INTO Tipo_Prestamo (Id_Prestamo, Tipo_Prestamo) 
    VALUES (p_id_prestamo, p_tipo_prestamo);
END;
/

BEGIN
    insertar_tipo_prestamo('PREST1', 'Préstamo personal');
    insertar_tipo_prestamo('PREST2', 'Préstamo hipotecario');
    insertar_tipo_prestamo('PREST3', 'Préstamo automotriz');
    insertar_tipo_prestamo('PREST4', 'Préstamo educativo');
    insertar_tipo_prestamo('PREST5', 'Préstamo de negocios');
    insertar_tipo_prestamo('PREST6', 'Préstamo de emergencia');
    insertar_tipo_prestamo('PREST7', 'Préstamo de consolidación');
    insertar_tipo_prestamo('PREST8', 'Préstamo para vacaciones');
    insertar_tipo_prestamo('PREST9', 'Préstamo para mejoras del hogar');
    insertar_tipo_prestamo('PREST10', 'Préstamo para viajes');
END;
/


CREATE OR REPLACE PROCEDURE insertar_prestamo_aprobado (
    p_id_cliente VARCHAR2,
    p_id_prestamo VARCHAR2,
    p_monto_aproved NUMBER,
    p_letra_mensual NUMBER,
    p_monto_pago NUMBER,
    p_tasa_interes NUMBER,
    p_fecha_pago DATE,
    p_fecha_aprob DATE,
    p_saldo_actual NUMBER,
    p_interes_pagado NUMBER,
    p_fecha_modificacion VARCHAR2,
    p_usuario VARCHAR2,
    p_cod_sucursal VARCHAR2
) AS
    v_num_prestamo NUMBER;
BEGIN
    -- Insertar en la tabla Prestamo
    INSERT INTO Prestamo (
        id_Cliente,
        id_prestamo,
        monto_aproved,
        letra_mensual,
        num_prestamo,
        monto_pago,
        Tasa_interes,
        fecha_pago,
        fecha_aprob,
        saldo_actual,
        interes_pagado,
        fecha_modificacion,
        usuario,
        cod_sucursal
    ) VALUES (
        p_id_cliente,
        p_id_prestamo,
        p_monto_aproved,
        p_letra_mensual,
        seq_prestamo.NEXTVAL, 
        p_monto_pago,
        p_tasa_interes,
        p_fecha_pago,
        p_fecha_aprob,
        p_saldo_actual,
        p_interes_pagado,
        p_fecha_modificacion,
        p_usuario,
        p_cod_sucursal
    ) RETURNING num_prestamo INTO v_num_prestamo;

    -- Actualizar la tabla Tipo_prestamo_sucursal
    -- Si no existe, crear el registro en Tipo_prestamo_sucursal
    IF SQL%NOTFOUND THEN
        INSERT INTO Tipo_prestamo_sucursal (cod_sucursal, Id_prestamo, monto_prest)
        VALUES (p_cod_sucursal, p_id_prestamo, p_monto_aproved);
    ELSE
        -- Si existe, simplemente actualizar el monto_prest
        UPDATE Tipo_prestamo_sucursal
        SET monto_prest = p_monto_aproved
        WHERE cod_sucursal = p_cod_sucursal
          AND Id_prestamo = p_id_prestamo;
    END IF;

    -- Commit de la transacción para hacer los cambios permanentes
    COMMIT;

    -- Mensaje de confirmación
    DBMS_OUTPUT.PUT_LINE('Préstamo insertado y actualizado correctamente.');
EXCEPTION
    WHEN OTHERS THEN
        -- Manejar cualquier error y mostrar un mensaje de error
        DBMS_OUTPUT.PUT_LINE('Error al insertar o actualizar el préstamo: ' || SQLERRM);
        ROLLBACK; -- Revertir la transacción en caso de error
END;
/

CREATE OR REPLACE PROCEDURE insertar_transaccion_pago (
    p_id_transaccion VARCHAR2,
    p_monto_pago NUMBER,
    p_fecha_transaccion DATE,
    p_fecha_insercion DATE,
    p_usuario VARCHAR2,
    p_id_cliente VARCHAR2,
    p_cod_sucursal VARCHAR2,
    p_id_prestamo VARCHAR2
) AS
BEGIN
    INSERT INTO Transacpagos (
        id_transaccion,
        monto_pago,
        fecha_transaccion,
        fecha_insercion,
        usuario,
        id_cliente,
        cod_sucursal,
        id_prestamo
    ) VALUES (
        p_id_transaccion,
        p_monto_pago,
        p_fecha_transaccion,
        p_fecha_insercion,
        p_usuario,
        p_id_cliente,
        p_cod_sucursal,
        p_id_prestamo
    );

    -- Commit de la transacción para hacer los cambios permanentes
    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        -- Manejar cualquier error y mostrar un mensaje de error
        DBMS_OUTPUT.PUT_LINE('Error al insertar la transacción de pago: ' || SQLERRM);
        ROLLBACK; -- Revertir la transacción en caso de error
END;
/

BEGIN
    insertar_transaccion_pago('TRANS001', 1500, TO_DATE('2024-06-18', 'YYYY-MM-DD'), SYSDATE, 'Usuario1', 'CL001', 'SUC1', 'P001');
    insertar_transaccion_pago('TRANS002', 1200, TO_DATE('2024-06-18', 'YYYY-MM-DD'), SYSDATE, 'Usuario2', 'CL002', 'SUC2', 'P002');
    insertar_transaccion_pago('TRANS003', 1800, TO_DATE('2024-06-19', 'YYYY-MM-DD'), SYSDATE, 'Usuario3', 'CL003', 'SUC3', 'P003');
    insertar_transaccion_pago('TRANS004', 1350, TO_DATE('2024-06-19', 'YYYY-MM-DD'), SYSDATE, 'Usuario1', 'CL004', 'SUC1', 'P004');
    insertar_transaccion_pago('TRANS005', 1650, TO_DATE('2024-06-20', 'YYYY-MM-DD'), SYSDATE, 'Usuario2', 'CL005', 'SUC2', 'P005');
    insertar_transaccion_pago('TRANS006', 1400, TO_DATE('2024-06-20', 'YYYY-MM-DD'), SYSDATE, 'Usuario3', 'CL006', 'SUC3', 'P006');
    insertar_transaccion_pago('TRANS007', 1700, TO_DATE('2024-06-21', 'YYYY-MM-DD'), SYSDATE, 'Usuario1', 'CL007', 'SUC1', 'P007');
    insertar_transaccion_pago('TRANS008', 1250, TO_DATE('2024-06-21', 'YYYY-MM-DD'), SYSDATE, 'Usuario2', 'CL008', 'SUC2', 'P008');
    insertar_transaccion_pago('TRANS009', 1550, TO_DATE('2024-06-22', 'YYYY-MM-DD'), SYSDATE, 'Usuario3', 'CL009', 'SUC3', 'P009');
    insertar_transaccion_pago('TRANS010', 1450, TO_DATE('2024-06-22', 'YYYY-MM-DD'), SYSDATE, 'Usuario1', 'CL010', 'SUC1', 'P010');
END;
/

BEGIN
    insertar_prestamo_aprobado(
        'CL001', -- id_cliente
        'PREST1', -- id_prestamo
        50000, -- monto_aproved
        1500, -- letra_mensual
        1500, -- monto_pago
        5.0, -- tasa_interes
        TO_DATE('2024-07-15', 'YYYY-MM-DD'), -- fecha_pago
        TO_DATE('2024-06-01', 'YYYY-MM-DD'), -- fecha_aprob
        50000, -- saldo_actual
        0, -- interes_pagado
        TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'), -- fecha_modificacion
        'Usuario1', -- usuario
        'SUC1' -- cod_sucursal
    );

    insertar_prestamo_aprobado(
        'CL002', -- id_cliente
        'PREST2', -- id_prestamo
        150000, -- monto_aproved
        4500, -- letra_mensual
        4500, -- monto_pago
        4.5, -- tasa_interes
        TO_DATE('2024-07-15', 'YYYY-MM-DD'), -- fecha_pago
        TO_DATE('2024-06-01', 'YYYY-MM-DD'), -- fecha_aprob
        150000, -- saldo_actual
        0, -- interes_pagado
        TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'), -- fecha_modificacion
        'Usuario2', -- usuario
        'SUC2' -- cod_sucursal
    );

    insertar_prestamo_aprobado(
        'CL003', -- id_cliente
        'PREST3', -- id_prestamo
        30000, -- monto_aproved
        900, -- letra_mensual
        900, -- monto_pago
        3.0, -- tasa_interes
        TO_DATE('2024-07-15', 'YYYY-MM-DD'), -- fecha_pago
        TO_DATE('2024-06-01', 'YYYY-MM-DD'), -- fecha_aprob
        30000, -- saldo_actual
        0, -- interes_pagado
        TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'), -- fecha_modificacion
        'Usuario3', -- usuario
        'SUC3' -- cod_sucursal
    );

    insertar_prestamo_aprobado(
        'CL004', -- id_cliente
        'PREST4', -- id_prestamo
        20000, -- monto_aproved
        600, -- letra_mensual
        600, -- monto_pago
        4.0, -- tasa_interes
        TO_DATE('2024-07-15', 'YYYY-MM-DD'), -- fecha_pago
        TO_DATE('2024-06-01', 'YYYY-MM-DD'), -- fecha_aprob
        20000, -- saldo_actual
        0, -- interes_pagado
        TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'), -- fecha_modificacion
        'Usuario4', -- usuario
        'SUC4' -- cod_sucursal
    );

    insertar_prestamo_aprobado(
        'CL005', -- id_cliente
        'PREST5', -- id_prestamo
        100000, -- monto_aproved
        3000, -- letra_mensual
        3000, -- monto_pago
        5.0, -- tasa_interes
        TO_DATE('2024-07-15', 'YYYY-MM-DD'), -- fecha_pago
        TO_DATE('2024-06-01', 'YYYY-MM-DD'), -- fecha_aprob
        100000, -- saldo_actual
        0, -- interes_pagado
        TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'), -- fecha_modificacion
        'Usuario5', -- usuario
        'SUC5' -- cod_sucursal
    );
END;
/

CREATE OR REPLACE PROCEDURE actualizar_pagos_prestamos AS
    CURSOR cur_pagos IS
        SELECT id_transaccion, monto_pago, id_prestamo, cod_sucursal
        FROM Transacpagos
        ORDER BY fecha_insercion; -- Ordenar por fecha de inserción, asumiendo que la fecha indica el orden de aplicación

    v_saldo_prestamo NUMBER;
    v_interes NUMBER;
    v_monto_pagado NUMBER;
BEGIN
    FOR rec_pago IN cur_pagos LOOP
        -- Calcular el interés
        v_interes := calcular_interes(rec_pago.id_prestamo); -- Función para calcular el interés

        -- Obtener el saldo actual del préstamo
        SELECT saldo_actual INTO v_saldo_prestamo
        FROM Prestamo
        WHERE num_prestamo = rec_pago.id_prestamo;

        -- Aplicar el pago del interés
        v_monto_pagado := rec_pago.monto_pago;
        IF v_monto_pagado >= v_interes THEN
            v_monto_pagado := v_monto_pagado - v_interes;
            v_saldo_prestamo := v_saldo_prestamo - v_interes;
        ELSE
            v_interes := v_monto_pagado;
            v_monto_pagado := 0;
            v_saldo_prestamo := v_saldo_prestamo - v_interes;
        END IF;

        -- Aplicar el pago al saldo del préstamo
        IF v_monto_pagado > 0 THEN
            v_saldo_prestamo := v_saldo_prestamo - v_monto_pagado;
        END IF;

        -- Actualizar el saldo del préstamo
        UPDATE Prestamo
        SET saldo_actual = v_saldo_prestamo,
            interes_pagado = interes_pagado + v_interes,
            monto_pago = monto_pago + rec_pago.monto_pago
        WHERE num_prestamo = rec_pago.id_prestamo;

        -- Actualizar el monto prestado en la tabla Tipo_prestamo_sucursal
        UPDATE Tipo_prestamo_sucursal
        SET monto_prest = monto_prest - v_monto_pagado
        WHERE cod_sucursal = rec_pago.cod_sucursal
          AND Id_prestamo = rec_pago.id_prestamo;

        -- Commit de la transacción para hacer los cambios permanentes
        COMMIT;

        -- Mensaje de registro de la transacción
        DBMS_OUTPUT.PUT_LINE('Pago actualizado para transacción ' || rec_pago.id_transaccion);
    END LOOP;
EXCEPTION
    WHEN OTHERS THEN
        -- Manejar cualquier error y mostrar un mensaje de error
        DBMS_OUTPUT.PUT_LINE('Error al actualizar pagos: ' || SQLERRM);
        ROLLBACK; -- Revertir la transacción en caso de error
END;
/













-- esta funcion es para el procedimiento anterior xd
CREATE OR REPLACE FUNCTION calcular_interes(p_id_prestamo NUMBER) 
RETURN NUMBER IS
    v_interes NUMBER;
    v_tasa_interes NUMBER;
    v_saldo_actual NUMBER;
BEGIN
    -- Obtener la tasa de interés y el saldo actual del préstamo
    SELECT Tasa_interes, saldo_actual INTO v_tasa_interes, v_saldo_actual
    FROM Prestamo
    WHERE num_prestamo = p_id_prestamo;

    -- Calcular el interés (asumiendo un cálculo de interés simple)
    v_interes := v_saldo_actual * v_tasa_interes / 100;

    RETURN v_interes;
END;
/