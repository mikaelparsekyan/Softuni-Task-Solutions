UPDATE comments SET comment = (
	CASE
		WHEN id % 2 = 0
			THEN 'Very good article.' 
		WHEN id % 3 = 0
			THEN 'This is interesting.'
		WHEN id % 5 = 0
			THEN 'I definitely will read the article again.'
		WHEN id % 7 = 0
			THEN 'The universe is such an amazing thing.'
		ELSE
			comment
	END
)
WHERE id BETWEEN 1 AND 15