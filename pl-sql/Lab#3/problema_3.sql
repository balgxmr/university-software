DECLARE
    v_Num1 NUMBER := 0;
    v_primo VARCHAR2(30) := 'Es un numero primo';
BEGIN
    v_Num1 := &captura;
    FOR cont IN 2 .. TRUNC(SQRT(v_Num1)) LOOP 
        IF MOD(v_Num1, cont) = 0 THEN
            v_primo := 'No es un número primo';
            EXIT; -- Salir del bucle si encuentra un divisor
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(v_primo);
END;