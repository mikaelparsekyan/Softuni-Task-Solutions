CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(255))
  BEGIN
    SELECT
      first_name,
      last_name
    FROM `employees` AS e
      JOIN `addresses` AS a
        ON a.address_id = e.address_id
      JOIN `towns` AS t
        ON t.town_id = a.town_id AND t.name = town_name
    ORDER BY first_name ASC, last_name ASC, employee_id ASC;
  END;