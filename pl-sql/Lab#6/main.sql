/* Creación de tablas */
CREATE TABLE Colaboradores (
    id_codcolaborador NUMBER PRIMARY KEY,
    nombre VARCHAR2(25),
    apellido VARCHAR2(25),
    cedula VARCHAR2(12),
    sexo CHAR(1),
    fecha_nacimiento DATE,
    fecha_ingreso DATE,
    status CHAR(1),
    salario_mensual NUMBER(15,2)
);

CREATE TABLE salario_quincenal (
    id_salario NUMBER PRIMARY KEY,
    id_codcolaborador NUMBER,
    fecha_pago DATE,
    salario_quincenal NUMBER(15,2),
    seguro_social NUMBER(15,2),
    seguro_educativo NUMBER(15,2),
    salario_neto NUMBER(15,2),
    CONSTRAINT fk_colaborador
        FOREIGN KEY (id_codcolaborador) REFERENCES Colaboradores(id_codcolaborador)
);



/* Secuencias */
CREATE SEQUENCE sec_ColaboradorId
  START WITH 1
  INCREMENT BY 1
  maxvalue 99999
  minvalue 1;

CREATE SEQUENCE sec_CodSalario
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 99999
  MINVALUE 1;


/* Procedimiento */
CREATE OR REPLACE PROCEDURE insertar_Colaborador (
    p_nombre IN Colaboradores.nombre%TYPE,
    p_apellido IN Colaboradores.apellido%TYPE,
    p_cedula IN Colaboradores.cedula%TYPE,
    p_sexo IN Colaboradores.sexo%TYPE,
    p_fecha_nacimiento IN Colaboradores.fecha_nacimiento%TYPE,
    p_fecha_ingreso IN Colaboradores.fecha_ingreso%TYPE,
    p_status IN Colaboradores.status%TYPE,
    p_salario_mensual IN Colaboradores.salario_mensual%TYPE
) IS
BEGIN
    INSERT INTO Colaboradores (
        sec_ColaboradorId.NEXTVAL, nombre, apellido, cedula, sexo, fecha_nacimiento, fecha_ingreso, status, salario_mensual
    ) VALUES (
        p_id_codcolaborador, p_nombre, p_apellido, p_cedula, p_sexo, p_fecha_nacimiento, p_fecha_ingreso, p_status, p_salario_mensual
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

END insertar_Colaborador;
/

BEGIN
    insertar_Colaborador('Richard', 'Herranz', '1234567890', 'M', TO_DATE('1980-05-15', 'YYYY-MM-DD'), TO_DATE('2020-01-10', 'YYYY-MM-DD'), 'A', 2000.00);
    insertar_Colaborador('Jose', 'Encalada', '1234567891', 'F', TO_DATE('1985-07-22', 'YYYY-MM-DD'), TO_DATE('2019-03-15', 'YYYY-MM-DD'), 'A', 2500.00);
    insertar_Colaborador('Jonathan', 'Nunez', '1234567892', 'M', TO_DATE('1990-10-05', 'YYYY-MM-DD'), TO_DATE('2018-05-20', 'YYYY-MM-DD'), 'A', 2300.00);
    insertar_Colaborador('Miguel', 'Ortega', '1234567893', 'F', TO_DATE('1995-12-11', 'YYYY-MM-DD'), TO_DATE('2017-07-25', 'YYYY-MM-DD'), 'A', 2200.00);
    insertar_Colaborador('Carlos', 'Garcia', '1234567894', 'M', TO_DATE('1982-03-30', 'YYYY-MM-DD'), TO_DATE('2021-08-30', 'YYYY-MM-DD'), 'A', 2100.00);
    insertar_Colaborador('Elena', 'Rodriguez', '1234567895', 'F', TO_DATE('1988-11-19', 'YYYY-MM-DD'), TO_DATE('2016-09-10', 'YYYY-MM-DD'), 'A', 2400.00);
    insertar_Colaborador('Sofia', 'Fernandez', '1234567896', 'F', TO_DATE('1992-04-25', 'YYYY-MM-DD'), TO_DATE('2015-10-10', 'YYYY-MM-DD'), 'V', 2200.00);
    insertar_Colaborador('Miguel', 'Hernandez', '1234567897', 'M', TO_DATE('1983-06-18', 'YYYY-MM-DD'), TO_DATE('2014-11-20', 'YYYY-MM-DD'), 'V', 2350.00);
    insertar_Colaborador('Laura', 'Ruiz', '1234567898', 'F', TO_DATE('1987-01-14', 'YYYY-MM-DD'), TO_DATE('2013-12-30', 'YYYY-MM-DD'), 'R', 2000.00);
    insertar_Colaborador('Pedro', 'Jimenez', '1234567899', 'M', TO_DATE('1981-02-07', 'YYYY-MM-DD'), TO_DATE('2012-04-01', 'YYYY-MM-DD'), 'R', 2500.00);
END;
/


CREATE OR REPLACE PROCEDURE pagar_SalarioQuincenal as
CURSOR c_SalarioColaboradores IS
    SELECT id_codcolaborador, salario_mensual 
    FROM Colaboradores
    WHERE status = 'A';

v_SeguroSocial Colaboradores.salario_mensual%TYPE;
v_SeguroEducativo Colaboradores.salario_mensual%TYPE;
v_SalarioNeto Colaboradores.salario_mensual%TYPE;
v_SalarioQuincenal Colaboradores.salario_mensual%TYPE;

BEGIN
    FOR colaborador_datos IN c_SalarioColaboradores LOOP
        v_SalarioQuincenal := colaborador_datos.salario_mensual / 2;
        v_SeguroSocial := (v_SalarioQuincenal) * 0.0975;
        v_SeguroEducativo := (v_SalarioQuincenal) * 0.0125;
        v_SalarioNeto := (v_SalarioQuincenal) - v_SeguroSocial - v_SeguroEducativo;

        INSERT INTO salario_quincenal (id_salario, id_codcolaborador, fecha_pago, salario_quincenal, seguro_social, seguro_educativo, salario_neto)
        VALUES (sec_CodSalario.NEXTVAL, colaborador_datos.id_codcolaborador, SYSDATE, v_SalarioQuincenal, v_SeguroSocial, v_SeguroEducativo, v_SalarioNeto);

        COMMIT;
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

END;
/


SET LINESIZE 150
SET PAGESIZE 50

COLUMN id_codcolaborador HEADING 'ID Colab' FORMAT 9999
COLUMN nombre HEADING 'Nombre' FORMAT A20
COLUMN apellido HEADING 'Apellido' FORMAT A20
COLUMN salario_mensual HEADING 'Salario Mensual' FORMAT 999,999.99
COLUMN salario_quincenal HEADING 'Salario Quincenal' FORMAT 999,999.99
COLUMN seguro_social HEADING 'Seguro Social' FORMAT 999,999.99
COLUMN seguro_educativo HEADING 'Seguro Educativo' FORMAT 999,999.99
COLUMN salario_neto HEADING 'Salario Neto' FORMAT 999,999.99


CREATE OR REPLACE VIEW colaboradores_Salarios AS
SELECT
    c.id_codcolaborador,
    c.nombre,
    c.apellido,
    c.salario_mensual,
    sq.salario_quincenal,
    sq.seguro_social,
    sq.seguro_educativo,
    sq.salario_neto
FROM
    Colaboradores c
JOIN
    salario_quincenal sq ON c.id_codcolaborador = sq.id_codcolaborador
ORDER BY c.id_codcolaborador;