/*
SQLyog Ultimate v11.33 (32 bit)
MySQL - 5.7.7-rc-log : Database - sinapsissindatos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sinapsissindatos` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sinapsissindatos`;

/*Table structure for table `articulo` */

DROP TABLE IF EXISTS `articulo`;

CREATE TABLE `articulo` (
  `OIDArticulo` varchar(40) NOT NULL,
  `codigoArticulo` varchar(40) NOT NULL,
  `nombreArticulo` varchar(45) NOT NULL,
  `stockArticulo` int(20) NOT NULL,
  `OIDTipoProducto` varchar(40) NOT NULL,
  `OIDMarca` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDArticulo`),
  KEY `OIDTipoProducto` (`OIDTipoProducto`),
  KEY `OIDMarca` (`OIDMarca`),
  CONSTRAINT `articulo_ibfk_1` FOREIGN KEY (`OIDTipoProducto`) REFERENCES `tipoproducto` (`OIDTipoProducto`),
  CONSTRAINT `articulo_ibfk_2` FOREIGN KEY (`OIDMarca`) REFERENCES `marca` (`OIDMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `articulo` */

LOCK TABLES `articulo` WRITE;

UNLOCK TABLES;

/*Table structure for table `articuloproveedor` */

DROP TABLE IF EXISTS `articuloproveedor`;

CREATE TABLE `articuloproveedor` (
  `OIDArticuloProveedor` varchar(40) NOT NULL,
  `codigoExterno` varchar(40) NOT NULL,
  `OIDArticulo` varchar(40) NOT NULL,
  `OIDProveedor` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDArticuloProveedor`),
  KEY `OIDArticulo` (`OIDArticulo`),
  KEY `OIDProveedor` (`OIDProveedor`),
  CONSTRAINT `articuloproveedor_ibfk_1` FOREIGN KEY (`OIDArticulo`) REFERENCES `articulo` (`OIDArticulo`),
  CONSTRAINT `articuloproveedor_ibfk_2` FOREIGN KEY (`OIDProveedor`) REFERENCES `proveedor` (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `articuloproveedor` */

LOCK TABLES `articuloproveedor` WRITE;

UNLOCK TABLES;

/*Table structure for table `cotizacion` */

DROP TABLE IF EXISTS `cotizacion`;

CREATE TABLE `cotizacion` (
  `OIDCotizacion` varchar(40) NOT NULL,
  `numCotizacion` int(20) NOT NULL,
  `fechaCotizacion` date NOT NULL,
  `fechaEntregaCotizacion` date NOT NULL,
  `fechaVencimientoCotizacion` date NOT NULL,
  `horaEntregaCotizacion` time NOT NULL,
  `OIDReposicion` varchar(40) NOT NULL,
  `OIDProveedor` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDCotizacion`),
  KEY `OIDReposicion` (`OIDReposicion`),
  KEY `OIDProveedor` (`OIDProveedor`),
  CONSTRAINT `cotizacion_ibfk_1` FOREIGN KEY (`OIDReposicion`) REFERENCES `reposicion` (`OIDReposicion`),
  CONSTRAINT `cotizacion_ibfk_2` FOREIGN KEY (`OIDProveedor`) REFERENCES `proveedor` (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cotizacion` */

LOCK TABLES `cotizacion` WRITE;

UNLOCK TABLES;

/*Table structure for table `cotizaciondetalle` */

DROP TABLE IF EXISTS `cotizaciondetalle`;

CREATE TABLE `cotizaciondetalle` (
  `OIDCotizacionDetalle` varchar(40) NOT NULL,
  `OIDEstadoCotizacionDetalle` varchar(40) NOT NULL,
  `OIDCotizacion` varchar(40) NOT NULL,
  `OIDArticuloProveedor` varchar(40) NOT NULL,
  `OIDReposicionDetalle` varchar(40) NOT NULL,
  `renglonCotizacion` int(20) NOT NULL,
  `cantidadAPedirCotizacion` int(20) NOT NULL,
  `cantidadCotizada` int(20) NOT NULL,
  `precioArticuloLista` float NOT NULL,
  `precioCotizacion` double NOT NULL,
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

/*Data for the table `cotizaciondetalle` */

LOCK TABLES `cotizaciondetalle` WRITE;

UNLOCK TABLES;

/*Table structure for table `estadocotizaciondetalle` */

DROP TABLE IF EXISTS `estadocotizaciondetalle`;

CREATE TABLE `estadocotizaciondetalle` (
  `OIDEstadoCotizacionDetalle` varchar(40) NOT NULL,
  `codigoEstadoCotizacionDetalle` varchar(40) NOT NULL,
  `nombreEstadoCotizacionDetalle` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoCotizacionDetalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estadocotizaciondetalle` */

LOCK TABLES `estadocotizaciondetalle` WRITE;

UNLOCK TABLES;

/*Table structure for table `estadopedido` */

DROP TABLE IF EXISTS `estadopedido`;

CREATE TABLE `estadopedido` (
  `OIDEstadoPedido` varchar(40) NOT NULL,
  `codigoEstadoPedido` int(20) NOT NULL,
  `nombreEstadoPedido` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estadopedido` */

LOCK TABLES `estadopedido` WRITE;

UNLOCK TABLES;

/*Table structure for table `estadoreposicion` */

DROP TABLE IF EXISTS `estadoreposicion`;

CREATE TABLE `estadoreposicion` (
  `OIDEstadoReposicion` varchar(40) NOT NULL,
  `codigoEstadoReposicion` int(20) NOT NULL,
  `nombreEstadoReposicion` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoReposicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estadoreposicion` */

LOCK TABLES `estadoreposicion` WRITE;

UNLOCK TABLES;

/*Table structure for table `listaprecio` */

DROP TABLE IF EXISTS `listaprecio`;

CREATE TABLE `listaprecio` (
  `OIDListaPrecio` varchar(40) NOT NULL,
  `numListaPrecio` int(20) NOT NULL,
  `vigente` tinyint(1) NOT NULL,
  `OIDProveedor` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDListaPrecio`),
  KEY `OIDProveedor` (`OIDProveedor`),
  CONSTRAINT `listaprecio_ibfk_1` FOREIGN KEY (`OIDProveedor`) REFERENCES `proveedor` (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `listaprecio` */

LOCK TABLES `listaprecio` WRITE;

UNLOCK TABLES;

/*Table structure for table `listapreciodetalle` */

DROP TABLE IF EXISTS `listapreciodetalle`;

CREATE TABLE `listapreciodetalle` (
  `OIDListaPrecioDetalle` varchar(40) NOT NULL,
  `OIDArticulo` varchar(40) NOT NULL,
  `OIDListaPrecio` varchar(40) NOT NULL,
  `precioArticulo` float NOT NULL,
  `renglonLista` int(20) NOT NULL,
  PRIMARY KEY (`OIDListaPrecioDetalle`),
  KEY `OIDArticulo` (`OIDArticulo`),
  KEY `OIDListaPrecio` (`OIDListaPrecio`),
  CONSTRAINT `listapreciodetalle_ibfk_1` FOREIGN KEY (`OIDArticulo`) REFERENCES `articulo` (`OIDArticulo`),
  CONSTRAINT `listapreciodetalle_ibfk_2` FOREIGN KEY (`OIDListaPrecio`) REFERENCES `listaprecio` (`OIDListaPrecio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `listapreciodetalle` */

LOCK TABLES `listapreciodetalle` WRITE;

UNLOCK TABLES;

/*Table structure for table `marca` */

DROP TABLE IF EXISTS `marca`;

CREATE TABLE `marca` (
  `OIDMarca` varchar(40) NOT NULL,
  `codigoMarca` varchar(40) NOT NULL,
  `nombreMarca` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `marca` */

LOCK TABLES `marca` WRITE;

UNLOCK TABLES;

/*Table structure for table `parametro` */

DROP TABLE IF EXISTS `parametro`;

CREATE TABLE `parametro` (
  `codigoParametro` varchar(40) NOT NULL,
  `descripcionParametro` varchar(40) NOT NULL,
  `valorParametro` varchar(40) NOT NULL,
  PRIMARY KEY (`codigoParametro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `parametro` */

LOCK TABLES `parametro` WRITE;

UNLOCK TABLES;

/*Table structure for table `pedido` */

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `OIDPedido` varchar(40) NOT NULL,
  `numPedido` int(20) NOT NULL,
  `fechaPedido` date NOT NULL,
  `fechaVencimientoPedido` date NOT NULL,
  `OIDProveedor` varchar(40) NOT NULL,
  `OIDReposicion` varchar(40) NOT NULL,
  `OIDCotizacion` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDPedido`),
  KEY `OIDCotizacion` (`OIDCotizacion`),
  KEY `OIDReposicion` (`OIDReposicion`),
  KEY `OIDProveedor` (`OIDProveedor`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`OIDCotizacion`) REFERENCES `cotizacion` (`OIDCotizacion`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`OIDReposicion`) REFERENCES `reposicion` (`OIDReposicion`),
  CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`OIDProveedor`) REFERENCES `proveedor` (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pedido` */

LOCK TABLES `pedido` WRITE;

UNLOCK TABLES;

/*Table structure for table `pedidodetalle` */

DROP TABLE IF EXISTS `pedidodetalle`;

CREATE TABLE `pedidodetalle` (
  `OIDPedidoDetalle` varchar(40) NOT NULL,
  `renglonPedido` int(20) NOT NULL,
  `OIDPedido` varchar(40) NOT NULL,
  `OIDArticulo` varchar(40) NOT NULL,
  `OIDCotizacionDetalle` varchar(40) NOT NULL,
  `cantidadPedido` int(20) NOT NULL,
  PRIMARY KEY (`OIDPedidoDetalle`),
  KEY `OIDPedido` (`OIDPedido`),
  KEY `OIDArticulo` (`OIDArticulo`),
  KEY `OIDCotizacionDetalle` (`OIDCotizacionDetalle`),
  CONSTRAINT `pedidodetalle_ibfk_1` FOREIGN KEY (`OIDPedido`) REFERENCES `pedido` (`OIDPedido`),
  CONSTRAINT `pedidodetalle_ibfk_2` FOREIGN KEY (`OIDArticulo`) REFERENCES `articulo` (`OIDArticulo`),
  CONSTRAINT `pedidodetalle_ibfk_3` FOREIGN KEY (`OIDCotizacionDetalle`) REFERENCES `cotizaciondetalle` (`OIDCotizacionDetalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pedidodetalle` */

LOCK TABLES `pedidodetalle` WRITE;

UNLOCK TABLES;

/*Table structure for table `pedidoestado` */

DROP TABLE IF EXISTS `pedidoestado`;

CREATE TABLE `pedidoestado` (
  `OIDPedidoEstado` varchar(40) NOT NULL,
  `OIDPedido` varchar(40) NOT NULL,
  `OIDEstadoPedido` varchar(40) NOT NULL,
  `fechaDesdePedidoEstado` date DEFAULT NULL,
  `fechaHastaPedidoEstado` date DEFAULT NULL,
  PRIMARY KEY (`OIDPedidoEstado`),
  KEY `OIDPedido` (`OIDPedido`),
  KEY `OIDEstadoPedido` (`OIDEstadoPedido`),
  CONSTRAINT `pedidoestado_ibfk_1` FOREIGN KEY (`OIDPedido`) REFERENCES `pedido` (`OIDPedido`),
  CONSTRAINT `pedidoestado_ibfk_2` FOREIGN KEY (`OIDEstadoPedido`) REFERENCES `estadopedido` (`OIDEstadoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pedidoestado` */

LOCK TABLES `pedidoestado` WRITE;

UNLOCK TABLES;

/*Table structure for table `proveedor` */

DROP TABLE IF EXISTS `proveedor`;

CREATE TABLE `proveedor` (
  `OIDProveedor` varchar(40) NOT NULL,
  `codigoProveedor` varchar(40) NOT NULL,
  `nombreProveedor` varchar(45) NOT NULL,
  `cuitProveedor` int(15) NOT NULL,
  `emailProveedor` varchar(45) NOT NULL,
  `estadoProveedor` tinyint(1) NOT NULL,
  `OIDSistemaProveedor` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDProveedor`),
  KEY `OIDSistemaProveedor` (`OIDSistemaProveedor`),
  CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`OIDSistemaProveedor`) REFERENCES `sistemaproveedor` (`OIDSistemaProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `proveedor` */

LOCK TABLES `proveedor` WRITE;

UNLOCK TABLES;

/*Table structure for table `reposicion` */

DROP TABLE IF EXISTS `reposicion`;

CREATE TABLE `reposicion` (
  `OIDReposicion` varchar(40) NOT NULL,
  `numReposicion` int(20) NOT NULL,
  `fechaReposicion` date NOT NULL,
  `OIDEstadoReposicion` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDReposicion`),
  KEY `OIDEstadoReposicion` (`OIDEstadoReposicion`),
  CONSTRAINT `reposicion_ibfk_1` FOREIGN KEY (`OIDEstadoReposicion`) REFERENCES `estadoreposicion` (`OIDEstadoReposicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reposicion` */

LOCK TABLES `reposicion` WRITE;

UNLOCK TABLES;

/*Table structure for table `reposiciondetalle` */

DROP TABLE IF EXISTS `reposiciondetalle`;

CREATE TABLE `reposiciondetalle` (
  `OIDReposicionDetalle` varchar(40) NOT NULL,
  `OIDReposicion` varchar(40) NOT NULL,
  `OIDArticulo` varchar(40) NOT NULL,
  `renglonReposicion` int(20) NOT NULL,
  `cantidadAReponer` int(20) NOT NULL,
  PRIMARY KEY (`OIDReposicionDetalle`),
  KEY `OIDArticulo` (`OIDArticulo`),
  KEY `OIDReposicion` (`OIDReposicion`),
  CONSTRAINT `reposiciondetalle_ibfk_1` FOREIGN KEY (`OIDArticulo`) REFERENCES `articulo` (`OIDArticulo`),
  CONSTRAINT `reposiciondetalle_ibfk_2` FOREIGN KEY (`OIDReposicion`) REFERENCES `reposicion` (`OIDReposicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reposiciondetalle` */

LOCK TABLES `reposiciondetalle` WRITE;

UNLOCK TABLES;

/*Table structure for table `sistemaproveedor` */

DROP TABLE IF EXISTS `sistemaproveedor`;

CREATE TABLE `sistemaproveedor` (
  `OIDSistemaProveedor` varchar(40) NOT NULL,
  `nombreSistemaProveedor` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDSistemaProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sistemaproveedor` */

LOCK TABLES `sistemaproveedor` WRITE;

UNLOCK TABLES;

/*Table structure for table `tipoproducto` */

DROP TABLE IF EXISTS `tipoproducto`;

CREATE TABLE `tipoproducto` (
  `OIDTipoProducto` varchar(40) NOT NULL,
  `codigoTipo` varchar(40) NOT NULL,
  `nombreTipo` varchar(45) NOT NULL,
  `toxico` varchar(40) NOT NULL,
  PRIMARY KEY (`OIDTipoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tipoproducto` */

LOCK TABLES `tipoproducto` WRITE;

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
