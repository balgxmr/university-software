DECLARE
v_counter BINARY_INTEGER := 7;
BEGIN
  -- Inserta el valor 7 en la tabla temp_table.
  INSERT INTO temp_table (num_col) VALUES (v_counter);
  -- Este bucle declara de nuevo v_counter como BINARY_INTEGER, lo
  -- que anula la declaración de NUMBER de v_counter
  FOR v_counter IN 20.. 30 LOOP
  --Dentro del bucle, el rango de v_counter es de 20 a 30
    INSERT INTO temp_table (num_col) VALUES (v_counter);
  END LOOP;
  --- Inserta otro 7 en la tabla temp_table
  INSERT INTO temp_table (num_col) VALUES (v_counter);
END;