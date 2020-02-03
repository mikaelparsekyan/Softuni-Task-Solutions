SELECT COUNT(c.id) AS count FROM colonists AS c
JOIN travel_cards AS tc ON tc.colonist_id = c.id
JOIN journeys AS j ON j.id = tc.journey_id
WHERE j.purpose = 'Technical'