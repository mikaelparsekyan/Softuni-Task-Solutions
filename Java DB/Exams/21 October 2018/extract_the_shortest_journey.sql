SELECT j.id, p.name AS planet_name, 
sp.name AS  spaceport_name, purpose AS journey_purpose 
FROM journeys AS j
JOIN spaceports AS sp ON sp.id = j.destination_spaceport_id
JOIN planets AS p ON p.id = sp.planet_id
ORDER BY j.journey_end - j.journey_start
LIMIT 1