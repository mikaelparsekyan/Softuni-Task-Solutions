SELECT p.name AS planet_name, s.name AS spaceport_name FROM planets AS p
JOIN spaceports AS s ON s.planet_id = p.id
JOIN journeys AS j ON j.destination_spaceport_id = s.id
WHERE j.purpose = 'Educational'
ORDER BY s.name DESC