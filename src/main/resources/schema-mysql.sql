-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: newexult
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `idAdmin` int NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAdmin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Admin','9515050278','singampalliakhil@gmail.com','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `idappointment` int NOT NULL AUTO_INCREMENT,
  `aptDate` varchar(45) NOT NULL,
  `aptTime` varchar(45) NOT NULL,
  `aptStatus` varchar(45) NOT NULL,
  `patientId` int NOT NULL DEFAULT '0',
  `doctorId` int NOT NULL DEFAULT '0',
  `adminId` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`idappointment`)
) ENGINE=InnoDB AUTO_INCREMENT=311 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (17,'2022-02-24','20:31','Confirm',151,4,1),(20,'','','Confirm',116,4,1),(21,'','','Pending',116,4,1),(22,'','','Pending',116,4,1),(23,'','','Pending',116,4,1),(24,'','','Pending',116,3,1),(25,'','','Confirm',116,5,1),(26,'','','Pending',116,4,1),(27,'','','Pending',116,4,1),(28,'','','Pending',116,4,1),(29,'','','Pending',116,4,1),(30,'','','Pending',116,4,1),(31,'','','Confirm',116,3,1),(32,'','','Confirm',116,3,1),(33,'','','Confirm',116,5,1),(34,'','','Pending',116,5,1),(35,'','','Pending',116,4,1),(36,'','','Pending',116,4,1),(37,'','','Pending',116,5,1),(38,'','','Pending',116,5,1),(39,'','','Pending',116,5,1),(40,'','','Pending',116,4,1),(41,'','','Pending',116,4,1),(42,'','','Pending',116,4,1),(43,'','','Pending',116,4,1),(44,'','','Pending',116,4,1),(45,'','','Pending',116,4,1),(46,'','','Pending',116,4,1),(47,'','','Pending',116,4,1),(48,'','','Pending',116,4,1),(49,'','','Pending',116,4,1),(50,'','','Pending',116,5,1),(51,'','','Pending',116,5,1),(52,'','','Pending',116,4,1),(53,'','','Pending',116,4,1),(54,'','','Pending',116,5,1),(55,'','','Pending',116,4,1),(56,'','','Pending',116,4,1),(57,'','','Pending',116,4,1),(58,'','','Pending',116,4,1),(59,'','','Pending',116,4,1),(60,'','','Pending',116,4,1),(61,'','','Pending',116,4,1),(62,'','','Pending',116,4,1),(63,'','','Pending',116,4,1),(64,'','','Pending',116,5,1),(65,'','','Pending',116,5,1),(66,'','','Pending',116,5,1),(67,'','','Pending',116,5,1),(68,'','','Pending',116,5,1),(69,'','','Pending',116,5,1),(70,'','','Pending',116,5,1),(71,'','','Pending',116,5,1),(72,'','','Pending',116,5,1),(73,'','','Pending',116,5,1),(74,'','','Pending',116,5,1),(75,'','','Pending',116,5,1),(76,'','','Pending',116,5,1),(77,'','','Pending',116,5,1),(78,'','','Pending',116,4,1),(79,'','','Pending',116,5,1),(80,'','','Pending',116,5,1),(81,'','','Pending',116,5,1),(82,'','','Pending',116,5,1),(83,'','','Pending',116,5,1),(84,'','','Pending',116,4,1),(85,'','','Pending',116,4,1),(86,'','','Pending',116,4,1),(87,'','','Pending',116,5,1),(88,'','','Pending',116,5,1),(89,'','','Pending',116,5,1),(90,'','','Pending',116,5,1),(91,'','','Pending',116,5,1),(92,'','','Pending',116,5,1),(93,'','','Pending',116,5,1),(94,'','','Pending',116,5,1),(95,'','','Pending',116,5,1),(96,'','','Pending',116,5,1),(97,'','','Pending',116,5,1),(98,'','','Pending',116,5,1),(99,'','','Pending',116,5,1),(107,'','','Pending',151,4,1),(108,'','','Pending',151,4,1),(109,'','','Pending',151,4,1),(110,'','','Pending',151,4,1),(111,'','','Pending',151,4,1),(112,'','','Pending',151,4,1),(113,'','','Pending',151,4,1),(114,'','','Pending',151,4,1),(115,'','','Pending',151,4,1),(116,'','','Pending',151,4,1),(117,'','','Pending',151,4,1),(118,'','','Pending',151,4,1),(119,'','','Pending',151,4,1),(120,'','','Pending',151,4,1),(121,'','','Pending',151,4,1),(122,'','','Pending',151,4,1),(123,'','','Pending',151,4,1),(124,'','','Pending',151,4,1),(125,'','','Pending',151,4,1),(126,'','','Pending',151,4,1),(127,'','','Pending',151,4,1),(128,'','','Pending',151,4,1),(129,'','','Pending',151,4,1),(130,'','','Pending',151,4,1),(131,'','','Pending',151,4,1),(132,'','','Pending',151,4,1),(133,'','','Pending',151,4,1),(134,'','','Pending',151,4,1),(135,'','','Pending',151,4,1),(136,'','','Pending',151,4,1),(137,'','','Pending',151,4,1),(138,'','','Pending',151,4,1),(139,'','','Pending',151,4,1),(140,'','','Pending',151,4,1),(141,'','','Pending',151,4,1),(142,'','','Pending',151,4,1),(143,'','','Pending',151,4,1),(144,'','','Pending',151,4,1),(145,'','','Pending',151,4,1),(146,'','','Pending',151,4,1),(147,'','','Pending',151,4,1),(148,'','','Pending',151,4,1),(149,'','','Pending',151,4,1),(150,'','','Pending',151,4,1),(151,'','','Pending',151,4,1),(152,'','','Pending',151,4,1),(153,'','','Pending',151,4,1),(154,'','','Pending',151,4,1),(155,'','','Pending',151,4,1),(156,'','','Pending',151,4,1),(157,'','','Pending',151,4,1),(158,'','','Pending',151,4,1),(159,'','','Pending',151,4,1),(160,'','','Pending',151,4,1),(161,'','','Pending',151,4,1),(162,'','','Pending',151,4,1),(163,'','','Pending',151,4,1),(164,'','','Pending',151,4,1),(165,'','','Pending',151,4,1),(166,'','','Pending',151,4,1),(167,'','','Pending',151,4,1),(168,'','','Pending',151,4,1),(169,'','','Pending',151,4,1),(170,'','','Pending',151,4,1),(171,'','','Pending',151,4,1),(172,'','','Pending',151,4,1),(173,'','','Pending',151,4,1),(174,'','','Pending',151,4,1),(175,'','','Pending',151,4,1),(176,'','','Pending',151,4,1),(177,'','','Pending',151,4,1),(178,'','','Pending',151,4,1),(179,'','','Pending',151,4,1),(180,'','','Pending',151,4,1),(181,'','','Pending',151,4,1),(182,'','','Pending',151,4,1),(183,'','','Pending',151,4,1),(184,'','','Pending',151,4,1),(185,'','','Pending',151,4,1),(186,'','','Pending',151,4,1),(187,'','','Pending',151,4,1),(188,'','','Pending',151,4,1),(189,'','','Pending',151,4,1),(190,'','','Pending',151,4,1),(191,'','','Pending',151,4,1),(192,'','','Pending',151,4,1),(193,'','','Pending',151,4,1),(194,'','','Pending',151,4,1),(195,'','','Pending',151,4,1),(196,'','','Pending',151,4,1),(197,'','','Pending',151,4,1),(198,'','','Pending',151,4,1),(199,'','','Pending',151,4,1),(200,'','','Pending',151,4,1),(201,'','','Pending',151,5,1),(202,'','','Pending',151,5,1),(203,'','','Pending',151,5,1),(204,'','','Pending',151,5,1),(205,'','','Pending',151,5,1),(206,'','','Pending',151,5,1),(207,'','','Pending',151,5,1),(216,'','','Pending',116,5,1),(217,'','','Pending',116,5,1),(218,'','','Pending',116,5,1),(219,'','','Pending',116,5,1),(220,'','','Pending',116,5,1),(221,'','','Pending',116,5,1),(222,'','','Pending',116,5,1),(223,'','','Pending',116,5,1),(224,'','','Pending',116,5,1),(225,'','','Pending',116,5,1),(226,'','','Pending',116,5,1),(279,'02-04-2022','09:15','Confirm',151,4,1),(280,'06-04-2022','10:00','Confirm',114,5,1),(281,'06-04-2022','10:00','Confirm',151,3,1),(282,'06-04-2022','11:30','Confirm',151,3,1),(283,'08-04-2022','11:30','Confirm',151,3,1),(284,'05-04-2022','14:30','Confirm',151,3,1),(285,'02-04-2022','13:45','Pending',154,4,1),(286,'02-04-2022','13:45','Pending',154,4,1),(287,'02-04-2022','13:45','Pending',154,4,1),(288,'02-04-2022','14:30','Pending',154,4,1),(289,'06-04-2022','09:30','Pending',151,4,1),(291,'04-04-2022','09:45','Confirm',114,3,1),(292,'04-04-2022','09:45','Confirm',114,3,1),(293,'04-04-2022','09:45','Confirm',114,3,1),(294,'04-04-2022','09:45','Pending',114,3,1),(295,'10-04-2022','13:00','Pending',114,3,1),(296,'20-04-2022','10:00','Pending',113,3,1),(297,'20-04-2022','10:00','Pending',113,3,1),(298,'20-04-2022','10:00','Pending',113,3,1),(299,'20-04-2022','10:00','Pending',113,3,1),(300,'03-05-2022','17:00','Confirm',156,4,1),(301,'2022-08-09','12:00 AM','Pending',113,3,1),(302,'2022-08-09','12:00 AM','Pending',116,5,1),(303,'2022-07-31','13:00 PM','Pending',1003,5,1),(304,'2022-07-31','13:00','Pending',1003,5,1),(305,'2022-07-31','13:00','Pending',1003,5,1),(306,'2022-07-31','13:00','Confirm',1002,5,1),(307,'2022-08-1','13:00','Pending',1002,3,1),(308,'09-08-2022','09:30','Pending',1004,3,1),(309,'08-09-2022','10:00','Pending',116,3,1),(310,'21-09-2022','10:00','Pending',113,4,1);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config` (
  `idconfig` int NOT NULL,
  `jsonconf` json NOT NULL,
  `sendermail` varchar(200) NOT NULL,
  `mailpassword` varchar(200) NOT NULL,
  PRIMARY KEY (`idconfig`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'{\"type\": \"service_account\", \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\", \"client_id\": \"113984354828438424164\", \"token_uri\": \"https://oauth2.googleapis.com/token\", \"project_id\": \"exultstore\", \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDGEH3bYJspZxxZ\\nLrttk69aBOva6TuSadiPDIqRNSkkgfg7Z5klnoyssHgyG/9p9u1pAMWjyfawFvVc\\n4DPlW3ZXtiBdi+DL7CF4IKyqcKAmA6ZvGtgsqPQJP3LRBMEjO0LObZYoEW5h6pQy\\nqqncNyOSEwpZONrLE5Sdf1atpkgbIUif34Rq7ecjT7RRGXchf/xdLV9y5UB1kPSt\\nPqZgzT1u2sbcXf9IYXf7uML/bTe1SViFC0KKc2s8W8Y2XL/Ht64Cx9ncGFjXaabV\\n9EjafBSAH6qCMuK3MTHAr1Z0yokIHCqYsFZ1WLE+yCN+7cyKVBefAeE5pZ/V/z1B\\ntEJ1gfwlAgMBAAECggEAFgWX5MgvQFF7XKweQU76IHVrHu4vRjZ4EmGn14DUZ/9+\\ncOZyJ/ViuUGuv42O3sKKf5ILJ4ypXcdTtSWlh4Mdm59/pj8K+clxqDhj0liO6eMe\\ngnx23DJV3eBc3QIdElSAt1CGcUKM5hytqRuCIt7LmO5+iFCSvSEadU+G/Ow/2Kou\\nr5fLF/Oo7gmEBW6a6o0DioL6XNHSQFjNgNtXEWusTV8jH3EWPc2XiY00dLZxJjGz\\nbr6GuFuHO4LNa4S/MZbGppzdyVftiiL7Sp6CS4v5Cxj1mjX9MOyppLTXzviWfLY5\\n7goVKA+ecEJauulnzEXG2j+KT+Gj5hqIZ6JcYndB+QKBgQD2rijgy8h4K4FU90La\\n5ad4kB52DmLBLLj0823nZ2zxcKRuQ4WnjzVCBviphr9lmlwakc5eAdSY5NAOEBLq\\nWNIIz2LGHGRVW0iDj59N6k+yNSwqp9No9cYZzoof5gRBii0AqeR6OwcVwgLedU2k\\nazfq1VBXYKOYVqMPwycgqWVWeQKBgQDNjCEVVg/tiugmEdJP2ctIyWUhdAghCU4e\\nbQNUjuG+HByqIuGTdfh1MGe92W/Tb3gQCwGbt6UdroXzh4UV6lpWZOwD0Vl/3A6t\\npfyOKq9+kCBh9VDxbYcS8bKp8ocGbNx6LKDwd7zkfNteRVHAcKHAj+Mbo/o6lrv0\\n7O+x5ftYDQKBgGcAX7dFwAZVfCJjQHowbJZN7zoyVY/9wZkeUCTQrc++zhnwfc1y\\nYbWZPZlj12VwZ8b8XOQp9YCGAk3s7kkGH2VoWwEH9+kgPY4ZmVYqYW6y/ycsfn0U\\nKsy5zjj1jY9kR9hAGFPlc9bk9Ne4uVvPHUEkIvDpPEYu3tWFEkB0GwlZAoGBAJRe\\nU/sctj6XB9+C+bZd1ZjilrdBFCUUnGjl84Nz54rcq+w7ZWyVuRSOLjQh4dBTI+0g\\npLaMJwl30oTpC624DiFSk/JliR777zR1HgpY0Xif/F/5PcYnc1q/UGHQCJsgtT0T\\nPdCV/alIXuh7TPmF05w1wI9RG+xypZWz+YkGIxl5AoGAON+svGAqzSgPvtu+9ujf\\nklfRHekFI6VetLSejjtWqpev/rt14oKqZtFc1C2CE8roy0tzGefCFAOz+oKWejl7\\nhMXfvHJ9gXrY6XlIdhnoNMgfEKwkrCItQ6X+6GhD1nPdn7D+nAgAdDIXzSzaYaUn\\npvzZuTmf3r64jmQu5HhPfN8=\\n-----END PRIVATE KEY-----\\n\", \"client_email\": \"bookappoint@exultstore.iam.gserviceaccount.com\", \"private_key_id\": \"cf97bf46a40cf3391e486d6ed4866a4c5fbb2ada\", \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/bookappoint%40exultstore.iam.gserviceaccount.com\", \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\"}','glowellsolutions@gmail.com','bicpnnkxqouoyotq');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datafield`
