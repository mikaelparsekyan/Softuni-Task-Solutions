CREATE TABLE `users`(
	id INTEGER PRIMARY KEY AUTO_INCREMENT UNIQUE,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time TIME,
	is_deleted BOOLEAN
);
INSERT INTO `users` VALUES(1,"John","1234",NULL,NULL,false);
INSERT INTO `users` VALUES(2,"Mike","1234",NULL,NULL,false);
INSERT INTO `users` VALUES(3,"Chris","1234",NULL,NULL,false);
INSERT INTO `users` VALUES(4,"Ken","1234",NULL,NULL,false);
INSERT INTO `users` VALUES(5,"Ben","1234",NULL,NULL,false);

 