CREATE TABLE ESTUDIANTE(
  NUM_ESTUDIANTE NUMBER,
  CEDULA VARCHAR2(15),
  NOMBRE VARCHAR2(50),
  APELLIDO VARCHAR2(50),
  CALIFICACION_FINAL VARCHAR2(1)
);
** ORIGINAL ARRIBA


DECLARE
CREATE TABLE Estudiante (
  Num_Estudiante NUMBER PRIMARY KEY,
  Cedula VARCHAR2(20) NOT NULL,
  Nombre VARCHAR2(50) NOT NULL,
  Apellido VARCHAR2(50) NOT NULL,
  Calificacion_Final VARCHAR2(1) NOT NULL
);


BEGIN
v_Num_Estudiante := '&Num_Estudiante';
v_Cedula := '&Cedula';
v_Nombre := '&Nombre';
v_Apellido := '&Apellido';
v_Calificacion_Final := '&Calificacion_Final';


INSERT INTO Estudiante(Num_Estudiante, Cedula, Nombre, Apellido, Calificacion_Final)
VALUES (v_Num_Estudiante, v_Cedula, v_Nombre, v_Apellido, v_Calificacion_Final);


SELECT Num_Estudiante
INTO v_Num_Estudiante
FROM Estudiante
WHERE Num_Estudiante = 001;


SELECT Calificacion_Final
INTO v_Calificacion_Final
FROM Estudiante
WHERE Num_Estudiante = 001;


DBMS_OUTPUT.PUT_LINE('Su nombre y apellido es: ' || v_Nombre || ' ' ||  v_Apellido || ', y su calificacion es de: ' || v_Calificacion_Final || '.');


END;

