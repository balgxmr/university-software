DECLARE
    v_RoomID classes.room_id%TYPE;
    v_RoomID2 v_RoomID%TYPE; -- Se eliminó el espacio en blanco.
    v_TempVar NUMBER(7,3) NOT NULL := 12.3;
    v_AnotherVar NUMBER(7,3); -- Previamente devolvía sólo NUMBER(7,3). No tomaba en cuenta la restricción