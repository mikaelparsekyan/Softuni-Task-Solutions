CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(255))
  BEGIN
    SELECT
      c.full_name,
      c.age,
      b.account_number,
      CONCAT('$', b.balance) AS 'balance'
    FROM clients AS c
      JOIN bank_accounts AS b ON b.client_id = c.id
    WHERE c.full_name = full_name;
  END;
CALL udp_clientinfo('Hunter W')