CREATE DATABASE  IF NOT EXISTS `computer-management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `computer-management`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: computer-management
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
-- Table structure for table `computer`
--

DROP TABLE IF EXISTS `computer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `categoryname` varchar(255) DEFAULT NULL,
  `cpu` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `storage` varchar(255) DEFAULT NULL,
  `storagetype` varchar(255) DEFAULT NULL,
  `gpu` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `neew` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `wind` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computer`
--

LOCK TABLES `computer` WRITE;
/*!40000 ALTER TABLE `computer` DISABLE KEYS */;
INSERT INTO `computer` VALUES (1,'islemesi','Asus','Cavid','Asus','i9 11900K','64 gb','1 tb','CCD','RTX 3090 ti',500,'Yeni','050 216 48 06','Windows 11'),(2,'islemesi','Asus','Cavid','Asus','i9 11900K','64 gb','1 tb','CCD','RTX 3090 ti',500,'Yeni','050 216 48 06','Windows 11'),(3,'islemesi','Asus','Cavid','Asus','i9 11900K','64 gb','1 tb','CCD','RTX 3090 ti',500,'Yeni','050 216 48 06','Windows 11'),(4,'islemesi','Asus','Cavid','Asus','i9 11900K','64 gb','1 tb','CCD','RTX 3090 ti',500,'Yeni','050 216 48 06','Windows 11'),(5,'yaxsi','acer super','cavid',NULL,'Core|9','18','500','SSD','640',750,'Xeyr','051-354-34-34','Windows 11'),(6,'yaxsi','php super','cavid','Php','Core|9','16','500','SSD','6',500,'Beli','051-354-34-34','Windows 11'),(7,'yaxsi','php super','cavid','Php','Core|9','16','500','SSD','6',500,'Beli','051-354-34-34','Windows 11');
/*!40000 ALTER TABLE `computer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-02 20:45:25
