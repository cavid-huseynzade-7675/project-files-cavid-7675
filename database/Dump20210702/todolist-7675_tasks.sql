CREATE DATABASE  IF NOT EXISTS `todolist-7675` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `todolist-7675`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: todolist-7675
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
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `taskname` varchar(45) DEFAULT NULL,
  `gun` date DEFAULT NULL,
  `date` date DEFAULT NULL,
  `kateqoriya` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (32,'132','sda','2020-11-14','2020-11-12','fd','Hell olunub'),(42,'1234','kkk','2020-11-27','2020-11-11','j','Hell olunmayib'),(43,'1234','fhfhfghfg','2020-11-27','2020-11-11','j','Hell olunub'),(44,'1234','fhfhfghfg','2020-11-27','2020-11-11','j','Hell olunmayib'),(45,'1523','ijni','2020-11-01','2020-11-14','fg','Hell olunmayib'),(46,'1523','ijni','2020-11-01','2020-11-23','fg','Hell olunmayib'),(47,'1523','ijni','2020-12-05','2020-11-23','fg','Hell olunmayib'),(49,'1523','ijni','2019-12-19','2018-10-29','fg','Hell olunmayib'),(50,'CAVID','sadsd','2021-01-02','2020-11-29','12','Hell olunmayib'),(51,'CAVID','sadsd','2020-12-18','2020-11-29','12','Hell olunmayib'),(52,'123','5454l','2021-07-01','2021-06-15','123','Hell olunub'),(53,'123','1231','2021-06-16','2021-06-15','lkj','Hell olunmayib');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-02 20:46:21
