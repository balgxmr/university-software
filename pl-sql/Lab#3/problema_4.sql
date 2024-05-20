DECLARE
  v_counter NUMBER := 1;
  v_name VARCHAR2(20);
  v_birthday DATE;
  v_OutPutAll VARCHAR2(100);

BEGIN
  WHILE v_counter < 6 LOOP   
    v_name := '&name';
    v_birthday := '&birthday';
    INSERT INTO Birthday
    VALUES (v_counter, v_name, v_birthday);
    v_counter := v_counter + 1;
  END LOOP;
  
  /*
  v_counter := '&counter'; -- Solicitando el input de v_counter
  
  -- Seleccionando datos de la tabla basados en v_counter
  SELECT name || ' ' || birthday INTO v_OutPutAll
  FROM Birthday
  WHERE counter = v_counter;
  
  -- Imprimiendo los resultados
  DBMS_OUTPUT.PUT_LINE(v_OutPutAll);
  */
END;
/

CREATE TABLE BIRTHDAY(
   counter NUMBER,
   name VARCHAR2(20),
   birthday DATE
);