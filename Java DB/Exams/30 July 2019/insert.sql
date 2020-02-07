INSERT INTO likes(article_id, comment_id, user_id)
SELECT (
	CASE WHEN id % 2 = 0 
		THEN LENGTH(username)
	END
) AS article_id,
(
	CASE WHEN id % 2 <> 0 
		THEN LENGTH(email)
	END
) AS comment_id,
id AS user_id
FROM users
WHERE id BETWEEN 16 AND 20