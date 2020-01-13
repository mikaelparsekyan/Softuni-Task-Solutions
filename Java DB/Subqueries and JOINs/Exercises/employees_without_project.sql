SELECT `employees`.employee_id, first_name
FROM `employees`
LEFT JOIN `employees_projects` p
	ON p.employee_id = employees.employee_id
WHERE p.project_id IS NULL
ORDER BY `employees`.employee_id DESC
LIMIT 3;