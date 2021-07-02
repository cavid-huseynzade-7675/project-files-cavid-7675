CREATE DATABASE  IF NOT EXISTS `task-management-aprel11` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `task-management-aprel11`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: task-management-aprel11
-- ------------------------------------------------------
-- Server version	5.5.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `begin_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  `categoryid` int(11) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (32,'2021-06-10','ders elemek lazimdir','Dersini ele','2021-06-16',5,'2021-06-16','lazimdir','Ağali'),(34,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(35,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(36,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(37,'2021-05-31','vacib','cavide f,sfsf','2021-06-23',5,'2021-06-23','eleme','KAMALA'),(38,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(39,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(40,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(41,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(42,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(43,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(44,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(45,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(46,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(47,'2021-06-26','Yazmaq lazimdir','Java Oyren','2021-06-26',5,'2021-06-26','baslanib','Cavid'),(49,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(54,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(55,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(65,'2021-06-08','ders elemek lazimdir','cavide f,sfsf','2021-06-25',5,'2021-06-25','lazimdir','Ağali'),(66,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(67,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(68,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(69,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(70,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(71,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(72,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(73,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(74,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(75,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(77,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(78,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(79,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(80,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(81,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(82,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid'),(84,'2021-06-29','Yazmaq lazimdir','Java Oyren','2021-06-29',5,'2021-06-29','baslanib','Cavid');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-02 20:44:24
