CREATE TABLE `categories` (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    category VARCHAR(255) NOT NULL,
    daily_rate FLOAT(10,2),
    weekly_rate FLOAT(10,2),
    monthly_rate FLOAT(10,2),
    weekend_rate FLOAT(10,2)
);
CREATE TABLE `cars` (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    plate_number VARCHAR(45) ,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    car_year YEAR,
    category_id INT REFERENCES `categories`.id,
    doors INT,
    picture BLOB,
    car_condition VARCHAR(255),
    available BOOLEAN
);
CREATE TABLE `employees` (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    notes TEXT
);
CREATE TABLE `customers` (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    driver_licence_number VARCHAR(45),
    full_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    zip_code VARCHAR(255) NOT NULL,
    notes TEXT
);
CREATE TABLE `rental_orders` (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    employee_id INT REFERENCES `employees`.id,
    customer_id INT REFERENCES `customers`.id,
    car_id INT REFERENCES `cars`.id,
    car_condition VARCHAR(255) REFERENCES `cars`.condition,
    tank_level VARCHAR(255),
    kilometrage_start VARCHAR(255),
    kilometrage_end VARCHAR(255),
    total_kilometrage VARCHAR(255),
    start_date DATE,
    end_date DATE,
    total_days INT,
    rate_applied FLOAT(10,2),
    tax_rate FLOAT(10,2),
    order_status VARCHAR(255),
    notes TEXT
);
INSERT INTO `categories` VALUES(
	1,'cat1',100,100,100,100),
    (2,'cat2',100,100,100,100),
    (3,'cat3',100,100,100,100);
    
INSERT INTO `cars` VALUES
	(1,'0231','subaru','impreza','2012',1,4,NULL,'new',true),
    (2,'0231','subaru','impreza','2018',1,4,NULL,'new',true),
    (3,'0231','subaru','impreza','2000',2,4,NULL,'new',true);
    
INSERT INTO `employees` VALUES
	(1,'ivan','ivanov','title1','note'),
    (2,'ivan','ivanov','title1','note'),
    (3,'ivan','ivanov','title1','note');
    
INSERT INTO `customers` VALUES
	(1,'656465','ivan ivanov','addr1','sofia','2222','note'),
    (2,'656465','ivan ivanov','addr2','plovdiv','2222','note'),
    (3,'656465','ivan ivanov','addr3','varna','2222','note');

INSERT INTO `rental_orders` VALUES
	(1,2,1,2,'new','full','12','12','12','2008-7-04','2009-7-04',123,123.6,123.4,'ok','notes'),
	(2,2,1,2,'new','full','12','12','12','2008-7-04','2009-7-04',123,123.6,123.4,'ok','notes'),
    (3,2,1,2,'new','full','12','12','12','2008-7-04','2009-7-04',123,123.6,123.4,'ok','notes');
    
    