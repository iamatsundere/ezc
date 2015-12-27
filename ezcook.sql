-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: ezcook
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Cá'),(2,'Thịt'),(3,'Canh'),(4,'Rau'),(5,'Lẩu');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `icon` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `is_deleted` int(11) NOT NULL DEFAULT '0',
  `last_update` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,'Thịt Bò','ádasd',45400,'kg',0,'0115-10-02'),(2,'Hành','fđf',120000,'kg',1,'2015-11-16'),(4,'Thịt Bò','ádsd',121210,'kg',0,'0115-10-05'),(6,'vá»t',NULL,120,'kg',0,NULL),(7,'Vá»t',NULL,120,'kg',0,NULL),(8,'tÃ´m',NULL,120,'kg',0,'2015-11-05'),(9,'tÃ´m',NULL,120,'kg',0,'2015-11-05'),(10,'TÃ´m',NULL,120,'kg',0,'0115-10-00'),(11,'Thịt Lơn',NULL,22223200,'kg',0,'0115-10-05'),(12,'Tôm Hùm',NULL,0,'kg',0,'0115-10-00'),(13,'ba ba',NULL,1111,'kg',0,'0115-10-02'),(14,'abcabca',NULL,11212,'VN',0,'0115-10-05');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_menu_user1_idx` (`user_id`),
  CONSTRAINT `fk_menu_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_has_recipe`
--

DROP TABLE IF EXISTS `menu_has_recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_has_recipe` (
  `menu_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_id`,`food_id`),
  KEY `fk_menu_has_food_food1_idx` (`food_id`),
  KEY `fk_menu_has_food_menu1_idx` (`menu_id`),
  CONSTRAINT `fk_menu_has_food_food1` FOREIGN KEY (`food_id`) REFERENCES `recipe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_has_food_menu1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_has_recipe`
--

LOCK TABLES `menu_has_recipe` WRITE;
/*!40000 ALTER TABLE `menu_has_recipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu_has_recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_ingredient`
--

DROP TABLE IF EXISTS `price_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `unit` varchar(45) NOT NULL,
  `material_id` int(11) NOT NULL,
  `last_update` date DEFAULT NULL,
  PRIMARY KEY (`id`,`material_id`),
  KEY `fk_price_material_material1_idx` (`material_id`),
  CONSTRAINT `fk_price_material_material1` FOREIGN KEY (`material_id`) REFERENCES `ingredient` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_ingredient`
--

LOCK TABLES `price_ingredient` WRITE;
/*!40000 ALTER TABLE `price_ingredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `price_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `made_in` varchar(45) NOT NULL,
  `processing` mediumtext NOT NULL,
  `image` varchar(45) DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `is_deleted` int(11) NOT NULL DEFAULT '0',
  `last_update` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_food_category1_idx` (`category_id`),
  CONSTRAINT `fk_food_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,'Cá Chiên','Việt Nam ','     abcabcaaaa','acbacb',5,0,'0115-10-05'),(5,'Thịt Kho','VN abc ',' ádsadsfdf','ádasd',2,0,'0115-11-03'),(6,'Lẩu Gà','VN','dfdf','dfdf',5,0,NULL),(7,'Bò Bít Tết','VN','3434','343',2,0,NULL),(8,'Bún Đậu Mắm Tôm','VN','3sfd','fdf3df',2,0,NULL),(9,'a','a',' a',NULL,5,0,'0115-10-05');
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_has_ingredient`
--

DROP TABLE IF EXISTS `recipe_has_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipe_has_ingredient` (
  `recipe_id` int(11) NOT NULL,
  `ingredient_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`recipe_id`,`ingredient_id`),
  KEY `fk_recipe_has_ingredient_ingredient1_idx` (`ingredient_id`),
  KEY `fk_recipe_has_ingredient_recipe1_idx` (`recipe_id`),
  CONSTRAINT `fk_recipe_has_ingredient_ingredient1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_has_ingredient_recipe1` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_has_ingredient`
--

LOCK TABLES `recipe_has_ingredient` WRITE;
/*!40000 ALTER TABLE `recipe_has_ingredient` DISABLE KEYS */;
INSERT INTO `recipe_has_ingredient` VALUES (1,1,555),(1,2,555),(1,7,555),(5,2,22),(5,4,1212),(5,7,1212),(5,12,1212),(5,13,111);
/*!40000 ALTER TABLE `recipe_has_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) NOT NULL,
  `password` varchar(12) NOT NULL,
  `last_update` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ezcook'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-23 23:51:14
