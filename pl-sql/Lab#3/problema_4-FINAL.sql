CREATE TABLE BIRTHDAY (
  ID_STUD NUMBER PRIMARY KEY NOT NULL,
  NOMBRE_STUD VARCHAR(100) NOT NULL,
  BIRTHDAY_STUD DATE NOT NULL
);

DECLARE
  v_Id birthday.id_stud%type;
  v_Nombre birthday.nombre_stud%type;
  v_Birthday birthday.birthday_stud%type;

-- Bucle FOR para capturar los datos de los estudiantes.
BEGIN
FOR id IN 1..5
LOOP
  v_ID := id;

  -- Se captura el nombre de los cinco estudiantes
  CASE id
    WHEN 1 THEN
      v_Nombre := '&Nombre_Estudiante_1';
      v_Birthday := TO_DATE('&Cumpleanos_Estudiante_1', 'DD/MM/YYYY');
    WHEN 2 THEN
      v_Nombre := '&Nombre_Estudiante_2';
      v_Birthday := TO_DATE('&Cumpleanos_Estudiante_2', 'DD/MM/YYYY');
    WHEN 3 THEN
      v_Nombre := '&Nombre_Estudiante_3';
      v_Birthday := TO_DATE('&Cumpleanos_Estudiante_3', 'DD/MM/YYYY');
    WHEN 4 THEN
      v_Nombre := '&Nombre_Estudiante_4';
      v_Birthday := TO_DATE('&Cumpleanos_Estudiante_4', 'DD/MM/YYYY');
    WHEN 5 THEN
      v_Nombre := '&Nombre_Estudiante_5';
      v_Birthday := TO_DATE('&Cumpleanos_Estudiante_5', 'DD/MM/YYYY');
  END CASE;

  -- Insertar los datos en la tabla
  INSERT INTO BIRTHDAY (id_stud, nombre_stud, birthday_stud)
  VALUES (v_Id, v_Nombre, v_Birthday);
END LOOP; -- FIN bucle FOR

-- Manejo de excepciones
EXCEPTION
  /* Si se intenta insertar una identificación que ya existe en la tabla (clave primaria duplicada),
   * se captura la excepción DUP_VAL_ON_INDEX. 
   */
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('ERROR: Una o varias identificaciones ya están presentes. Verifica que las IDs ingresadas no estén duplicadas.');

  -- Manejo de otros tipos de errores
  WHEN OTHERS THEN
    -- SQLCODE proporciona el código de error SQL asociado con la excepción.

    /* Si se inserta un dato nulo en una columna que no permite valores nulos,
     * se captura la excepción -1400 y se imprime un mensaje de error correspondiente. */
    IF SQLCODE = -1400 THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: Se insertó un dato NULO. Asegúrate de llenar correctamente los datos.');

    -- Si se intenta insertar una fecha inválida o en un formato incorrecto.
    ELSIF SQLCODE = -1840 THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: Se insertó una fecha inválida. El formato ha de ser el siguiente: DD/MM/YYYY.');

    -- Para cuando se inserta una fecha con caracteres no numéricos en el formato
    ELSIF SQLCODE = -1858 THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: Se insertó una letra en fecha. La fecha sólo acepta valores numéricos.');
    -- Si se produce cualquier otro error no controlado anteriormente,
    -- se imprime un mensaje de error general que muestra el mensaje de error SQL asociado.
    ELSE
      DBMS_OUTPUT.PUT_LINE('ERROR ' || SQLERRM);
    END IF;
END;
/