DELIMITER //
CREATE FUNCTION ufn_calculate_future_value(sum INT, yearly DECIMAL, years INT)
	RETURNS DECIMAL(6, 2)
	BEGIN
		RETURN POW(sum * (1 + yearly), years);
    END;