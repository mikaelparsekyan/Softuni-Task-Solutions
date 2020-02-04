DELIMITER //
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(10,4))
	BEGIN
		IF money_amount > 0 
			THEN 
				UPDATE accounts
                SET balance = balance + money_amount
                WHERE id = account_id;
		END IF;
    END;