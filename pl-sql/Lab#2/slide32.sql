DECLARE
    v_CurrentCredits students.current_credits%TYPE; -- Se hace uso del %TYPE
BEGIN
    SELECT current_credits
    INTO v_CurrentCredits
    FROM students
    WHERE id = 10002;

    -- Pasamos por pantalla los resultados.
    DBMS_OUTPUT.PUT_LINE('Créditos: ' || v_CurrentCredits);
  EXCEPTION -- Añadimos manejo de errores
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontró data para el estudiante con ID 10002');
END;