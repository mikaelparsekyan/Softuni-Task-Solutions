SELECT employee_id, first_name, last_name, name AS department_name
FROM `employees`,`departments`
WHERE name = 'Sales' AND 
	`employees`.department_id = `departments`.department_id
ORDER BY employee_id DESC