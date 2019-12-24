CREATE TABLE `users`(
	id INTEGER PRIMARY KEY AUTO_INCREMENT UNIQUE,
   username VARCHAR(30) NOT NULL,
   password VARCHAR(26) NOT NULL,
   profile_picture BLOB,
   last_login_time DATETIME,
	is_deleted BOOLEAN
);
INSERT INTO `users` VALUES(1,"John","1234",NULL,NULL,FALSE),
	(2,"Mike","1234",NULL,NULL,FALSE),
	(3,"Chris","1234",NULL,NULL,FALSE),
	(4,"Ken","1234",NULL,NULL,FALSE),
	(5,"Ben","1234",NULL,NULL,FALSE);

 