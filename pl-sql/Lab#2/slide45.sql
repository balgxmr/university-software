/* Bloque 1 */
DECLARE
  V_NUMBER1 NUMBER := 10; -- Asignamos un valor inicial a v_Number1
  V_NUMBER2 NUMBER := 5; -- Asignamos un valor inicial a v_Number2
  V_RESULT  VARCHAR2(7); -- Utilizamos VARCHAR2()
BEGIN
  IF V_NUMBER1 < V_NUMBER2 THEN -- Gracias a que añadimos valores a v_Number{1,2}, ahora si se puede realizar la comparación.
    V_RESULT := 'Yes';
  ELSE
    V_RESULT := 'No';
  END IF;
END;

/* Bloque 2 */
DECLARE
  V_NUMBER1 NUMBER := 10; -- Asignamos un valor inicial a v_Number1
  V_NUMBER2 NUMBER := 5; -- Asignamos un valor inicial a v_Number2
  V_RESULT  VARCHAR2(7); -- Utilizamos VARCHAR2()
BEGIN
  IF V_NUMBER1 >= V_NUMBER2 THEN -- Gracias a que añadimos valores a v_Number{1,2}, ahora si se puede realizar la comparación.
    V_RESULT := 'No';
  ELSE
    V_RESULT := 'Yes';
  END IF;
END;