DELIMITER //
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(num DECIMAL(19, 4))
	BEGIN
		SELECT first_name, last_name FROM account_holders AS ah
        JOIN (
			SELECT id, account_holder_id, SUM(balance) AS 'total_balance' FROM accounts
            GROUP BY account_holder_id
            HAVING total_balance > num
            ORDER BY id
        ) AS a ON a.account_holder_id = ah.id
        ORDER BY a.id ASC;
    END;