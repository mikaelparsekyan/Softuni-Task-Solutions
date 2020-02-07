SELECT q.title, q.summary FROM (
	SELECT id, title, CONCAT(LEFT(content, 20), '...') AS summary FROM articles
	ORDER BY CHAR_LENGTH(content) DESC
	LIMIT 3
) AS q ORDER BY q.id