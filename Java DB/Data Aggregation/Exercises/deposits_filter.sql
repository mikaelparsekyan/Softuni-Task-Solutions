SELECT * FROM (
	SELECT deposit_group, SUM(deposit_amount) AS 'total_sum'
	FROM `wizzard_deposits`
    WHERE magic_wand_creator = "Ollivander family"
    GROUP BY deposit_group
	ORDER BY total_sum DESC
) AS innerTable
	WHERE total_sum < 150000