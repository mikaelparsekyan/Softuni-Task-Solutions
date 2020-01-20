CREATE PROCEDURE usp_get_towns_starting_with(str VARCHAR(255))
  BEGIN
    SELECT
      name AS town_name
    FROM `towns`
    WHERE name LIKE CONCAT(str, '%')
    ORDER BY town_name ASC;
  END;
