CREATE FUNCTION get_part_of_the_day(start_time INT) RETURNS VARCHAR(255)
	BEGIN
		IF (start_time >= 0 AND start_time < 12) THEN
			RETURN "Morning";
        ELSEIF (start_time >= 12 AND start_time < 18) THEN
			RETURN "Afternoon";
		ELSEIF (start_time >= 18 AND start_time < 24) THEN
			RETURN "Evening";
        END IF;
    END;
CREATE FUNCTION get_duration(duration_time INT) RETURNS VARCHAR(255)
	BEGIN
		IF (duration_time <> 0 AND duration_time <= 3) THEN
			RETURN "Extra Short";
        ELSEIF (duration_time > 3 AND duration_time <= 6) THEN
			RETURN "Short";
		ELSEIF (duration_time > 6 AND duration_time <= 10) THEN
			RETURN "Long";
		ELSE
			RETURN "Extra Long";
        END IF;
	END;
SELECT name, get_part_of_the_day(DATE_FORMAT(start,"%H")) AS 'Part of the Day' ,
	get_duration(duration) AS 'Duration'
FROM `games`;