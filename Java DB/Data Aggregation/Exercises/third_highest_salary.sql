SELECT department_id, (
	SELECT DISTINCT salary FROM `employees`
    WHERE department_id = e.department_id 
	ORDER BY salary DESC LIMIT 2, 1
) AS third_highest_salary
FROM `employees` as e
GROUP BY department_id
HAVING third_highest_salary IS NOT NULL
ORDER BY department_id ASC, third_highest_salary;