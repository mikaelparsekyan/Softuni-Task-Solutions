SELECT name, manufacturer FROM spaceships AS s
JOIN journeys AS j ON j.spaceship_id = s.id
JOIN travel_cards AS tc ON tc.journey_id = j.id
JOIN colonists AS c ON c.id = tc.colonist_id
WHERE c.birth_date BETWEEN (DATE_SUB('2019-01-01', INTERVAL 30 YEAR))
	AND '2019-01-01'
 AND tc.job_during_journey = 'Pilot'
GROUP BY name
ORDER BY name ASC