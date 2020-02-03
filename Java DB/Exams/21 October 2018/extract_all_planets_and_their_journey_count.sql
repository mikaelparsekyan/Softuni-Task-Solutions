SELECT p.name AS planet_name,COUNT(j.id) AS journeys_count FROM planets AS p
JOIN spaceports AS sp ON sp.planet_id = p.id
JOIN journeys AS j ON j.destination_spaceport_id = sp.id
GROUP BY p.name
ORDER BY journeys_count DESC, p.name ASC