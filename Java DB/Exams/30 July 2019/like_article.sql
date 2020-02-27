DELIMITER //
CREATE PROCEDURE udp_like_article(username VARCHAR(30), title VARCHAR(30))
	BEGIN
		START TRANSACTION;
        
			IF username NOT IN(SELECT * FROM users)
				THEN
					SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent user';
                    ROLLBACK;
            ELSEIF title NOT IN(SELECT title FROM articles)
				THEN
					SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent article';
                    ROLLBACK;
			ELSE 
				INSERT INTO likes (article_id, comment_id, user_id)
                SELECT * FROM
                (SELECT id FROM articles AS a WHERE a.title = title) AS article_id,
                (SELECT comment FROM comments AS c WHERE c.articl = title) AS comment_id,
                (SELECT id FROM users AS u WHERE u.username = username) AS user_id;
			END IF;
        COMMIT;
    END;