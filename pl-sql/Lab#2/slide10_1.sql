CREATE OR REPLACE TRIGGER OnlyPositive
BEFORE INSERT OR UPDATE OF num_col
ON temp_table
FOR EACH ROW
BEGIN
IF :new.num_col < 0 THEN
  RAISE_APPLICATION_ERROR (-2000, ‘Please insert a positive value’);
  END IF;
END OnlyPositive ;