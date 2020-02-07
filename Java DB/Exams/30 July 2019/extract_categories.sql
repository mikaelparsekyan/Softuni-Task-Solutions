SELECT c.category, COUNT(DISTINCT a.id) AS articles, COUNT(l.id) AS likes
FROM categories AS c
LEFT JOIN articles AS a ON a.category_id = c.id
LEFT JOIN likes AS l ON l.article_id = a.id
GROUP BY c.category
ORDER BY likes DESC, articles DESC, c.id ASC