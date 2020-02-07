SELECT a.id AS article_id, a.title FROM articles AS a
JOIN users_articles AS ua ON ua.article_id = a.id
WHERE ua.user_id = ua.article_id