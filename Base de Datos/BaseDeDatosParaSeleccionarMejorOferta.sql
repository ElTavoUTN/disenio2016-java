/*
SQLyog Ultimate v9.02 
MySQL - 5.7.14-log : Database - sinapsis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sinapsis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sinapsis`;

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

insert  into `articulo`(`OIDArticulo`,`codigoArticulo`,`nombreArticulo`,`stockArticulo`,`OIDTipoProducto`,`OIDMarca`) values ('1584','ASXV999','Lampazo',30,'2','2'),('2','PNDS225','Balde ',58,'2','2'),('3','PSNC711','Rejillas',26,'5','4'),('4','MNGA428','Detergente 1L',54,'1','4'),('8794','WNBD885','Lavandina 1L',32,'1','1');

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

insert  into `articuloproveedor`(`OIDArticuloProveedor`,`codigoExterno`,`OIDArticulo`,`OIDProveedor`) values ('1','546','2','1'),('2','568','3','1'),('3','779','4','1'),('4','232','2','2'),('5','745','3','2'),('6','255','4','2'),('7','897','1584','1'),('8','621','1584','2');

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

insert  into `cotizacion`(`OIDCotizacion`,`numCotizacion`,`fechaCotizacion`,`fechaEntregaCotizacion`,`fechaVencimientoCotizacion`,`horaEntregaCotizacion`,`OIDReposicion`,`OIDProveedor`) values ('1',784,'2016-04-03','2016-04-10','2016-04-12','23:52:38','1','1'),('2',952,'2016-04-03','2016-04-10','2016-04-12','21:23:06','1','2'),('3215',217,'2016-02-26','2016-03-04','2016-03-05','10:48:16','50','1'),('3568',658,'2016-02-26','2016-03-01','2016-03-05','20:36:41','50','2'),('485',451,'2015-11-14','2015-11-16','2015-11-23','11:37:49','25','1'),('537',371,'2015-11-14','2015-11-17','2015-11-23','08:13:26','25','2');

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

insert  into `cotizaciondetalle`(`OIDCotizacionDetalle`,`OIDEstadoCotizacionDetalle`,`OIDCotizacion`,`OIDArticuloProveedor`,`OIDReposicionDetalle`,`renglonCotizacion`,`cantidadAPedirCotizacion`,`cantidadCotizada`,`precioArticuloLista`,`precioCotizacion`) values ('1','4','1','1','1',1,15,15,15,12),('10','5','485','3','36',1,20,20,20,18),('11','6','485','7','35',2,10,10,25,20),('12','6','537','6','36',1,20,20,22,21),('13','5','537','8','35',2,10,10,20,15),('2','4','1','2','2',2,20,20,20,16),('3','4','1','3','3',3,30,30,25,20),('4','4','2','4','1',1,15,15,20,15),('5','4','2','5','2',2,20,20,18,14),('6','4','2','6','3',3,30,30,24,22),('70','6','3215','3','41',1,32,32,25,24),('71','6','3215','7','40',2,25,25,30,25),('72','5','3568','6','41',1,32,32,25,20),('73','5','3568','8','40',2,25,25,25,22);

/*Table structure for table `estadocotizaciondetalle` */

DROP TABLE IF EXISTS `estadocotizaciondetalle`;

