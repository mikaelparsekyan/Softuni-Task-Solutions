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
CREATE PROCEDURE usp_get_employees_by_salary_level(IN salary_level VARCHAR(255))
  SELECT
    first_name,
    last_name
  FROM `employees`
  WHERE ufn_get_salary_level(salary) = salary_level
  ORDER BY first_name DESC, last_name DESC;