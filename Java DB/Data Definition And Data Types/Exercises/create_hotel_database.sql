CREATE TABLE `employees` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    title VARCHAR(255),
    notes TEXT
);
CREATE TABLE `customers` (
    account_number INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255),
    emergency_name VARCHAR(255),
	emergency_number VARCHAR(255),
    notes TEXT
);
CREATE TABLE `room_status` (
	room_status INT PRIMARY KEY AUTO_INCREMENT,
    notes TEXT
);
CREATE TABLE `room_types` (
	room_type INT PRIMARY KEY AUTO_INCREMENT,
    notes TEXT
);
CREATE TABLE `bed_types` (
	bed_type INT PRIMARY KEY AUTO_INCREMENT,
    notes TEXT
);
CREATE TABLE `rooms` (
	room_number INT PRIMARY KEY AUTO_INCREMENT,
    room_type INT REFERENCES room_types(room_type) ,
    bed_type INT REFERENCES bed_types(bed_type),
    rate INT,
    room_status INT REFERENCES room_status(room_status),
    notes TEXT
);
CREATE TABLE `payments` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	employee_id INT REFERENCES employees(id),
    payment_date DATE,
    account_number INT,
    first_date_occupied DATE,
    last_date_occupied DATE,
    total_days INT,
    amount_charged DECIMAL(10,2),
    tax_rate INT,
    tax_amount DECIMAL(10,2),
    payment_total DECIMAL(10,2),
    notes TEXT
);
CREATE TABLE `occupancies` (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	employee_id INT REFERENCES employees(id),
    date_occupied DATE,
    account_number VARCHAR(255),
    room_number INT REFERENCES rooms(room_number),
    rate_applied INT,
    phone_charge DECIMAL(10,2),
    notes TEXT
);
INSERT INTO `employees` VALUES
	(NULL,'first_name','last_name','title','note'),
    (NULL,'first_name','last_name','title','note'),
    (NULL,'first_name','last_name','title','note');

INSERT INTO `customers` VALUES
	(1,'first_name','last_name','090909','name','1212','note'),
    (2,'first_name','last_name','090909','name','1212','note'),
    (3,'first_name','last_name','090909','name','1212','note');

INSERT INTO `room_status` VALUES
	(1,'note'),
    (2,'note'),
    (3,'note');

INSERT INTO `room_types` VALUES
	(1,'note'),
    (2,'note'),
    (3,'note');

INSERT INTO `bed_types` VALUES
	(1,'note'),
    (2,'note'),
    (3,'note');

INSERT INTO `rooms` VALUES
	(1,1,1,123.12,2,'note'),
    (2,1,1,123.12,2,'note'),
    (3,1,1,123.12,2,'note');

INSERT INTO `occupancies` VALUES
	(NULL,1,'2008-09-08',123,1,3,4,'note'),
    (NULL,1,'2008-09-08',123,1,3,4,'note'),
    (NULL,1,'2008-09-08',123,1,3,4,'note');

INSERT INTO `payments` VALUES
	(NULL,1,'2008-09-08',1,'2008-09-08','2009-09-08',1,1,1,1,1,'note'),
    (NULL,2,'2008-09-08',1,'2008-09-08','2009-09-08',1,1,1,1,1,'note'),
    (NULL,3,'2008-09-08',1,'2008-09-08','2009-09-08',1,1,1,1,1,'note');

    
    