CREATE VIEW `v_employees_hired_after_2000`
	AS SELECT first_name, last_name FROM `employees`
	WHERE hire_date >= '2001-01-01 00:00:00';

SELECT * FROM v_employees_hired_after_2000;