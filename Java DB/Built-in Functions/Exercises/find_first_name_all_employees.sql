SELECT first_name FROM `employees`
WHERE (department_id = 3 OR department_id = 10) AND
hire_date BETWEEN '1995-01-01 00:00:00' AND '2006-01-01 00:00:00'
ORDER BY employee_id;