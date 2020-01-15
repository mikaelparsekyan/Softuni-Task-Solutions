SELECT mc.country_code, COUNT(m.mountain_range) AS mountain_range
FROM `mountains` as m
LEFT JOIN `mountains_countries` as mc
ON m.id = mc.mountain_id
WHERE mc.country_code = 'BG' OR mc.country_code = 'RU' 
	OR mc.country_code = 'US'
GROUP BY mc.country_code
ORDER BY mountain_range DESC