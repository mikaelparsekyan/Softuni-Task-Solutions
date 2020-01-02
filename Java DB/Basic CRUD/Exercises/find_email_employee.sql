ALTER TABLE `employees`
ADD full_email_address VARCHAR(255);
UPDATE `employees`
SET full_email_address = CONCAT(`first_name`,".",`last_name`,"@softuni.bg");
SELECT full_email_address FROM `employees`;