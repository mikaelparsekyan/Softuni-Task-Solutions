SELECT continent_code, currency_code, COUNT(currency_code) AS currency_usage
FROM `countries` AS c
GROUP BY currency_code, continent_code
HAVING currency_usage = (
	SELECT COUNT(currency_code)  FROM `countries`
    WHERE 
    LIMIT 1
)
ORDER BY continent_code ASC, currency_code ASC

