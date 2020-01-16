SELECT country_name, river_name
FROM `countries` as c
LEFT JOIN `countries_rivers` AS cr ON cr.country_code = c.country_code
LEFT JOIN `rivers` AS r ON r.id = cr.river_id
WHERE continent_code = 'AF'
GROUP BY country_name
LIMIT 5;