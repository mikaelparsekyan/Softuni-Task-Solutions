SELECT
  c.id,
  CONCAT(c.card_number, ' : ', cl.full_name)
FROM `cards` AS c
  JOIN bank_accounts AS b ON b.id = c.bank_account_id
  JOIN clients AS cl ON b.client_id = cl.id
ORDER BY c.id DESC