--

DROP TABLE IF EXISTS `datafield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datafield` (
  `idDataField` int NOT NULL AUTO_INCREMENT,
  `FieldName` varchar(45) DEFAULT NULL,
  `FieldType` varchar(45) DEFAULT NULL,
  `FieldValue` longtext,
  `patient_data_idPatient_Data` int NOT NULL,
  PRIMARY KEY (`idDataField`),
  KEY `fk_DataField_patient_data1_idx` (`patient_data_idPatient_Data`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_DataField_patient_data1` FOREIGN KEY (`patient_data_idPatient_Data`) REFERENCES `patient_data` (`idPatient_Data`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1357 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datafield`
--

LOCK TABLES `datafield` WRITE;
/*!40000 ALTER TABLE `datafield` DISABLE KEYS */;
INSERT INTO `datafield` VALUES (971,'Name','Type','Value',136),(972,'Name','Type','Value',137),(973,'Name','Type','Value',138),(974,'Name','Type','Akhil',139),(975,'Name','Type','Value',140),(976,'Name','Type','Value',141),(977,'Name','Type','Value',142),(978,'Name','Type','Value',143),(979,'Name','Type','Value',144),(980,'Name','Type','Value',145),(981,'Name','Type','Value',146),(982,'Name','Type','Value',147),(983,'Name','Type','Value',148),(984,'Name','Type','Value',149),(985,'Name','Type','Value',150),(986,'Name','Type','Value',151),(987,'Name','Type','Value',152),(988,'Name','Type','Value',153),(989,'Name','Type','Value',154),(990,'Name','Type','Value',155),(991,'Name','Type','Value',156),(992,'Name','Type','Value',157),(993,'Name','Type','Value',158),(994,'Name','Type','Value',159),(995,'Name','Type','Value',160),(996,'Name','Type','Value',161),(997,'Name','Type','Value',162),(998,'Name','Type','Value',163),(999,'Name','Type','Value',164),(1000,'Name','Type','Value',165),(1001,'Name','Type','Value',166),(1002,'Name','Type','Value',167),(1003,'Name','Type','Value',168),(1004,'Name','Type','Value',169),(1005,'Name','Type','Value',170),(1006,'Name','Type','Value',171),(1007,'Name','Type','Value',172),(1008,'Name','Type','Value',173),(1010,'Name','Type','Value',175),(1011,'Name','text','Akhil',136),(1012,'Age','number','24',136),(1013,'Gender','text','M',136),(1014,'Reason','text','Hair',136),(1015,'Name','text','Akhil',137),(1016,'Age','number','24',137),(1017,'Gender','text','M',137),(1018,'Reason','text','Hair',137),(1019,'Name','text','Akhil',138),(1020,'Age','number','24',138),(1021,'Gender','text','M',138),(1022,'Reason','text','Hair',138),(1023,'Name','text','Akhil',139),(1024,'Age','number','24',139),(1025,'Gender','text','M',139),(1026,'Reason','text','Hair',139),(1027,'Name','text','Akhil',140),(1028,'Age','number','24',140),(1029,'Gender','text','M',140),(1030,'Reason','text','Hair',140),(1031,'Name','text','Akhil',141),(1032,'Age','number','24',141),(1033,'Gender','text','M',141),(1034,'Reason','text','Hair',141),(1035,'Name','text','Akhil',142),(1036,'Age','number','24',142),(1037,'Gender','text','M',142),(1038,'Reason','text','Hair',142),(1039,'Name','text','Akhil',143),(1040,'Age','number','24',143),(1041,'Gender','text','M',143),(1042,'Reason','text','Hair',143),(1043,'Name','text','Akhil',144),(1044,'Age','number','24',144),(1045,'Gender','text','M',144),(1046,'Reason','text','Hair',144),(1047,'Name','text','Akhil',145),(1048,'Age','number','24',145),(1049,'Gender','text','M',145),(1050,'Reason','text','Hair',145),(1051,'Name','text','Akhil',146),(1052,'Age','number','24',146),(1053,'Gender','text','M',146),(1054,'Reason','text','Hair',146),(1055,'Name','text','Akhil',147),(1056,'Age','number','24',147),(1057,'Gender','text','M',147),(1058,'Reason','text','Hair',147),(1059,'Name','text','Akhil',148),(1060,'Age','number','24',148),(1061,'Gender','text','M',148),(1062,'Reason','text','Hair',148),(1063,'Name','text','Akhil',149),(1064,'Age','number','24',149),(1065,'Gender','text','M',149),(1066,'Reason','text','Hair',149),(1067,'Name','text','Akhil',150),(1068,'Age','number','24',150),(1069,'Gender','text','M',150),(1070,'Reason','text','Hair',150),(1071,'Name','text','Akhil',151),(1072,'Age','number','24',151),(1073,'Gender','text','M',151),(1074,'Reason','text','Hair',151),(1075,'Name','text','Akhil',152),(1076,'Age','number','24',152),(1077,'Gender','text','M',152),(1078,'Reason','text','Hair',152),(1079,'Name','text','Akhil',153),(1080,'Age','number','24',153),(1081,'Gender','text','M',153),(1082,'Reason','text','Hair',153),(1083,'Name','text','Akhil',154),(1084,'Age','number','24',154),(1085,'Gender','text','M',154),(1086,'Reason','text','Hair',154),(1087,'Name','text','Akhil',155),(1088,'Age','number','24',155),(1089,'Gender','text','M',155),(1090,'Reason','text','Hair',155),(1091,'Name','text','Akhil',156),(1092,'Age','number','24',156),(1093,'Gender','text','M',156),(1094,'Reason','text','Hair',156),(1095,'Name','text','Akhil',157),(1096,'Age','number','24',157),(1097,'Gender','text','M',157),(1098,'Reason','text','Hair',157),(1099,'Name','text','Akhil',158),(1100,'Age','number','24',158),(1101,'Gender','text','M',158),(1102,'Reason','text','Hair',158),(1103,'Name','text','Akhil',159),(1104,'Age','number','24',159),(1105,'Gender','text','M',159),(1106,'Reason','text','Hair',159),(1107,'Name','text','Akhil',160),(1108,'Age','number','24',160),(1109,'Gender','text','M',160),(1110,'Reason','text','Hair',160),(1111,'Name','text','Akhil',161),(1112,'Age','number','24',161),(1113,'Gender','text','M',161),(1114,'Reason','text','Hair',161),(1115,'Name','text','Akhil',162),(1116,'Age','number','24',162),(1117,'Gender','text','M',162),(1118,'Reason','text','Hair',162),(1119,'Name','text','Akhil',163),(1120,'Age','number','24',163),(1121,'Gender','text','M',163),(1122,'Reason','text','Hair',163),(1123,'Name','text','Akhil',164),(1124,'Age','number','24',164),(1125,'Gender','text','M',164),(1126,'Reason','text','Hair',164),(1127,'Name','text','Akhil',165),(1128,'Age','number','24',165),(1129,'Gender','text','M',165),(1130,'Reason','text','Hair',165),(1131,'Name','text','Akhil',166),(1132,'Age','number','24',166),(1133,'Gender','text','M',166),(1134,'Reason','text','Hair',166),(1135,'Name','text','Akhil',167),(1136,'Age','number','24',167),(1137,'Gender','text','M',167),(1138,'Reason','text','Hair',167),(1139,'Name','text','Akhil',168),(1140,'Age','number','24',168),(1141,'Gender','text','M',168),(1142,'Reason','text','Hair',168),(1143,'Name','text','Akhil',169),(1144,'Age','number','24',169),(1145,'Gender','text','M',169),(1146,'Reason','text','Hair',169),(1147,'Name','text','Akhil',170),(1148,'Age','number','24',170),(1149,'Gender','text','M',170),(1150,'Reason','text','Hair',170),(1151,'Name','text','Akhil',171),(1152,'Age','number','24',171),(1153,'Gender','text','M',171),(1154,'Reason','text','Hair',171),(1155,'Name','text','Akhil',172),(1156,'Age','number','24',172),(1157,'Gender','text','M',172),(1158,'Reason','text','Hair',172),(1159,'Name','text','Akhil',173),(1160,'Age','number','24',173),(1161,'Gender','text','M',173),(1162,'Reason','text','Hair',173),(1163,'Name','text','Akhil',175),(1164,'Age','number','24',175),(1165,'Gender','text','M',175),(1166,'Reason','text','Hair',175),(1167,'Bills','.pdf','',136),(1168,'Bills','.pdf','',137),(1169,'Bills','.pdf','',138),(1170,'Bills','.pdf','',139),(1171,'Bills','.pdf','',140),(1172,'Bills','.pdf','',141),(1173,'Bills','.pdf','',142),(1174,'Bills','.pdf','',143),(1175,'Bills','.pdf','',144),(1176,'Bills','.pdf','',145),(1177,'Bills','.pdf','',146),(1178,'Bills','.pdf','',147),(1179,'Bills','.pdf','',148),(1180,'Bills','.pdf','',149),(1181,'Bills','.pdf','',150),(1182,'Bills','.pdf','',151),(1183,'Bills','.pdf','',152),(1184,'Bills','.pdf','',153),(1185,'Bills','.pdf','',154),(1186,'Bills','.pdf','',155),(1187,'Bills','.pdf','',156),(1188,'Bills','.pdf','',157),(1189,'Bills','.pdf','',158),(1190,'Bills','.pdf','',159),(1191,'Bills','.pdf','',160),(1192,'Bills','.pdf','',161),(1193,'Bills','.pdf','',162),(1194,'Bills','.pdf','',163),(1195,'Bills','.pdf','',164),(1196,'Bills','.pdf','',165),(1197,'Bills','.pdf','',166),(1198,'Bills','.pdf','',167),(1199,'Bills','.pdf','',168),(1200,'Bills','.pdf','',169),(1201,'Bills','.pdf','',170),(1202,'Bills','.pdf','',171),(1203,'Bills','.pdf','',172),(1204,'Bills','.pdf','',173),(1205,'Bills','.pdf','',175),(1206,'Images','.jpeg','url,https://drive.google.com/file/d/1a4NUcRlzHfApDMBSJvya5Sh_7A93YfQL/view?usp=drive_web,https://drive.google.com/file/d/1_yP_qPLCDiXDG8J5Wnvy16E99lFZ_MCv/view?usp=drive_web',136),(1207,'Images','.jpeg','url',137),(1208,'Images','.jpeg','url,https://drive.google.com/file/d/1UB49H4BFybOtSV8pD5lDYcw0sqoD269C/view?usp=drive_web,url,https://drive.google.com/file/d/1lcrhH38zf41HwgWp4virIJwEENMmvDsl/view?usp=drive_web',138),(1209,'Images','.jpeg','url',139),(1210,'Images','.jpeg','url',140),(1211,'Images','.jpeg','url',141),(1212,'Images','.jpeg','url',142),(1213,'Images','.jpeg','url',143),(1214,'Images','.jpeg','url',144),(1215,'Images','.jpeg','url',145),(1216,'Images','.jpeg','url',146),(1217,'Images','.jpeg','url',147),(1218,'Images','.jpeg','url',148),(1219,'Images','.jpeg','url',149),(1220,'Images','.jpeg','url',150),(1221,'Images','.jpeg','url',151),(1222,'Images','.jpeg','url',152),(1223,'Images','.jpeg','url',153),(1224,'Images','.jpeg','url',154),(1225,'Images','.jpeg','url',155),(1226,'Images','.jpeg','url',156),(1227,'Images','.jpeg','url',157),(1228,'Images','.jpeg','url',158),(1229,'Images','.jpeg','url',159),(1230,'Images','.jpeg','url',160),(1231,'Images','.jpeg','url',161),(1232,'Images','.jpeg','url',162),(1233,'Images','.jpeg','url',163),(1234,'Images','.jpeg','url',164),(1235,'Images','.jpeg','url',165),(1236,'Images','.jpeg','url',166),(1237,'Images','.jpeg','url',167),(1238,'Images','.jpeg','url',168),(1239,'Images','.jpeg','url',169),(1240,'Images','.jpeg','url',170),(1241,'Images','.jpeg','url',171),(1242,'Images','.jpeg','url',172),(1243,'Images','.jpeg','url',173),(1244,'Images','.jpeg','url',175),(1247,'Name','Type','Value',178),(1248,'Name','Type','Value',179),(1249,'Name','Type','Value',180),(1250,'Name','Type','Value',181),(1251,'Images','.jpeg','url',182),(1252,'Name','Type','Value',183),(1253,'Name','text','Akhil',183),(1254,'Age','number','24',183),(1255,'Gender','text','M',183),(1256,'Reason','text','Hair',183),(1257,'Bills','.pdf','',183),(1258,'Images','.jpeg','url',183),(1273,'Name','Type','Value',186),(1274,'Name','text','Akhil',186),(1275,'Age','number','24',186),(1276,'Gender','text','M',186),(1277,'Reason','text','Hair',186),(1278,'Bills','.pdf','',186),(1279,'Images','.jpeg','url',186),(1280,'Name','Type','Value',187),(1281,'Name','text','Akhil',187),(1282,'Age','number','24',187),(1283,'Gender','text','M',187),(1284,'Reason','text','Hair',187),(1285,'Bills','.pdf','',187),(1286,'Images','.jpeg','url',187),(1287,'Name','Type','Value',188),(1288,'Name','text','Akhil',188),(1289,'Age','number','24',188),(1290,'Gender','text','M',188),(1291,'Reason','text','Hair',188),(1292,'Bills','.pdf','',188),(1293,'Images','.jpeg','url',188),(1294,'Name','Type','Value',189),(1295,'Name','text','Akhil',189),(1296,'Age','number','24',189),(1297,'Gender','text','M',189),(1298,'Reason','text','Hair',189),(1299,'Bills','.pdf','',189),(1300,'Images','.jpeg','url',189),(1301,'Name','Type','Value',190),(1302,'Name','text','Akhil',190),(1303,'Age','number','24',190),(1304,'Gender','text','M',190),(1305,'Reason','text','Hair',190),(1306,'Bills','.pdf','',190),(1307,'Images','.jpeg','url,https://drive.google.com/file/d/1a4NUcRlzHfApDMBSJvya5Sh_7A93YfQL/view?usp=drive_web,https://drive.google.com/file/d/1_yP_qPLCDiXDG8J5Wnvy16E99lFZ_MCv/view?usp=drive_web',190),(1308,'Name','Type','Value',191),(1309,'Name','text','Akhil',191),(1310,'Age','number','24',191),(1311,'Gender','text','M',191),(1312,'Reason','text','Hair',191),(1313,'Bills','.pdf','',191),(1314,'Images','.jpeg','url,https://drive.google.com/file/d/1a4NUcRlzHfApDMBSJvya5Sh_7A93YfQL/view?usp=drive_web,https://drive.google.com/file/d/1_yP_qPLCDiXDG8J5Wnvy16E99lFZ_MCv/view?usp=drive_web',191),(1315,'Name','Type','Value',192),(1316,'Name','text','Akhil',192),(1317,'Age','number','24',192),(1318,'Gender','text','M',192),(1319,'Reason','text','Hair',192),(1320,'Bills','.pdf','',192),(1321,'Images','.jpeg','url,https://drive.google.com/file/d/1a4NUcRlzHfApDMBSJvya5Sh_7A93YfQL/view?usp=drive_web,https://drive.google.com/file/d/1_yP_qPLCDiXDG8J5Wnvy16E99lFZ_MCv/view?usp=drive_web',192),(1322,'Name','Type','Value',193),(1323,'Name','text','Akhil',193),(1324,'Age','number','24',193),(1325,'Gender','text','M',193),(1326,'Reason','text','Hair',193),(1327,'Bills','.pdf','',193),(1328,'Images','.jpeg','url,https://drive.google.com/file/d/1a4NUcRlzHfApDMBSJvya5Sh_7A93YfQL/view?usp=drive_web,https://drive.google.com/file/d/1_yP_qPLCDiXDG8J5Wnvy16E99lFZ_MCv/view?usp=drive_web',193),(1343,'Name','Type','Value',196),(1344,'Name','text','Akhil',196),(1345,'Age','number','24',196),(1346,'Gender','text','M',196),(1347,'Reason','text','Hair',196),(1348,'Bills','.pdf','',196),(1349,'Images','.jpeg','url,https://drive.google.com/file/d/1a4NUcRlzHfApDMBSJvya5Sh_7A93YfQL/view?usp=drive_web,https://drive.google.com/file/d/1_yP_qPLCDiXDG8J5Wnvy16E99lFZ_MCv/view?usp=drive_web',196),(1350,'Name','Type','Value',197),(1351,'Name','text','Akhil',197),(1352,'Age','number','24',197),(1353,'Gender','text','M',197),(1354,'Reason','text','Hair',197),(1355,'Bills','.pdf','',197),(1356,'Images','.jpeg','url,https://drive.google.com/file/d/1a4NUcRlzHfApDMBSJvya5Sh_7A93YfQL/view?usp=drive_web,https://drive.google.com/file/d/1_yP_qPLCDiXDG8J5Wnvy16E99lFZ_MCv/view?usp=drive_web',197);
/*!40000 ALTER TABLE `datafield` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `idDoctor` int NOT NULL AUTO_INCREMENT,
  `docName` varchar(45) NOT NULL,
  `contactNumber` varchar(10) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idDoctor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (3,'Akhil','9999999999','singampalliakhil@gmail.com','password'),(4,'Dr.Srinivas','9898989898','srinudr71@gmail.com','password'),(5,'SuryaJaya','9010072493','bsurya1998@gmail.com','password'),(6,'Dr.DRJAYALAKSHMI','8501833666','drjayaderma@gmail.com','Exult@123');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_data`
--

DROP TABLE IF EXISTS `patient_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_data` (
  `idPatient_Data` int NOT NULL AUTO_INCREMENT,
  `desk_data_Id` varchar(100) DEFAULT NULL,
  `doc_data_Id` varchar(100) DEFAULT NULL,
  `bills_data_id` varchar(255) DEFAULT NULL,
  `img_data_id` varchar(255) DEFAULT NULL,
  `pres_data_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPatient_Data`)
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_data`
--

LOCK TABLES `patient_data` WRITE;
/*!40000 ALTER TABLE `patient_data` DISABLE KEYS */;
INSERT INTO `patient_data` VALUES (136,NULL,NULL,NULL,NULL,NULL),(137,NULL,NULL,NULL,NULL,NULL),(138,NULL,NULL,NULL,NULL,NULL),(139,NULL,NULL,NULL,NULL,NULL),(140,NULL,NULL,NULL,NULL,NULL),(141,NULL,NULL,NULL,NULL,NULL),(142,NULL,NULL,NULL,NULL,NULL),(143,NULL,NULL,NULL,NULL,NULL),(144,NULL,NULL,NULL,NULL,NULL),(145,NULL,NULL,NULL,NULL,NULL),(146,NULL,NULL,NULL,NULL,NULL),(147,NULL,NULL,NULL,NULL,NULL),(148,NULL,NULL,NULL,NULL,NULL),(149,NULL,NULL,NULL,NULL,NULL),(150,NULL,NULL,NULL,NULL,NULL),(151,NULL,NULL,NULL,NULL,NULL),(152,NULL,NULL,NULL,NULL,NULL),(153,NULL,NULL,NULL,NULL,NULL),(154,NULL,NULL,NULL,NULL,NULL),(155,NULL,NULL,NULL,NULL,NULL),(156,NULL,NULL,NULL,NULL,NULL),(157,NULL,NULL,NULL,NULL,NULL),(158,NULL,NULL,NULL,NULL,NULL),(159,NULL,NULL,NULL,NULL,NULL),(160,NULL,NULL,NULL,NULL,NULL),(161,NULL,NULL,NULL,NULL,NULL),(162,NULL,NULL,NULL,NULL,NULL),(163,NULL,NULL,NULL,NULL,NULL),(164,NULL,NULL,NULL,NULL,NULL),(165,NULL,NULL,NULL,NULL,NULL),(166,NULL,NULL,NULL,NULL,NULL),(167,NULL,NULL,NULL,NULL,NULL),(168,NULL,NULL,NULL,NULL,NULL),(169,NULL,NULL,NULL,NULL,NULL),(170,NULL,NULL,NULL,NULL,NULL),(171,NULL,NULL,NULL,NULL,NULL),(172,NULL,NULL,NULL,NULL,NULL),(173,NULL,NULL,NULL,NULL,NULL),(175,NULL,NULL,NULL,NULL,NULL),(178,NULL,NULL,NULL,NULL,NULL),(179,NULL,NULL,NULL,NULL,NULL),(180,NULL,NULL,NULL,NULL,NULL),(181,NULL,NULL,NULL,NULL,NULL),(182,NULL,NULL,NULL,NULL,NULL),(183,NULL,NULL,NULL,NULL,NULL),(186,NULL,NULL,NULL,NULL,NULL),(187,NULL,NULL,NULL,NULL,NULL),(188,NULL,NULL,NULL,NULL,NULL),(189,'1DVIUkFuXTXlNqEwjBpvHek57QKFRUJmZ',NULL,NULL,NULL,NULL),(190,'1g8GQ35wYYWFVTfCo37ixQAGyph0YNSQv',NULL,'1mkPbkT5gUonGTA_3uCZ6pHmFeg5knykc','1Xnpnzv-JYjitrZh-Dwm9Bro3XjZjJGJf','1571YLhrdnrWB5QWqr1JdNnc4KasK7rsY'),(191,'13akqmsibwDRTXCmUo82TgSfDbXZjtTH8',NULL,'1q8CAWHB2IshMYsjn-YyHLM7tWM2yU64k','1AgxsBZERcxe5i3j7uaEOv8klModTxj71','1OvUKd-KXyLwH64nodNF9Rg2yxlqVcCvl'),(192,'1ZihKDkx0SM7JR0nsMjMeXlG-D60n3_7H',NULL,'1qzNvCL8-9Dejm_of-Nkqv0GcyxbMMHqq','1x2NN8Yznm-syjnFPw64ahS4yk8kL8jOX','13s27P1OIrEp2EG5kXpr6rg7Jhof-HjnD'),(193,'1_wcFVDBymkB8fdAngNw68v7361T_gk3b','https://docs.google.com/document/d/1rn8MpogaXVIIPBHeX5q6QEtMnkgWxckp/edit?usp=sharing','1nihkzZMhsPEKCGe6mOUl0aUF2Qis8I4J','1duw82upEPSN4MBWUx95Ng2zV439nKOBC','1s-AUi3je3-DoQw1o0-qbvRzzpc0qA49C'),(196,'1goYZB7KraRKmJabduPeK5SKkfyG6X2FZ','https://docs.google.com/document/d/1aKZjwAvObwNRRWjvrUB9EFS1Uzwl4jdG/edit?usp=sharing','1oF5jEl0WiDdot-SDDGycxlWeTKUEH777','1MKmscv2yxKB5ayNyo21jt4W7j-Cv-kM4','1IRFt4OlHDWBj6yWZBFGROElMZySKgVem'),(197,'1Zi0FWoH3PeTdyxSb3S97BD8oxzds_8Jg','https://docs.google.com/document/d/1pQwe78TJqZ_jQvwPFgCnSXUH-tEjvRze/edit?usp=sharing','1gIWT2Tmhgx3ycZ4-LVIbHqWyCCmcHn16','1fe6Tr6aML3rcjJ02fXsUR1okWvpjAhjU','17OfDbYpmewoDmKm0xwBVbS7IyYCFjGvj');
/*!40000 ALTER TABLE `patient_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `idPatient` int NOT NULL AUTO_INCREMENT,
  `patientName` varchar(45) NOT NULL,
  `contactNumber` varchar(10) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `patient_data_idPatient_Data` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`idPatient`),
  KEY `fk_Patients_patient_data1_idx` (`patient_data_idPatient_Data`),
  CONSTRAINT `fk_Patients_patient_data1` FOREIGN KEY (`patient_data_idPatient_Data`) REFERENCES `patient_data` (`idPatient_Data`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (113,'M.SUNAYANA','7093287453','singampalliakhil@gmail.com','password',136),(114,'SHANTI','9989815741','singampalliakhil@gmail.com','password',137),(115,'M.RAMU','8374696577','singampalliakhil@gmail.com','password',138),(116,'Y.KRISHNAPRIYA','','singampalliakhil@gmail.com','password',139),(117,'D.SYAMALA','9490237410','singampalliakhil@gmail.com','password',140),(119,'DR.BILAL','9985195125','singampalliakhil@gmail.com','password',142),(121,'PKRUPA','8639727259','singampalliakhil@gmail.com','password',144),(122,'N.PAVANKUMAR','9154488473','singampalliakhil@gmail.com','password',145),(124,'B.JHON','8169772683','singampalliakhil@gmail.com','password',147),(125,'K.VISWESHWARAO','9705334578','singampalliakhil@gmail.com','password',148),(129,'DEVIPRASAD','8374138701','singampalliakhil@gmail.com','password',152),(134,'MADHURYA','9966001154','singampalliakhil@gmail.com','password',157),(136,'K.PUSHPALATHA','6304637545','singampalliakhil@gmail.com','password',159),(137,'JALAMSINGH','9550541740','singampalliakhil@gmail.com','password',160),(139,'P.SRAVANI','9550480892','singampalliakhil@gmail.com','password',162),(141,'AVINASH VARMA','9000358924','singampalliakhil@gmail.com','password',164),(144,'Y.HARITHA','9542006478','singampalliakhil@gmail.com','password',167),(146,'D.R.D.VARMA','8184843767','singampalliakhil@gmail.com','password',169),(150,'N.SARITHA','7799808909','singampalliakhil@gmail.com','password',173),(151,'Surya Jaya','8765789075','sinampalli@gmail.com','password',175),(154,'d divya','7780462123','divyarich61@gmail.com','Exult@123',178),(156,'dr anand','9866994134','akkidasanand@yahoo.co.in','Exult@123',180),(158,'Sample  Patient','7777777777','sample@gmail.com','password',182),(159,'Sample Sample','7878787878','samplesample@gmail.com','password',183),(162,'Ohio James','9000090000','ohiojames@gmail.com','password',186),(163,'Ohio James','9000090001','ohiojame@gmail.com','password',187),(164,'Ohio James','9000090002','ohioGym@gmail.com','password',188),(165,'Ohio James','9000090003','ohioGym1@gmail.com','password',189),(1001,'Akhil Aki','8787878787','akhilaki@gmail.com','password',190),(1002,'Akhil Singampalli','9898989898','akhilakhil@gmail.com','password',191),(1003,'Surya','9010072493','bsurya1998@gmail.com','9010072493',192),(1004,'Surya','9090909090','gamil@gmail.com','9090909090',193),(1007,'d d','8899889988','singa@gmail.com','password',196),(1008,'Ashish K','9860677800','ashish@appxbuild.com','password',197);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28 13:41:19
