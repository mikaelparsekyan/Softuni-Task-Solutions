SELECT name, DATE_FORMAT(start, '%Y-%m-%d') FROM `games`
WHERE start BETWEEN '2011-01-01' AND '2013-01-01'
ORDER BY start, name
LIMIT 50;