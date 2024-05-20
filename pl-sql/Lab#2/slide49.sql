DECLARE
v_counter BINARY_INTEGER;
BEGIN
v_counter := 1; -- Se inicializa el contador
WHILE v_counter <= 50 LOOP
  INSERT INTO temp_table
  VALUES (v_counter, ‘Loop Index’);
  v_counter := v_counter + 1;
  END LOOP;
END;