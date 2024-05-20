DECLARE
  v_Ciudad VARCHAR2(50);
  v_Equipo VARCHAR2(50);
BEGIN
  v_Ciudad := UPPER('&ciudad'); -- Se transforma a mayúsculas ya que es case sensitive.

  CASE v_Ciudad
    WHEN 'MADRID' THEN
        v_Equipo := 'Real Madrid';
    WHEN 'BARCELONA' THEN
        v_Equipo := 'FC Barcelona';
    WHEN 'SEVILLA' THEN
        v_Equipo := 'Sevilla FC';
    WHEN 'VALENCIA' THEN
        v_Equipo := 'Valencia CF';
    WHEN 'BILBAO' THEN
        v_Equipo := 'Athletic Club Bilbao';
    WHEN 'MALAGA' THEN
        v_Equipo := 'Málaga CF';
    WHEN 'VIGO' THEN
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