DELIMITER //
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
	RETURNS BIT
	DETERMINISTIC
	BEGIN
		RETURN IF(LOWER(word) REGEXP CONCAT('^[', LOWER(set_of_letters), ']+$'), TRUE, FALSE);
  END;