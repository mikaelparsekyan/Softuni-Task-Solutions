DELIMITER //
CREATE FUNCTION udf_count_colonists_by_destination_planet (planet_name VARCHAR (30))
	RETURNS INT
	BEGIN
		DECLARE res INT;
		SET res = (SELECT COUNT(c.id) FROM planets AS p
			JOIN spaceports AS sp ON sp.planet_id = p.id
			JOIN journeys AS j ON j.destination_spaceport_id = sp.id
			JOIN travel_cards AS tc ON tc.journey_id = j.id
			JOIN colonists AS c ON c.id = tc.colonist_id
			WHERE p.name = planet_name
        );
        RETURN res;
    END;