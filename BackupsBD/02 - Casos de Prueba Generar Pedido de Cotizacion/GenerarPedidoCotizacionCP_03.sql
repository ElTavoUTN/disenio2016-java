-- MySQL dump 10.13  Distrib 5.7.7-rc, for Win32 (AMD64)
--
-- Host: localhost    Database: sinapsis
-- ------------------------------------------------------
-- Server version	5.7.7-rc-log

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
-- Current Database: `sinapsis`
--

/*!40000 DROP DATABASE IF EXISTS `sinapsis`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sinapsis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sinapsis`;

--
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulo` (
  `OIDArticulo` varchar(40) NOT NULL,
  `codigoArticulo` varchar(40) NOT NULL,
  `nombreArticulo` varchar(45) NOT NULL,
  `stockArticulo` int(20) NOT NULL,
  `OIDTipoProducto` varchar(40) DEFAULT NULL,
  `OIDMarca` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`OIDArticulo`),
  KEY `OIDTipoProducto` (`OIDTipoProducto`),
  KEY `OIDMarca` (`OIDMarca`),
  CONSTRAINT `articulo_ibfk_1` FOREIGN KEY (`OIDTipoProducto`) REFERENCES `tipoproducto` (`OIDTipoProducto`),
  CONSTRAINT `articulo_ibfk_2` FOREIGN KEY (`OIDMarca`) REFERENCES `marca` (`OIDMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES ('1','1','Lavandina Ayudín GEL 500 cc',30,'1','1'),('2','2','Lavandina Ayudín Lavanda 500 cc',25,'2','2'),('3','3','Detergente Magistral Limón 1000 cc',10,'3','3'),('4','4','Detergente Magistral Aloe 1000 cc',50,'1','1'),('5','5','Lavanda',20,'3','2'),('6','6','lavanda2',32,'2','3');
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articuloproveedor`
--

DROP TABLE IF EXISTS `articuloproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articuloproveedor` (
  `OIDArticuloProveedor` varchar(40) NOT NULL,
  `codigoExterno` varchar(40) DEFAULT NULL,
  `OIDArticulo` varchar(40) DEFAULT NULL,
  `OIDProveedor` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`OIDArticuloProveedor`),
  KEY `OIDArticulo` (`OIDArticulo`),
  KEY `OIDProveedor` (`OIDProveedor`),
  CONSTRAINT `articuloproveedor_ibfk_1` FOREIGN KEY (`OIDArticulo`) REFERENCES `articulo` (`OIDArticulo`),
  CONSTRAINT `articuloproveedor_ibfk_2` FOREIGN KEY (`OIDProveedor`) REFERENCES `proveedor` (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articuloproveedor`
--

LOCK TABLES `articuloproveedor` WRITE;
/*!40000 ALTER TABLE `articuloproveedor` DISABLE KEYS */;
INSERT INTO `articuloproveedor` VALUES ('1','B-0456','1','1'),('2','R-0483','2','2'),('3','R-0443','1','2'),('4','R-002','2','4');
/*!40000 ALTER TABLE `articuloproveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotizacion`
--

DROP TABLE IF EXISTS `cotizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotizacion` (
  `OIDCotizacion` varchar(40) NOT NULL,
  `numCotizacion` int(20) NOT NULL,
  `fechaCotizacion` date NOT NULL,
  `fechaEntregaCotizacion` date DEFAULT NULL,
  `fechaVencimientoCotizacion` date NOT NULL,
  `horaEntregaCotizacion` time DEFAULT NULL,
  `OIDReposicion` varchar(40) DEFAULT NULL,
  `OIDProveedor` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`OIDCotizacion`),
  KEY `OIDReposicion` (`OIDReposicion`),
  KEY `OIDProveedor` (`OIDProveedor`),
  CONSTRAINT `cotizacion_ibfk_1` FOREIGN KEY (`OIDReposicion`) REFERENCES `reposicion` (`OIDReposicion`),
  CONSTRAINT `cotizacion_ibfk_2` FOREIGN KEY (`OIDProveedor`) REFERENCES `proveedor` (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotizacion`
--

LOCK TABLES `cotizacion` WRITE;
/*!40000 ALTER TABLE `cotizacion` DISABLE KEYS */;
INSERT INTO `cotizacion` VALUES ('1',1,'2016-05-12','2016-05-12','2016-05-19','16:00:00','1','1'),('2',2,'2016-05-12','2016-10-01','2016-10-19','17:00:00','2','2'),('3',3,'2016-05-12','2016-05-14','2016-05-19','17:00:00','2','3'),('4',4,'2016-05-17','2016-05-17','2016-05-19','18:00:00','1','4');
/*!40000 ALTER TABLE `cotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotizaciondetalle`
--

DROP TABLE IF EXISTS `cotizaciondetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotizaciondetalle` (
  `OIDCotizacionDetalle` varchar(40) NOT NULL,
  `OIDEstadoCotizacionDetalle` varchar(40) DEFAULT NULL,
  `OIDCotizacion` varchar(40) DEFAULT NULL,
  `OIDArticuloProveedor` varchar(40) DEFAULT NULL,
  `OIDReposicionDetalle` varchar(40) DEFAULT NULL,
  `renglonCotizacion` int(20) NOT NULL,
  `cantidadAPedirCotizacion` int(20) DEFAULT NULL,
  `cantidadCotizada` int(20) DEFAULT NULL,
  `precioArticuloLista` float DEFAULT NULL,
  `precioCotizacion` double DEFAULT NULL,
  PRIMARY KEY (`OIDCotizacionDetalle`),
  KEY `OIDArticuloProveedor` (`OIDArticuloProveedor`),
  KEY `OIDEstadoCotizacionDetalle` (`OIDEstadoCotizacionDetalle`),
  KEY `OIDCotizacion` (`OIDCotizacion`),
  KEY `OIDReposicionDetalle` (`OIDReposicionDetalle`),
  CONSTRAINT `cotizaciondetalle_ibfk_1` FOREIGN KEY (`OIDArticuloProveedor`) REFERENCES `articuloproveedor` (`OIDArticuloProveedor`),
  CONSTRAINT `cotizaciondetalle_ibfk_2` FOREIGN KEY (`OIDEstadoCotizacionDetalle`) REFERENCES `estadocotizaciondetalle` (`OIDEstadoCotizacionDetalle`),
  CONSTRAINT `cotizaciondetalle_ibfk_3` FOREIGN KEY (`OIDCotizacion`) REFERENCES `cotizacion` (`OIDCotizacion`),
  CONSTRAINT `cotizaciondetalle_ibfk_4` FOREIGN KEY (`OIDReposicionDetalle`) REFERENCES `reposiciondetalle` (`OIDReposicionDetalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotizaciondetalle`
--

LOCK TABLES `cotizaciondetalle` WRITE;
/*!40000 ALTER TABLE `cotizaciondetalle` DISABLE KEYS */;
INSERT INTO `cotizaciondetalle` VALUES ('1','2','3','1','1',1,120,100,20,20),('2','2','2','1','2',2,555,555,22,19),('3','2','2','2','3',3,666,666,25,18),('4','2','1','2','4',4,70,60,25,13);
/*!40000 ALTER TABLE `cotizaciondetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadocotizaciondetalle`
--

DROP TABLE IF EXISTS `estadocotizaciondetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadocotizaciondetalle` (
  `OIDEstadoCotizacionDetalle` varchar(40) NOT NULL,
  `codigoEstadoCotizacionDetalle` varchar(40) NOT NULL,
  `nombreEstadoCotizacionDetalle` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoCotizacionDetalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadocotizaciondetalle`
--

LOCK TABLES `estadocotizaciondetalle` WRITE;
/*!40000 ALTER TABLE `estadocotizaciondetalle` DISABLE KEYS */;
INSERT INTO `estadocotizaciondetalle` VALUES ('2','2','Cargada'),('3','3','Descartada'),('4','4','Seleccionada'),('5','5','Vencida'),('6','6','No seleccionada');
/*!40000 ALTER TABLE `estadocotizaciondetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadopedido`
--

DROP TABLE IF EXISTS `estadopedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadopedido` (
  `OIDEstadoPedido` varchar(40) NOT NULL,
  `codigoEstadoPedido` int(20) NOT NULL,
  `nombreEstadoPedido` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadopedido`
--

LOCK TABLES `estadopedido` WRITE;
/*!40000 ALTER TABLE `estadopedido` DISABLE KEYS */;
INSERT INTO `estadopedido` VALUES ('1',1,'En Curso'),('2',2,'Recepcionado'),('3',3,'Rechazado Pendiente de Entrega'),('4',4,'Rechazado');
/*!40000 ALTER TABLE `estadopedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoreposicion`
--

DROP TABLE IF EXISTS `estadoreposicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoreposicion` (
  `OIDEstadoReposicion` varchar(40) NOT NULL,
  `codigoEstadoReposicion` int(20) NOT NULL,
  `nombreEstadoReposicion` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoReposicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoreposicion`
--

LOCK TABLES `estadoreposicion` WRITE;
/*!40000 ALTER TABLE `estadoreposicion` DISABLE KEYS */;
INSERT INTO `estadoreposicion` VALUES ('1',1,'Calculada'),('2',2,'Pendienta a Cotizar'),('3',3,'Notificada'),('4',4,'Atendida'),('5',5,'Atendida Pendiente de Recepcion'),('6',6,'Finalizada');
/*!40000 ALTER TABLE `estadoreposicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listaprecio`
--

DROP TABLE IF EXISTS `listaprecio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listaprecio` (
  `OIDListaPrecio` varchar(40) NOT NULL,
  `numListaPrecio` int(20) NOT NULL,
  `vigente` tinyint(1) NOT NULL,
  `OIDProveedor` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDListaPrecio`),
  KEY `OIDProveedor` (`OIDProveedor`),
  CONSTRAINT `listaprecio_ibfk_1` FOREIGN KEY (`OIDProveedor`) REFERENCES `proveedor` (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listaprecio`
--

LOCK TABLES `listaprecio` WRITE;
/*!40000 ALTER TABLE `listaprecio` DISABLE KEYS */;
INSERT INTO `listaprecio` VALUES ('1',1,0,'1'),('2',2,1,'2'),('3',3,1,'3'),('4',4,1,'4');
/*!40000 ALTER TABLE `listaprecio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listapreciodetalle`
--

DROP TABLE IF EXISTS `listapreciodetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listapreciodetalle` (
  `OIDListaPrecioDetalle` varchar(40) NOT NULL,
  `OIDArticulo` varchar(40) DEFAULT NULL,
  `OIDListaPrecio` varchar(40) DEFAULT NULL,
  `precioArticulo` float NOT NULL,
  `renglonLista` int(20) NOT NULL,
  PRIMARY KEY (`OIDListaPrecioDetalle`),
  KEY `OIDArticulo` (`OIDArticulo`),
  KEY `OIDListaPrecio` (`OIDListaPrecio`),
  CONSTRAINT `listapreciodetalle_ibfk_1` FOREIGN KEY (`OIDArticulo`) REFERENCES `articulo` (`OIDArticulo`),
  CONSTRAINT `listapreciodetalle_ibfk_2` FOREIGN KEY (`OIDListaPrecio`) REFERENCES `listaprecio` (`OIDListaPrecio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listapreciodetalle`
--

LOCK TABLES `listapreciodetalle` WRITE;
/*!40000 ALTER TABLE `listapreciodetalle` DISABLE KEYS */;
INSERT INTO `listapreciodetalle` VALUES ('1','1','1',30,1),('2','2','2',25,2),('3','3','3',43,3),('4','4','4',20,4);
/*!40000 ALTER TABLE `listapreciodetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `OIDMarca` varchar(40) NOT NULL,
  `codigoMarca` varchar(40) NOT NULL,
  `nombreMarca` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES ('1','1','Ayudin'),('2','2','Magistral'),('3','3','El Remanzo');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numerador`
--

DROP TABLE IF EXISTS `numerador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numerador` (
  `OIDNumerador` varchar(40) NOT NULL,
  `codigoCOT` int(40) NOT NULL,
  `ultimoNumeroCOT` int(30) NOT NULL,
  PRIMARY KEY (`OIDNumerador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numerador`
--

LOCK TABLES `numerador` WRITE;
/*!40000 ALTER TABLE `numerador` DISABLE KEYS */;
INSERT INTO `numerador` VALUES ('hgfjshdsfhjs',1,4);
/*!40000 ALTER TABLE `numerador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro` (
  `codigoParametro` varchar(40) NOT NULL,
  `descripcionParametro` varchar(40) NOT NULL,
  `valorParametro` varchar(40) NOT NULL,
  PRIMARY KEY (`codigoParametro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
INSERT INTO `parametro` VALUES ('1','SistemaVentas','Tango'),('2','SistemaVentas','Sion7'),('3','ProtocoloMail','SMTP'),('4','ProtocoloMail','MAPI');
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `OIDPedido` varchar(40) NOT NULL,
  `numPedido` int(20) NOT NULL,
  `fechaPedido` date DEFAULT NULL,
  `fechaVencimientoPedido` date DEFAULT NULL,
  `OIDProveedor` varchar(40) DEFAULT NULL,
  `OIDReposicion` varchar(40) DEFAULT NULL,
  `OIDCotizacion` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`OIDPedido`),
  KEY `OIDCotizacion` (`OIDCotizacion`),
  KEY `OIDReposicion` (`OIDReposicion`),
  KEY `OIDProveedor` (`OIDProveedor`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`OIDCotizacion`) REFERENCES `cotizacion` (`OIDCotizacion`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`OIDReposicion`) REFERENCES `reposicion` (`OIDReposicion`),
  CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`OIDProveedor`) REFERENCES `proveedor` (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES ('1',1,'2016-04-19','2016-05-19','1','1','1'),('2',2,'2016-05-02','2016-06-02','2','2','2'),('3',3,'2016-05-04','2016-07-04','1','2','2');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidodetalle`
--

DROP TABLE IF EXISTS `pedidodetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidodetalle` (
  `OIDPedidoDetalle` varchar(40) NOT NULL,
  `renglonPedido` int(20) NOT NULL,
  `OIDPedido` varchar(40) DEFAULT NULL,
  `OIDArticulo` varchar(40) DEFAULT NULL,
  `OIDCotizacionDetalle` varchar(40) DEFAULT NULL,
  `cantidadPedido` int(20) NOT NULL,
  PRIMARY KEY (`OIDPedidoDetalle`),
  KEY `OIDPedido` (`OIDPedido`),
  KEY `OIDArticulo` (`OIDArticulo`),
  KEY `OIDCotizacionDetalle` (`OIDCotizacionDetalle`),
  CONSTRAINT `pedidodetalle_ibfk_1` FOREIGN KEY (`OIDPedido`) REFERENCES `pedido` (`OIDPedido`),
  CONSTRAINT `pedidodetalle_ibfk_2` FOREIGN KEY (`OIDArticulo`) REFERENCES `articulo` (`OIDArticulo`),
  CONSTRAINT `pedidodetalle_ibfk_3` FOREIGN KEY (`OIDCotizacionDetalle`) REFERENCES `cotizaciondetalle` (`OIDCotizacionDetalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidodetalle`
--

LOCK TABLES `pedidodetalle` WRITE;
/*!40000 ALTER TABLE `pedidodetalle` DISABLE KEYS */;
INSERT INTO `pedidodetalle` VALUES ('1',1,'1','1','1',20),('2',2,'2','2','2',25),('3',3,'1','1','3',30),('4',4,'1','3','4',35);
/*!40000 ALTER TABLE `pedidodetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidoestado`
--

DROP TABLE IF EXISTS `pedidoestado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidoestado` (
  `OIDPedidoEstado` varchar(40) NOT NULL,
  `OIDPedido` varchar(40) DEFAULT NULL,
  `OIDEstadoPedido` varchar(40) DEFAULT NULL,
  `fechaDesdePedidoEstado` date DEFAULT NULL,
  `fechaHastaPedidoEstado` date DEFAULT NULL,
  PRIMARY KEY (`OIDPedidoEstado`),
  KEY `OIDPedido` (`OIDPedido`),
  KEY `OIDEstadoPedido` (`OIDEstadoPedido`),
  CONSTRAINT `pedidoestado_ibfk_1` FOREIGN KEY (`OIDPedido`) REFERENCES `pedido` (`OIDPedido`),
  CONSTRAINT `pedidoestado_ibfk_2` FOREIGN KEY (`OIDEstadoPedido`) REFERENCES `estadopedido` (`OIDEstadoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidoestado`
--

LOCK TABLES `pedidoestado` WRITE;
/*!40000 ALTER TABLE `pedidoestado` DISABLE KEYS */;
INSERT INTO `pedidoestado` VALUES ('1','1','1','2016-04-03',NULL),('2','1','1','2016-04-13','2016-04-20'),('3','1','1','2016-04-23','2016-04-30'),('4','1','1','2016-04-30','2016-05-05');
/*!40000 ALTER TABLE `pedidoestado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `OIDProveedor` varchar(40) NOT NULL,
  `codigoProveedor` varchar(40) NOT NULL,
  `nombreProveedor` varchar(45) NOT NULL,
  `cuitProveedor` int(15) NOT NULL,
  `emailProveedor` varchar(45) NOT NULL,
  `estadoProveedor` tinyint(1) NOT NULL,
  `OIDSistemaProveedor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OIDProveedor`),
  KEY `OIDSistemaProveedor` (`OIDSistemaProveedor`),
  CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`OIDSistemaProveedor`) REFERENCES `sistemaproveedor` (`OIDSistemaProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('1','A1','ProveedorA',2147483647,'gustavolemos089@gmail.com',1,'1'),('2','A2','ProveedorB',2147483647,'dragonevil8@gmail.com',1,'1'),('3','A3','ProveedorC',2147483647,'dragonevil8@hotmail.com',0,'1'),('4','A4','ProveedorD',2147483647,'dragonevil8@gmail.com',1,'2');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reposicion`
--

DROP TABLE IF EXISTS `reposicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reposicion` (
  `OIDReposicion` varchar(40) NOT NULL,
  `numReposicion` int(20) NOT NULL,
  `fechaReposicion` date NOT NULL,
  `OIDEstadoReposicion` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`OIDReposicion`),
  KEY `OIDEstadoReposicion` (`OIDEstadoReposicion`),
  CONSTRAINT `reposicion_ibfk_1` FOREIGN KEY (`OIDEstadoReposicion`) REFERENCES `estadoreposicion` (`OIDEstadoReposicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reposicion`
--

LOCK TABLES `reposicion` WRITE;
/*!40000 ALTER TABLE `reposicion` DISABLE KEYS */;
INSERT INTO `reposicion` VALUES ('1',1,'2016-03-02','5'),('2',2,'2016-03-03','5');
/*!40000 ALTER TABLE `reposicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reposiciondetalle`
--

DROP TABLE IF EXISTS `reposiciondetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reposiciondetalle` (
  `OIDReposicionDetalle` varchar(40) NOT NULL,
  `OIDReposicion` varchar(40) DEFAULT NULL,
  `OIDArticulo` varchar(40) DEFAULT NULL,
  `renglonReposicion` int(20) NOT NULL,
  `cantidadAReponer` int(20) NOT NULL,
  PRIMARY KEY (`OIDReposicionDetalle`),
  KEY `OIDArticulo` (`OIDArticulo`),
  KEY `OIDReposicion` (`OIDReposicion`),
  CONSTRAINT `reposiciondetalle_ibfk_1` FOREIGN KEY (`OIDArticulo`) REFERENCES `articulo` (`OIDArticulo`),
  CONSTRAINT `reposiciondetalle_ibfk_2` FOREIGN KEY (`OIDReposicion`) REFERENCES `reposicion` (`OIDReposicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reposiciondetalle`
--

LOCK TABLES `reposiciondetalle` WRITE;
/*!40000 ALTER TABLE `reposiciondetalle` DISABLE KEYS */;
INSERT INTO `reposiciondetalle` VALUES ('1','1','1',1,25),('2','1','2',2,50),('3','1','3',3,55),('4','1','4',4,20),('5','2','5',5,34),('6','2','2',6,333);
/*!40000 ALTER TABLE `reposiciondetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sistemaproveedor`
--

DROP TABLE IF EXISTS `sistemaproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistemaproveedor` (
  `OIDSistemaProveedor` varchar(40) NOT NULL,
  `nombreSistemaProveedor` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDSistemaProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sistemaproveedor`
--

LOCK TABLES `sistemaproveedor` WRITE;
/*!40000 ALTER TABLE `sistemaproveedor` DISABLE KEYS */;
INSERT INTO `sistemaproveedor` VALUES ('1','Tango'),('2','Sion7');
/*!40000 ALTER TABLE `sistemaproveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproducto`
--

DROP TABLE IF EXISTS `tipoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoproducto` (
  `OIDTipoProducto` varchar(40) NOT NULL,
  `codigoTipo` varchar(40) NOT NULL,
  `nombreTipo` varchar(45) NOT NULL,
  `toxico` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDTipoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproducto`
--

LOCK TABLES `tipoproducto` WRITE;
/*!40000 ALTER TABLE `tipoproducto` DISABLE KEYS */;
INSERT INTO `tipoproducto` VALUES ('1','1','Lampazo','true'),('2','2','Balde','false'),('3','3','Brillapiso','true');
/*!40000 ALTER TABLE `tipoproducto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-15 15:36:23
