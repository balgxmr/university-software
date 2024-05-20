/* Bloque 1 */
DECLARE
  V_COUNTER BINARY_INTEGER := 1;
BEGIN
  LOOP
 -- Insertar una fila en temp__table con el valor actual del
 -- contador del bucle.
    INSERT INTO TEMP_TABLE VALUES (
      V_COUNTER,
      ‘LOOP INDEX’
    );
    V_COUNTER := V_COUNTER + 1;
 -- Condición de salida – Cuando el contador
 -- del bucle sea > 50 se saldrá del bucle
    IF V_COUNTER > 50 THEN
      EXIT;
    END IF;
  END LOOP;
END;

/* Bloque 2 */
DECLARE
v_counter BINARY_INTEGER := 1;
BEGIN
  LOOP
  -- Insertar una fila en temp__table con el valor actual del
  -- contador del bucle.
  INSERT INTO temp_table VALUES (v_counter, ‘Loop Index’);
  v_counter := v_counter + 1;
  -- Condición de salida – Cuando el contador
  -- del bucle sea > 50 se saldrá del bucle
  EXIT WHEN v_counter > 50;
  END LOOP;
END;