SELECT employee_id, job_title, `employees`.address_id, address_text
FROM `employees`,`addresses`
WHERE `employees`.address_id = `addresses`.address_id
ORDER BY address_id ASC
LIMIT 5