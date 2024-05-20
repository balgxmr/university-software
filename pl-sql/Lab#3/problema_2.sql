CREATE TABLE Estudiante (
  Num_Estudiante NUMBER PRIMARY KEY,
  Cedula VARCHAR2(20) NOT NULL UNIQUE, -- Para evitar cédulas duplicadas.
  Nombre VARCHAR2(50) NOT NULL,
  Apellido VARCHAR2(50) NOT NULL,
  Calificacion_Final VARCHAR2(1) NOT NULL
);

DECLARE
  v_Num_Estudiante Estudiante.Num_Estudiante%TYPE;
  v_Cedula Estudiante.Cedula%TYPE;
  v_Nombre Estudiante.Nombre%TYPE;
  v_Apellido Estudiante.Apellido%TYPE;
  v_Calificacion_Final Estudiante.Calificacion_Final%TYPE;

BEGIN
  -- Variables para almacenar los datos ingresados por el usuario
  v_Num_Estudiante := '&Num_Estudiante';
  v_Cedula := '&Cedula';
  v_Nombre := '&Nombre';
  v_Apellido := '&Apellido';
  v_Calificacion_Final := '&Calificacion_Final';

  -- Insertar datos en la tabla Estudiante
  INSERT INTO Estudiante(Num_Estudiante, Cedula, Nombre, Apellido, Calificacion_Final)
  VALUES (v_Num_Estudiante, v_Cedula, v_Nombre, v_Apellido, v_Calificacion_Final);

  SELECT Nombre, Apellido, Calificacion_Final
  INTO v_Nombre, v_Apellido, v_Calificacion_Final
  FROM Estudiante
  WHERE Num_Estudiante = v_Num_Estudiante;

  DBMS_OUTPUT.PUT_LINE('El estudiante ' || v_Nombre || ' ' ||  v_Apellido || ', tiene una calificación final de: ' || v_Calificacion_Final || '.');

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontraron datos para el estudiante con número ' || v_Num_Estudiante || '.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Ocurrió un error al recuperar los datos del estudiante.');

END;