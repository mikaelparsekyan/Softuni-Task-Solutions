CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))
  RETURNS VARCHAR(255)
  BEGIN
    DECLARE res INT;
    SET res := (SELECT COUNT(c.id) as 'count'
                FROM clients AS cl
                  JOIN bank_accounts AS b ON b.client_id = cl.id
                  JOIN cards AS c ON c.bank_account_id = b.id
                WHERE full_name = name);
    RETURN res;
  END;