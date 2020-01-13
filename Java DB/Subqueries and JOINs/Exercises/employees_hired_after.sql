SELECT first_name, last_name, hire_date, name AS dept_name
FROM `employees` AS e
JOIN `departments` AS dept_name
ON dept_name.department_id = e.department_id
WHERE DATE (hire_date) > '1999-01-01' 
	AND (name = 'Sales' OR name = 'Finance')
ORDER BY hire_date ASC;