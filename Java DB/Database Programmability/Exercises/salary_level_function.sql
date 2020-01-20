CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
  RETURNS VARCHAR(255)
  BEGIN
    IF (salary < 30000)
    THEN
      RETURN 'Low';
    ELSEIF (salary BETWEEN 30000 AND 50000)
      THEN
        RETURN 'Average';
    ELSE
      RETURN 'High';
    END IF;
  END;