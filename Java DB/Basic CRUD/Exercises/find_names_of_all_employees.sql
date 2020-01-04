ALTER TABLE `employees`
ADD `Full Name` VARCHAR(255);
UPDATE `employees` 
SET `Full Name` = CONCAT(first_name, " ", middle_name, " ", last_name)
WHERE salary = 25000 OR salary = 14000 OR salary = 12500 OR salary = 23600;
SELECT `Full Name` FROM `employees`
WHERE `Full Name` != "";