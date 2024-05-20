create table students(studentID number, firstName varchar2(50));

CREATE TABLE log_table (
    info VARCHAR2(255),
    log_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 
);


DECLARE
/* Inicio de la sección declarativa */
v_StudentID students.studentID%TYPE; -- Se hace uso de %TYPE
v_FirstName students.firstName%TYPE; -- Se hace uso de %TYPE
id NUMBER;


BEGIN
  /* Inicio de la sección de ejecutable */
  id := 10000;
  v_StudentID := 10000; --Inicializo la variable v_StudentID
  -- Recupera el nombre del estudiante con ID igual a 10,000
  SELECT firstName INTO v_FirstName -- Se corrige firt_name a first_name.
  FROM students
  WHERE id = v_StudentID;
  EXCEPTION
  /* Inicio de la sección de excepciones */
  WHEN NO_DATA_FOUND THEN
  -- Manejo de la codificación de error
  INSERT INTO log_table (info) VALUES (‘Student 10,000 does not exists!’);
END;
