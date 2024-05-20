DECLARE
v_counter BINARY_INTEGER := 1;
BEGIN
-- comprueba el contador del bucle antes de cada iteración
-- para asegurarse que todavía es menor a 50.
WHILE v_counter <= 50 LOOP
  INSERT INTO temp_table VALUES (v_counter, ‘Loop Index’);
  v_counter := v_counter + 1;
  END LOOP;
END;