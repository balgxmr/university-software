  create table rooms(room_id number PRIMARY KEY, number_seats number);

  SET SERVEROUTPUT ON

  DECLARE
    v_NumberSeats rooms.number_seats%TYPE;
    v_Comment VARCHAR2(35); -- Utilizamos VARCHAR2()
  BEGIN
   /* Extrae el número de asiento de la habitación, cuyo identificador es 99999 y almacena el resultado en v_NumberSeats. */
    INSERT INTO rooms (room_id, number_seats) VALUES (99999, 20);
    SELECT number_seats
    INTO v_NumberSeats
    FROM rooms
    WHERE room_id = 99999;

    IF v_NumberSeats < 50 THEN
      v_comment := 'Fairly small';
    ELSIF v_NumberSeats < 100 THEN
      v_comment := 'A little bigger';
    ELSE
      v_comment := 'Lots of room';
    END IF;

    DBMS_OUTPUT.PUT_LINE('The room is a little ' || v_comment);

    EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('No hay data para room_id 99999');
  END;

CREATE VIEW room_comments AS
SELECT room_id,
    CASE 
        WHEN number_seats < 50 THEN 'Fairly small'
        WHEN number_seats < 100 THEN 'A little bigger'
        ELSE 'Lots of room'
    END CASE
FROM rooms
WHERE room_id = 99999;