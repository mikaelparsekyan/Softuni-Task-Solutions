SELECT t.name AS team_name, t.established, t.fan_base, COUNT(p.id) AS count_of_players
FROM teams as t
LEFT JOIN players AS p ON p.team_id = t.id
GROUP BY team_name
ORDER BY count_of_players DESC, t.fan_base DESC
