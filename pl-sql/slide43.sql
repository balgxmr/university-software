DECLARE
v_NumberSeats rooms.number_seats%TYPE;
v_Comment VARCHAR(35);
BEGIN
/* Extrae el numero de asiento de la habitación, cuyo identificador es 99999 y almacena el resultado en
v_NumberSeats. */
SELECT number_seats
INTO v_NumberSeats
FROM rooms
WHERE room_id = 99999;
IF v_NumberSeats < 50 THEN
  v_comment := ‘ Fairly small’;
  INSERT INTO temp_table (char_col) VALUES (‘Nice and cozy’);
ELSE IF v_NumberSeats < 100 THEN
  v_comment := ‘ A litle bigger’;
  INSERT INTO temp_table (char_col) VALUES (‘Some breathing room ’);
ELSE
  v_comment := ‘ Lots of room’;
END IF;
END;