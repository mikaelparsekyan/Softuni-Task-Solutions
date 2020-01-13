SELECT employee_id, first_name, salary, name AS department_name
FROM `employees`,`departments`
WHERE salary > 15000
	AND `employees`.department_id = `departments`.department_id
ORDER BY `departments`.department_id DESC
LIMIT 5;