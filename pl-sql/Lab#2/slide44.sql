DECLARE
 v_Number1 NUMBER := 10; -- Asignamos un valor inicial a v_Number1
 v_Number2 NUMBER := 5; -- Asignamos un valor inicial a v_Number2
 v_Result  VARCHAR2(35);
BEGIN
  IF v_Number1 < v_Number2 THEN -- Gracias a que añadimos valores a v_Number{1,2}, ahora si se puede realizar la comparación.
     v_Result := 'Yes';
  ELSE
     v_Result := 'No';
  END IF;
END;
