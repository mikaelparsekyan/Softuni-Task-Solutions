CREATE TABLE `people`(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	picture LONGBLOB,
	height DECIMAL(10,2),
	weight DECIMAL(10,2),
	gender CHAR(1) NOT NULL,
	birthdate TEXT NOT NULL,
	biography TEXT
);
INSERT INTO `people` VALUES(NULL,"Kiro",NULL,15.43,15.43,"m","asd","piqnica"),
	(NULL,"Steven",NULL,15.43,15.43,"m","asd","piqnica"),
	(NULL,"Tom",NULL,15.43,15.43,"m","asd","piqnica"),
	(NULL,"Ben",NULL,15.43,15.43,"m","asd","piqnica"),
	(NULL,"Mitio",NULL,15.43,15.43,"m","asd","piqnica");