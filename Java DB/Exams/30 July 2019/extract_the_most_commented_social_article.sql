SELECT title, COUNT(c.id) AS comments FROM articles AS a
LEFT JOIN comments AS c ON c.article_id = a.id
WHERE a.category_id = 5
GROUP BY title
ORDER BY comments DESC
LIMIT 1