SELECT COUNT(*) - (
	SELECT COUNT(DISTINCT country_code) FROM `mountains_countries` AS mc
) AS country_count
FROM `countries` AS c