DELIMITER //
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
	BEGIN 
		SELECT CONCAT(p.first_name, ' ', last_name) AS full_name, p.age,
        p.salary, sd.dribbling, sd.speed, t.name AS team_name
        FROM players AS p
        LEFT JOIN skills_data AS sd ON p.skills_data_id = sd.id
        LEFT JOIN teams AS t ON t.id = p.team_id
        WHERE sd.dribbling >= min_dribble_points AND t.name = team_name
        ORDER BY sd.speed DESC
        LIMIT 1;
    END;