DELIMITER \\
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30))
	RETURNS INT
    BEGIN
		DECLARE res INT;
		SET res := (SELECT COUNT(p.id) FROM players AS p
        JOIN teams AS t ON p.team_id = t.id
        JOIN stadiums AS s ON s.id = t.stadium_id
        WHERE s.name = stadium_name LIMIT 1);
        RETURN res;
    END;