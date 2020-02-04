DELIMITER \\
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
	BEGIN
		START TRANSACTION;
			IF amount > 0 AND from_account_id IN(SELECT id FROM accounts) 
			AND to_account_id IN(SELECT id FROM accounts) AND amount <= (SELECT balance FROM accounts WHERE id = from_account_id LIMIT 1)
				THEN
					UPDATE accounts AS a
					SET balance = balance - amount
					WHERE id = from_account_id;
					
					UPDATE accounts
					SET balance = balance + amount
					WHERE id = to_account_id;
			END IF;
        COMMIT;
    END;