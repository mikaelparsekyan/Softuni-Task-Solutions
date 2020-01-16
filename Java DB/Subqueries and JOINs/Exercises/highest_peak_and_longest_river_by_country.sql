SELECT country_name, MAX(p.elevation) AS highest_peak_elevation, 
r.length AS longest_river_length
FROM `countries` as c
LEFT JOIN `mountains_countries` AS mc ON c.country_code = mc.country_code
LEFT JOIN `peaks` AS p ON p.mountain_id = mc.mountain_id
LEFT JOIN `countries_rivers` AS cr ON c.country_code = cr.country_code
LEFT JOIN `rivers` AS r ON r.id = cr.river_id
GROUP BY country_name
ORDER BY highest_peak_elevation DESC, country_name ASC
LIMIT 5;