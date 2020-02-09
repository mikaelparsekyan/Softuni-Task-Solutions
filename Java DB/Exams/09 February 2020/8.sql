SELECT MAX(sd.speed ) AS max_speed, t.name AS town_name
FROM towns AS t
LEFT JOIN stadiums AS s ON s.town_id = t.id
LEFT JOIN teams AS te ON te.stadium_id = s.id
LEFT JOIN players AS p ON p.team_id = te.id
LEFT JOIN skills_data AS sd ON p.skills_data_id = sd.id
WHERE te.name <> 'Devify'
GROUP BY town_name
ORDER BY max_speed DESC, town_name ASC
