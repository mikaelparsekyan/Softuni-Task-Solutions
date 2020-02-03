SELECT tc.job_during_journey AS job_name 
FROM journeys AS j
JOIN travel_cards AS tc ON tc.journey_id = j.id
ORDER BY j.journey_end - j.journey_start DESC
LIMIT 1