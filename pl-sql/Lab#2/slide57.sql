DECLARE
  V_ROOM ROOM%ROWTYPE;
BEGIN
 -- Recupera una fila de la tabla room
  SELECT * INTO V_ROOM WHERE ROWID = 1;
  <<INSERT_LABEL>>
  INSERT INTO TEMP_TABLE (
    CHAR_COL
  ) VALUES (
    'Found a row'
  );
/*
 * Abajo el manejo de excepción se corrigió a WHEN en vez de WHERE.
 * 
 * NO usar GOTO dentro de una excepción. En este caso mejor no hacer nada.

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      NULL;
*/
END;
