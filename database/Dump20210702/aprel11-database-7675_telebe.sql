CREATE DATABASE  IF NOT EXISTS `aprel11-database-7675` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `aprel11-database-7675`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: aprel11-database-7675
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
-- Table structure for table `telebe`
--

DROP TABLE IF EXISTS `telebe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telebe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sector` varchar(10) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telebe`
--

LOCK TABLES `telebe` WRITE;
/*!40000 ALTER TABLE `telebe` DISABLE KEYS */;
INSERT INTO `telebe` VALUES (1,'adil','soyad',NULL,'az',NULL,NULL),(2,'adil','soyad',NULL,'az',NULL,NULL),(4,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(5,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(6,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(7,'adil','soyad',NULL,'az',NULL,NULL),(8,'adil','soyad',NULL,'az',NULL,NULL),(9,'adil','Psoyad',NULL,'az',NULL,NULL),(10,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(11,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(12,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(13,'adil','soyad',NULL,'az',NULL,NULL),(14,'adil','soyad',NULL,'az',NULL,NULL),(15,'adil','Psoyad',NULL,'az',NULL,NULL),(16,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(17,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(18,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(19,'adil','soyad',NULL,'az',NULL,NULL),(20,'adil','soyad',NULL,'az',NULL,NULL),(21,'adil','Psoyad',NULL,'az',NULL,NULL),(22,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(23,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon'),(24,'ads','soyad','2005-06-15','az','050-054-12-12','LOndon');
/*!40000 ALTER TABLE `telebe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-02 20:46:16
