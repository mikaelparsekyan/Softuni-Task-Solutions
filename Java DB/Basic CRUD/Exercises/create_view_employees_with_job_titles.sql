ALTER TABLE `employees`
ADD full_name VARCHAR(255);
UPDATE `employees`
SET full_name = CONCAT(first_name, " ", IFNULL(middle_name, ""), " ", last_name);

CREATE VIEW v_employees_job_titles
AS SELECT full_name, job_title
FROM `employees`;
SHOW CREATE VIEW v_employees_job_titles;
