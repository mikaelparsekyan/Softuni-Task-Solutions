INSERT INTO cards(card_number, card_status, bank_account_id)
SELECT (
	REVERSE(full_name)
) AS card_number,
'Active' AS card_status,
id AS bank_account_id
FROM clients
WHERE id BETWEEN 191 AND 200