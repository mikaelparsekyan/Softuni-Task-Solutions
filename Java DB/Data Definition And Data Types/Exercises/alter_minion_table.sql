ALTER TABLE `minions`
ADD COLUMN (town_id INT),
ADD CONSTRAINT town_id FOREIGN KEY (`town_id`) 
REFERENCES towns (id)

 