DELIMITER //
CREATE FUNCTION udf_users_articles_count(username VARCHAR(30))
	RETURNS INT
	BEGIN
		DECLARE RES INT;
        SET RES := (
			SELECT COUNT(ua.article_id) AS 'count' FROM users AS u
			LEFT JOIN users_articles AS ua ON ua.user_id = u.id
			WHERE u.username = username
        );
        RETURN RES;
    END;