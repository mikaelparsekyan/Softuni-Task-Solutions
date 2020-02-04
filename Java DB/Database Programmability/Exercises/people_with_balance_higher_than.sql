DELIMITER //
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(num DECIMAL(19, 4))
	BEGIN
		SELECT first_name, last_name FROM account_holders AS ah
        JOIN accounts AS a ON a.account_holder_id = ah.id
        WHERE a.balance > num
        ORDER BY ah.id ASC;
    END;