use `coderovers`;

INSERT INTO `Roles` (`userRoleId`, `type`) VALUES ('1', 'ADMIN');
INSERT INTO `Roles` (`userRoleId`, `type`) VALUES ('2', 'CREATOR');
INSERT INTO `Roles` (`userRoleId`, `type`) VALUES ('3', 'TAKER');


LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES (1,'fairfield','IA','1000 n 4th st','52557'),(2,'fairfield','IA','1000 n 4th st','52557');
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (3,'anonymousUser','admin@gmail.com',1,'Admin','Bhat','Bahadur','$2a$12$SLFPvDvfqmD.F/L8GxlQeO8hEetstdsGZuNNLd/gFZMcylUL82SVe','admin',1), (1,'anonymousUser','krishna1bhat@gmail.com',1,'Krishna','Bhat','Bahadur','$2a$12$Vt6pk/9iXcRD8ZkwJN.nieyh/UoFujbVp0xp9fx7E3O/qcUx1uRyO','krishna',1),(2,'krishna','manish@manish.com',1,'Manish','Karki','','$2a$12$mDg9ZLkamYgPDYDbVIHUVuSOTWvzpC7cHpubpKY.Gu4NEjowH2u5W','manish',2);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `User_Roles` WRITE;
/*!40000 ALTER TABLE `User_Roles` DISABLE KEYS */;
INSERT INTO `User_Roles` VALUES (3,1),(1,2),(2,3);
/*!40000 ALTER TABLE `User_Roles` ENABLE KEYS */;
UNLOCK TABLES;




LOCK TABLES `Question` WRITE;
/*!40000 ALTER TABLE `Question` DISABLE KEYS */;
INSERT INTO `Question` VALUES ('YesNo',1,'Are you a major/minor in this class?',NULL,NULL,NULL,NULL),('Text_Question',2,'Please leave some comment.',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `Question` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `QuestionOption` WRITE;
/*!40000 ALTER TABLE `QuestionOption` DISABLE KEYS */;
/*!40000 ALTER TABLE `QuestionOption` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Question_QuestionOption` WRITE;
/*!40000 ALTER TABLE `Question_QuestionOption` DISABLE KEYS */;
/*!40000 ALTER TABLE `Question_QuestionOption` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Response` WRITE;
/*!40000 ALTER TABLE `Response` DISABLE KEYS */;
/*!40000 ALTER TABLE `Response` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `Survey` WRITE;
/*!40000 ALTER TABLE `Survey` DISABLE KEYS */;
INSERT INTO `Survey` VALUES (1,NULL,'WAA final exam review','Exam review',1,1);
/*!40000 ALTER TABLE `Survey` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `Survey_Question` WRITE;
/*!40000 ALTER TABLE `Survey_Question` DISABLE KEYS */;
INSERT INTO `Survey_Question` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `Survey_Question` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `response_choice` WRITE;
/*!40000 ALTER TABLE `response_choice` DISABLE KEYS */;
/*!40000 ALTER TABLE `response_choice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


