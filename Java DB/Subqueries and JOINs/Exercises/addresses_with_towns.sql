SELECT first_name, last_name, name, address_text
FROM `employees`,`addresses`,`towns`
WHERE `employees`.address_id = `addresses`.address_id
	AND `towns`.town_id = `addresses`.town_id
ORDER BY first_name ASC, last_name ASC
LIMIT 5;