SELECT mc.country_code, m.mountain_range, p.peak_name, p.elevation
FROM `mountains` as m
JOIN `mountains_countries` as mc
ON m.id = mc.mountain_id
JOIN `peaks` as p
ON mc.mountain_id = p.mountain_id
WHERE p.elevation > 2835 AND mc.country_code = 'BG'
ORDER BY p.elevation DESC