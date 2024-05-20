DECLARE
  v_Ciudad VARCHAR2(50);
  v_Equipo VARCHAR2(50);
BEGIN
  v_Ciudad := '&ciudad';

  CASE v_Ciudad
    WHEN 'Madrid' THEN
        v_Equipo := 'Real Madrid';
    WHEN 'Barcelona' THEN
        v_Equipo := 'FC Barcelona';
    WHEN 'Sevilla' THEN
        v_Equipo := 'Sevilla FC';
    WHEN 'Valencia' THEN
        v_Equipo := 'Valencia CF';
    WHEN 'Bilbao' THEN
        v_Equipo := 'Athletic Club Bilbao';
    WHEN 'Malaga' THEN
        v_Equipo := 'Málaga CF';
    WHEN 'Vigo' THEN
        v_Equipo := 'Celta de Vigo';
    ELSE
        v_Equipo := 'Equipo no encontrado';
  END CASE;

  IF v_Equipo = 'Equipo no encontrado' THEN
    DBMS_OUTPUT.PUT_LINE('Su equipo no fue encontrado.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Su ciudad es: ' || v_Ciudad || ' y su equipo: ' || v_Equipo);
  END IF;
END;