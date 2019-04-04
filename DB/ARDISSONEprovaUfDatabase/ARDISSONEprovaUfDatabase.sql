CREATE DATABASE  IF NOT EXISTS `asilo_prestito_libri` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `asilo_prestito_libri`;
-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: asilo_prestito_libri
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB-0+deb9u1

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
-- Table structure for table `t_bimbi`
--

DROP TABLE IF EXISTS `t_bimbi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_bimbi` (
  `id_bimbo` int(11) NOT NULL AUTO_INCREMENT,
  `cognome` varchar(50) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `data_nasc` date DEFAULT NULL,
  `telefono` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id_bimbo`),
  UNIQUE KEY `idx_unico` (`cognome`,`nome`,`data_nasc`),
  KEY `idx_cognome` (`cognome`),
  KEY `idx_nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_bimbi`
--

LOCK TABLES `t_bimbi` WRITE;
/*!40000 ALTER TABLE `t_bimbi` DISABLE KEYS */;
INSERT INTO `t_bimbi` VALUES (1,'Re','Blu','1999-02-28','9876543210','blu@re.it'),(2,'Re','Pathos','2001-06-10','1234567890','pathos@re.it'),(3,'Zucca','Luce','2006-09-05','4567890123','luce@zucca.it'),(4,'Ardissone','Alberto','2006-10-31','6543210987','alberto@ardissone.it'),(5,'Ardissone','Giorgio','2004-02-25','7538694210','giorgio@ardi.it');
/*!40000 ALTER TABLE `t_bimbi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_libri`
--

DROP TABLE IF EXISTS `t_libri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_libri` (
  `id_libro` int(11) NOT NULL AUTO_INCREMENT,
  `titolo` varchar(100) NOT NULL,
  `autore` varchar(100) NOT NULL,
  `casa_editrice` varchar(50) DEFAULT NULL,
  `cod_isbn` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_libro`),
  KEY `idx_titolo` (`titolo`),
  KEY `idx_autore` (`autore`),
  KEY `idx_editore` (`casa_editrice`),
  KEY `idx_isbn` (`cod_isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_libri`
--

LOCK TABLES `t_libri` WRITE;
/*!40000 ALTER TABLE `t_libri` DISABLE KEYS */;
INSERT INTO `t_libri` VALUES (1,'Pinocchio','Collodi Carlo','Mursia','8804571942'),(2,'Pinocchio','Collodi Carlo','Mursia','8804571942'),(3,'Pinocchio','Collodi Carlo','Mursia','8804571942'),(4,'Pinocchio','Collodi Carlo','Mursia','8804571942'),(5,'Pinocchio','Collodi Carlo','Mursia','8804571942'),(6,'Pinocchio','Collodi Carlo','Mursia','8804571942'),(7,'Pinocchio','Collodi Carlo','Mursia','8804571942'),(8,'Peter Pan','Barrie James Matthew','PiEmme','6504571942'),(9,'Peter Pan','Barrie James Matthew','PiEmme','6504571942'),(10,'Peter Pan','Barrie James Matthew','PiEmme','6504571942'),(11,'Peter Pan','Barrie James Matthew','PiEmme','6504571942'),(12,'Peter Pan','Barrie James Matthew','PiEmme','6504571942'),(13,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(14,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(15,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(16,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(17,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(18,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(19,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(20,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(21,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(22,'Fiabe','Fratelli Grimm','Mondadori','8804781942'),(23,'Favole','Esopo','La Scuola','8825571942'),(24,'Favole','Esopo','La Scuola','8825571942'),(25,'Favole','Esopo','La Scuola','8825571942'),(26,'Favole','Esopo','La Scuola','8825571942'),(27,'Peppa Pig','Davies Phil, Boccia Antonio','Penguin Books','8235571942'),(28,'Peppa Pig','Davies Phil, Boccia Antonio','Penguin Books','8235571942'),(29,'Peppa Pig','Davies Phil, Boccia Antonio','Penguin Books','8235571942'),(30,'C\'era una volta in Africa','AA. VV.','DeAgostini','1535571942'),(31,'Favole','Esopo','La Scuola','8825571942');
/*!40000 ALTER TABLE `t_libri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_prestiti`
--

DROP TABLE IF EXISTS `t_prestiti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_prestiti` (
  `id_prestito` int(11) NOT NULL AUTO_INCREMENT,
  `id_libro` int(11) NOT NULL,
  `id_bimbo` int(11) NOT NULL,
  `data_preso` datetime NOT NULL,
  `data_restituito` datetime DEFAULT NULL,
  PRIMARY KEY (`id_prestito`),
  KEY `idx_libro` (`id_libro`),
  KEY `idx_bimbo` (`id_bimbo`),
  KEY `idx_preso` (`data_preso`),
  KEY `idx_restituito` (`data_restituito`),
  CONSTRAINT `fk_t_prestiti_1` FOREIGN KEY (`id_libro`) REFERENCES `t_libri` (`id_libro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_prestiti_2` FOREIGN KEY (`id_bimbo`) REFERENCES `t_bimbi` (`id_bimbo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_prestiti`
--

LOCK TABLES `t_prestiti` WRITE;
/*!40000 ALTER TABLE `t_prestiti` DISABLE KEYS */;
INSERT INTO `t_prestiti` VALUES (1,1,1,'2019-04-04 14:15:33',NULL),(2,12,2,'2019-03-04 09:15:33',NULL),(3,23,3,'2019-03-31 16:01:33',NULL),(4,4,4,'2019-02-04 14:15:33','2019-03-15 00:00:00'),(5,31,5,'2018-05-04 14:15:33','2018-09-10 00:00:00'),(6,28,1,'2019-04-04 14:15:33',NULL),(7,30,2,'2019-03-04 09:15:33',NULL),(10,21,5,'2019-02-01 00:00:00','2019-03-20 00:00:00'),(11,1,3,'2018-10-03 00:00:00','2018-11-25 00:00:00');
/*!40000 ALTER TABLE `t_prestiti` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `asilo_prestito_libri`.`t_prestiti_BEFORE_INSERT` BEFORE INSERT ON `t_prestiti` FOR EACH ROW
BEGIN
	IF (NEW.data_preso IS NULL) THEN
		SET NEW.data_preso = NOW();
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary table structure for view `v_bimbi_all`
--

DROP TABLE IF EXISTS `v_bimbi_all`;
/*!50001 DROP VIEW IF EXISTS `v_bimbi_all`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_bimbi_all` (
  `id_bimbo` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `data_nasc` tinyint NOT NULL,
  `telefono` tinyint NOT NULL,
  `email` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_libri_all`
--

DROP TABLE IF EXISTS `v_libri_all`;
/*!50001 DROP VIEW IF EXISTS `v_libri_all`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_libri_all` (
  `id_libro` tinyint NOT NULL,
  `titolo` tinyint NOT NULL,
  `autore` tinyint NOT NULL,
  `casa_editrice` tinyint NOT NULL,
  `cod_isbn` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_prestiti_all`
--

DROP TABLE IF EXISTS `v_prestiti_all`;
/*!50001 DROP VIEW IF EXISTS `v_prestiti_all`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_prestiti_all` (
  `id_prestito` tinyint NOT NULL,
  `data_preso` tinyint NOT NULL,
  `data_restituito` tinyint NOT NULL,
  `id_bimbo` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `id_libro` tinyint NOT NULL,
  `titolo` tinyint NOT NULL,
  `autore` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_prestiti_out`
--

DROP TABLE IF EXISTS `v_prestiti_out`;
/*!50001 DROP VIEW IF EXISTS `v_prestiti_out`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_prestiti_out` (
  `id_prestito` tinyint NOT NULL,
  `data_preso` tinyint NOT NULL,
  `data_restituito` tinyint NOT NULL,
  `id_bimbo` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `id_libro` tinyint NOT NULL,
  `titolo` tinyint NOT NULL,
  `autore` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'asilo_prestito_libri'
--

--
-- Dumping routines for database 'asilo_prestito_libri'
--

--
-- Final view structure for view `v_bimbi_all`
--

/*!50001 DROP TABLE IF EXISTS `v_bimbi_all`*/;
/*!50001 DROP VIEW IF EXISTS `v_bimbi_all`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_bimbi_all` AS select `t_bimbi`.`id_bimbo` AS `id_bimbo`,`t_bimbi`.`cognome` AS `cognome`,`t_bimbi`.`nome` AS `nome`,`t_bimbi`.`data_nasc` AS `data_nasc`,`t_bimbi`.`telefono` AS `telefono`,`t_bimbi`.`email` AS `email` from `t_bimbi` order by `t_bimbi`.`cognome`,`t_bimbi`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_libri_all`
--

/*!50001 DROP TABLE IF EXISTS `v_libri_all`*/;
/*!50001 DROP VIEW IF EXISTS `v_libri_all`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_libri_all` AS select `t_libri`.`id_libro` AS `id_libro`,`t_libri`.`titolo` AS `titolo`,`t_libri`.`autore` AS `autore`,`t_libri`.`casa_editrice` AS `casa_editrice`,`t_libri`.`cod_isbn` AS `cod_isbn` from `t_libri` order by `t_libri`.`titolo`,`t_libri`.`autore` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_prestiti_all`
--

/*!50001 DROP TABLE IF EXISTS `v_prestiti_all`*/;
/*!50001 DROP VIEW IF EXISTS `v_prestiti_all`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_prestiti_all` AS select `P`.`id_prestito` AS `id_prestito`,`P`.`data_preso` AS `data_preso`,`P`.`data_restituito` AS `data_restituito`,`B`.`id_bimbo` AS `id_bimbo`,`B`.`cognome` AS `cognome`,`B`.`nome` AS `nome`,`L`.`id_libro` AS `id_libro`,`L`.`titolo` AS `titolo`,`L`.`autore` AS `autore` from ((`t_prestiti` `P` join `t_bimbi` `B` on((`B`.`id_bimbo` = `P`.`id_bimbo`))) join `t_libri` `L` on((`L`.`id_libro` = `P`.`id_libro`))) order by `P`.`data_preso` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_prestiti_out`
--

/*!50001 DROP TABLE IF EXISTS `v_prestiti_out`*/;
/*!50001 DROP VIEW IF EXISTS `v_prestiti_out`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_prestiti_out` AS select `P`.`id_prestito` AS `id_prestito`,`P`.`data_preso` AS `data_preso`,`P`.`data_restituito` AS `data_restituito`,`B`.`id_bimbo` AS `id_bimbo`,`B`.`cognome` AS `cognome`,`B`.`nome` AS `nome`,`L`.`id_libro` AS `id_libro`,`L`.`titolo` AS `titolo`,`L`.`autore` AS `autore` from ((`t_prestiti` `P` join `t_bimbi` `B` on((`B`.`id_bimbo` = `P`.`id_bimbo`))) join `t_libri` `L` on((`L`.`id_libro` = `P`.`id_libro`))) where isnull(`P`.`data_restituito`) order by `P`.`data_preso` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-04 15:56:52
