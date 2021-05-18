DROP DATABASE IF EXISTS `casa_expres`;
CREATE DATABASE casa_expres;
USE casa_expres;

-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: casa_expres
-- ------------------------------------------------------
-- Server version	10.5.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `casa`
--

DROP TABLE IF EXISTS `casa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casa` (
  `IDINMUEBLE` int(11) NOT NULL AUTO_INCREMENT,
  `CALLE` varchar(255) NOT NULL,
  `M2` int(11) NOT NULL,
  `N_HABITACIONES` int(11) DEFAULT NULL,
  `PRECIO_COMPRA` int(11) NOT NULL,
  `PRECIO_ALQUILER` int(11) DEFAULT NULL,
  `N_INQUILINOS` int(1) DEFAULT NULL,
  `FECHA_COMPRA` date NOT NULL,
  `IDUSUARIO` int(11) NOT NULL,
  PRIMARY KEY (`IDINMUEBLE`),
  KEY `FK_usuario_idx` (`IDUSUARIO`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`IDUSUARIO`) REFERENCES `user` (`IDUSER`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casa`
--

LOCK TABLES `casa` WRITE;
/*!40000 ALTER TABLE `casa` DISABLE KEYS */;
/*!40000 ALTER TABLE `casa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gastos`
--

DROP TABLE IF EXISTS `gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gastos` (
  `IDGASTO` int(11) NOT NULL AUTO_INCREMENT,
  `N_FACTURA` int(11) NOT NULL,
  `PROVEEDOR` varchar(45) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `FECHA` date NOT NULL,
  `TIPO_GASTO_ID` int(11) NOT NULL,
  `IDINMUEBLE_GASTO` int(11) NOT NULL,
  PRIMARY KEY (`IDGASTO`),
  KEY `FK_gasto_casa_idx` (`IDINMUEBLE_GASTO`),
  KEY `FK_tipo_gasto_idx` (`TIPO_GASTO_ID`),
  CONSTRAINT `FK_gasto_casa` FOREIGN KEY (`IDINMUEBLE_GASTO`) REFERENCES `casa` (`IDINMUEBLE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tipo_gasto` FOREIGN KEY (`TIPO_GASTO_ID`) REFERENCES `tipos_gastos` (`IDTIPOS_GASTOS`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresos` (
  `IDINGRESOS` int(11) NOT NULL AUTO_INCREMENT,
  `CANTIDA_INGRESO` int(11) NOT NULL,
  `IDINMUEBLE_INGRESO` int(11) NOT NULL,
  PRIMARY KEY (`IDINGRESOS`),
  KEY `FK_inmueble_idx` (`IDINMUEBLE_INGRESO`),
  CONSTRAINT `FK_inmueble` FOREIGN KEY (`IDINMUEBLE_INGRESO`) REFERENCES `casa` (`IDINMUEBLE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_gastos`
--

DROP TABLE IF EXISTS `tipos_gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_gastos` (
  `IDTIPOS_GASTOS` int(11) NOT NULL,
  `DETALLES` varchar(45) NOT NULL,
  PRIMARY KEY (`IDTIPOS_GASTOS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_gastos`
--

LOCK TABLES `tipos_gastos` WRITE;
/*!40000 ALTER TABLE `tipos_gastos` DISABLE KEYS */;
INSERT INTO `tipos_gastos` VALUES (1,'agua'),(2,'luz'),(3,'gas'),(4,'reformas'),(5,'de reparacion'),(6,'comunidad');
/*!40000 ALTER TABLE `tipos_gastos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `IDUSER` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  PRIMARY KEY (`IDUSER`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-18  9:08:43
