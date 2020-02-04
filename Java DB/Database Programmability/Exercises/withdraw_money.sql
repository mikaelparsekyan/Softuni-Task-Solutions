DELIMITER //
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
	BEGIN
		IF money_amount > 0
			THEN 
				UPDATE accounts
                SET balance = balance - money_amount
                WHERE id = account_id AND balance >= money_amount;
		END IF;
    END;