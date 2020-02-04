DELIMITER \\
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
	BEGIN
		START TRANSACTION;
		IF amount > 0
			THEN
				UPDATE accounts
                SET balance = balance - amount
                WHERE account_holder_id = from_account_id AND balance >= amount;
                
                UPDATE accounts
                SET balance = balance + amount
                WHERE account_holder_id = to_account_id;
		END IF;
        COMMIT;
    END;