CREATE TABLE `estadocotizaciondetalle` (
  `OIDEstadoCotizacionDetalle` varchar(40) NOT NULL,
  `codigoEstadoCotizacionDetalle` varchar(40) NOT NULL,
  `nombreEstadoCotizacionDetalle` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoCotizacionDetalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estadocotizaciondetalle` */

insert  into `estadocotizaciondetalle`(`OIDEstadoCotizacionDetalle`,`codigoEstadoCotizacionDetalle`,`nombreEstadoCotizacionDetalle`) values ('1','452','Creada'),('2','221','Vencida'),('3','778','Descartada'),('4','335','Cargada'),('5','466','Seleccionada'),('6','551','No Seleccionada');

/*Table structure for table `estadopedido` */

DROP TABLE IF EXISTS `estadopedido`;

CREATE TABLE `estadopedido` (
  `OIDEstadoPedido` varchar(40) NOT NULL,
  `codigoEstadoPedido` int(20) NOT NULL,
  `nombreEstadoPedido` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estadopedido` */

insert  into `estadopedido`(`OIDEstadoPedido`,`codigoEstadoPedido`,`nombreEstadoPedido`) values ('1',118,'En Curso'),('2',522,'Rechazado Pendiente de Entrega'),('3',763,'Recepcionado'),('4',375,'Rechazado');

/*Table structure for table `estadoreposicion` */

DROP TABLE IF EXISTS `estadoreposicion`;

CREATE TABLE `estadoreposicion` (
  `OIDEstadoReposicion` varchar(40) NOT NULL,
  `codigoEstadoReposicion` int(20) NOT NULL,
  `nombreEstadoReposicion` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDEstadoReposicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estadoreposicion` */

insert  into `estadoreposicion`(`OIDEstadoReposicion`,`codigoEstadoReposicion`,`nombreEstadoReposicion`) values ('1',123,'Calculada'),('2',456,'Pediente a Cotizar'),('3',789,'Notificada'),('4',159,'Atendida'),('5',951,'Atendida Pendiente de Recepcion'),('6',741,'Finalizada');

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

/*Table structure for table `marca` */

DROP TABLE IF EXISTS `marca`;

CREATE TABLE `marca` (
  `OIDMarca` varchar(40) NOT NULL,
  `codigoMarca` varchar(40) NOT NULL,
  `nombreMarca` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `marca` */

insert  into `marca`(`OIDMarca`,`codigoMarca`,`nombreMarca`) values ('1','TRY789','Ayudin'),('2','BKP958','Mundo Plastico'),('3','CXZ378','Blen'),('4','SQW814','Cif');

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

insert  into `pedido`(`OIDPedido`,`numPedido`,`fechaPedido`,`fechaVencimientoPedido`,`OIDProveedor`,`OIDReposicion`,`OIDCotizacion`) values ('1',254,'2015-11-24','2015-12-09','1','25','485'),('2',268,'2015-11-24','2015-12-09','2','25','537'),('3',287,'2016-03-06','2016-03-21','2','50','3568');

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

insert  into `pedidodetalle`(`OIDPedidoDetalle`,`renglonPedido`,`OIDPedido`,`OIDArticulo`,`OIDCotizacionDetalle`,`cantidadPedido`) values ('1',1,'1','4','10',20),('2',1,'2','1584','13',10),('3',1,'3','4','72',32),('4',2,'3','1584','73',25);

/*Table structure for table `pedidoestado` */

DROP TABLE IF EXISTS `pedidoestado`;

CREATE TABLE `pedidoestado` (
  `OIDPedidoEstado` varchar(40) NOT NULL,
  `OIDPedido` varchar(40) NOT NULL,
  `OIDEstadoPedido` varchar(40) NOT NULL,
  `fechaDesdePedidoEstado` date NOT NULL,
  `fechaHastaPedidoEstado` date DEFAULT NULL,
  PRIMARY KEY (`OIDPedidoEstado`),
  KEY `OIDPedido` (`OIDPedido`),
  KEY `OIDEstadoPedido` (`OIDEstadoPedido`),
  CONSTRAINT `pedidoestado_ibfk_1` FOREIGN KEY (`OIDPedido`) REFERENCES `pedido` (`OIDPedido`),
  CONSTRAINT `pedidoestado_ibfk_2` FOREIGN KEY (`OIDEstadoPedido`) REFERENCES `estadopedido` (`OIDEstadoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pedidoestado` */

insert  into `pedidoestado`(`OIDPedidoEstado`,`OIDPedido`,`OIDEstadoPedido`,`fechaDesdePedidoEstado`,`fechaHastaPedidoEstado`) values ('1','1','1','2015-11-24','2015-12-05'),('2','2','1','2015-11-24','2015-11-30'),('3','2','3','2015-11-30',NULL),('4','1','3','2015-12-05',NULL),('5','3','1','2016-03-06','2016-03-10'),('6','3','2','2016-03-10','2016-03-17'),('7','3','3','2016-03-17',NULL);

/*Table structure for table `proveedor` */

DROP TABLE IF EXISTS `proveedor`;

CREATE TABLE `proveedor` (
  `OIDProveedor` varchar(40) NOT NULL,
  `codigoProveedor` varchar(40) NOT NULL,
  `nombreProveedor` varchar(45) NOT NULL,
  `cuitProveedor` int(15) NOT NULL,
  `emailProveedor` varchar(45) NOT NULL,
  `estadoProveedor` tinyint(1) NOT NULL,
  `sistemaProveedor` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `proveedor` */

insert  into `proveedor`(`OIDProveedor`,`codigoProveedor`,`nombreProveedor`,`cuitProveedor`,`emailProveedor`,`estadoProveedor`,`sistemaProveedor`) values ('1','856','ProveedorA',2147483647,'proveedorA@gmail.com',0,'mail'),('2','546','ProveedorB',21,'proveedorB@gmail.com',0,'mail');

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

insert  into `reposicion`(`OIDReposicion`,`numReposicion`,`fechaReposicion`,`OIDEstadoReposicion`) values ('1',299,'2016-04-02','4'),('2',365,'2016-04-16','1'),('25',156,'2015-11-13','6'),('50',312,'2016-02-25','6');

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

insert  into `reposiciondetalle`(`OIDReposicionDetalle`,`OIDReposicion`,`OIDArticulo`,`renglonReposicion`,`cantidadAReponer`) values ('1','1','2',1,15),('2','1','3',2,20),('3','1','4',3,30),('35','25','1584',1,10),('36','25','4',2,20),('4','2','2',1,10),('40','50','1584',1,25),('41','50','4',2,32),('5','2','3',2,25),('6','2','4',3,40);

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

insert  into `tipoproducto`(`OIDTipoProducto`,`codigoTipo`,`nombreTipo`,`toxico`) values ('1','ASW879','Cocina','true'),('2','POW254','General','false'),('3','LKM747','Mueble','false'),('4','CFT762','Baño','true'),('5','EHJ912','Cocina','false');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
