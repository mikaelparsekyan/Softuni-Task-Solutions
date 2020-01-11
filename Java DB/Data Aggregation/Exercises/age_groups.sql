CREATE FUNCTION get_range(count INT)
	RETURNS VARCHAR(255)
	BEGIN
		IF count >=0 AND count <= 10 THEN
			RETURN '[0-10]';
        ELSEIF count <= 20 THEN
			RETURN '[11-20]';
        ELSEIF count <= 30 THEN
			RETURN '[21-30]';
		ELSEIF count <= 40 THEN
			RETURN '[31-40]';
		ELSEIF count <= 50 THEN
			RETURN '[41-50]';
		ELSEIF count <= 60 THEN
			RETURN '[51-60]';
		ELSE
			RETURN '[61+]';
		END IF;
    END;
SELECT get_range(age) AS 'age_group', COUNT(*) AS 'wizzard_count'
FROM `wizzard_deposits`
GROUP BY age_group
ORDER BY wizzard_count ASC;