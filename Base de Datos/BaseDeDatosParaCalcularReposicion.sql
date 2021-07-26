/*
SQLyog Ultimate v11.33 (32 bit)
MySQL - 5.7.7-rc-log : Database - sinapsis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`BaseDeDatosParaCalcularReposicion` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `BaseDeDatosParaCalcularReposicion`;

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

insert  into `articulo`(`OIDArticulo`,`codigoArticulo`,`nombreArticulo`,`stockArticulo`,`OIDTipoProducto`,`OIDMarca`) values ('1','1','Lavandina Ayudín GEL 500 cc',30,'1','1'),('2','2','Lavandina Ayudín Lavanda 500 cc',25,'2','2'),('3','3','Detergente Magistral Limón 1000 cc',10,'3','3'),('4','4','Detergente Magistral Aloe 1000 cc',50,'1','1');

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

insert  into `articuloproveedor`(`OIDArticuloProveedor`,`codigoExterno`,`OIDArticulo`,`OIDProveedor`) values ('1','B-0456','1','1'),('2','R-0483','2','2'),('3','R-0443','1','2');

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

insert  into `cotizacion`(`OIDCotizacion`,`numCotizacion`,`fechaCotizacion`,`fechaEntregaCotizacion`,`fechaVencimientoCotizacion`,`horaEntregaCotizacion`,`OIDReposicion`,`OIDProveedor`) values ('1',1,'2016-05-12','2016-05-12','2016-05-19','16:00:00','1','1'),('2',2,'2016-05-12','2016-10-01','2016-10-19','17:00:00','2','2'),('3',3,'2016-05-12','2016-05-14','2016-05-19','17:00:00','2','3'),('4',4,'2016-05-17','2016-05-17','2016-05-19','18:00:00','4','4');

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

insert  into `cotizaciondetalle`(`OIDCotizacionDetalle`,`OIDEstadoCotizacionDetalle`,`OIDCotizacion`,`OIDArticuloProveedor`,`OIDReposicionDetalle`,`renglonCotizacion`,`cantidadAPedirCotizacion`,`cantidadCotizada`,`precioArticuloLista`,`precioCotizacion`) values ('1','2','3','1','1',1,120,100,20,20),('2','1','2','1','2',2,555,555,22,19),('3','1','2','2','3',3,666,666,25,18),('4','1','1','2','4',4,70,60,25,13);

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

insert  into `estadocotizaciondetalle`(`OIDEstadoCotizacionDetalle`,`codigoEstadoCotizacionDetalle`,`nombreEstadoCotizacionDetalle`) values ('1','1','Creada'),('2','2','Cargada'),('3','3','Descartada'),('4','4','Seleccionada'),('5','5','Vencida'),('6','6','No seleccionada');

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

insert  into `estadopedido`(`OIDEstadoPedido`,`codigoEstadoPedido`,`nombreEstadoPedido`) values ('1',1,'En Curso'),('2',2,'Recepcionado'),('3',3,'Rechazado Pendiente de Entrega'),('4',4,'Rechazado');

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

insert  into `estadoreposicion`(`OIDEstadoReposicion`,`codigoEstadoReposicion`,`nombreEstadoReposicion`) values ('1',1,'Calculada'),('2',2,'Pendiente a Cotizar'),('3',3,'Notificada'),('4',4,'Atendida'),('5',5,'Atendida Pendiente de Recepcion');

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

insert  into `listaprecio`(`OIDListaPrecio`,`numListaPrecio`,`vigente`,`OIDProveedor`) values ('1',1,0,'1'),('2',2,1,'2'),('3',3,1,'3'),('4',4,1,'4');

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

insert  into `listapreciodetalle`(`OIDListaPrecioDetalle`,`OIDArticulo`,`OIDListaPrecio`,`precioArticulo`,`renglonLista`) values ('1','1','1',30,1),('2','2','2',25,2),('3','3','3',43,3),('4','4','4',20,4);

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

insert  into `marca`(`OIDMarca`,`codigoMarca`,`nombreMarca`) values ('1','1','Ayudin'),('2','2','Magistral'),('3','3','El Remanzo');

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

insert  into `pedido`(`OIDPedido`,`numPedido`,`fechaPedido`,`fechaVencimientoPedido`,`OIDProveedor`,`OIDReposicion`,`OIDCotizacion`) values ('1',1,'2016-04-19','2016-05-19','1','1','1'),('2',2,'2016-05-02','2016-06-02','2','2','2'),('3',3,'2016-05-04','2016-07-04','1','2','2');

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

insert  into `pedidodetalle`(`OIDPedidoDetalle`,`renglonPedido`,`OIDPedido`,`OIDArticulo`,`OIDCotizacionDetalle`,`cantidadPedido`) values ('1',1,'1','1','1',20),('2',2,'2','2','2',25),('3',3,'1','1','3',30),('4',4,'1','3','4',35);

UNLOCK TABLES;

/*Table structure for table `pedidoestado` */

DROP TABLE IF EXISTS `pedidoestado`;

CREATE TABLE `pedidoestado` (
  `OIDPedidoEstado` varchar(40) NOT NULL,
  `OIDPedido` varchar(40) NOT NULL,
  `OIDEstadoPedido` varchar(40) NOT NULL,
  `fechaDesdePedidoEstado` date NOT NULL,
  `fechaHastaPedidoEstado` date NOT NULL,
  PRIMARY KEY (`OIDPedidoEstado`),
  KEY `OIDPedido` (`OIDPedido`),
  KEY `OIDEstadoPedido` (`OIDEstadoPedido`),
  CONSTRAINT `pedidoestado_ibfk_1` FOREIGN KEY (`OIDPedido`) REFERENCES `pedido` (`OIDPedido`),
  CONSTRAINT `pedidoestado_ibfk_2` FOREIGN KEY (`OIDEstadoPedido`) REFERENCES `estadopedido` (`OIDEstadoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pedidoestado` */

LOCK TABLES `pedidoestado` WRITE;

insert  into `pedidoestado`(`OIDPedidoEstado`,`OIDPedido`,`OIDEstadoPedido`,`fechaDesdePedidoEstado`,`fechaHastaPedidoEstado`) values ('1','1','1','2016-04-03','2016-04-10'),('2','1','1','2016-04-13','2016-04-20'),('3','1','1','2016-04-23','2016-04-30'),('4','1','1','2016-04-30','2016-05-05');

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
  `sistemaProveedor` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `proveedor` */

LOCK TABLES `proveedor` WRITE;

insert  into `proveedor`(`OIDProveedor`,`codigoProveedor`,`nombreProveedor`,`cuitProveedor`,`emailProveedor`,`estadoProveedor`,`sistemaProveedor`) values ('1','A1','ProveedorA',2147483647,'proveedorA@gmail.com',1,'Sistema Tango'),('2','A2','ProveedorB',2147483647,'proveedorB@gmail.com',1,'Sistema Tango'),('3','A3','ProveedorC',2147483647,'proveedorC@gmail.com',0,'Sistema Tango'),('4','A4','ProveedorD',2147483647,'porveedorD@gmail.com',1,'Sistema Sion7');

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

insert  into `reposicion`(`OIDReposicion`,`numReposicion`,`fechaReposicion`,`OIDEstadoReposicion`) values ('1',1,'2016-03-02','1'),('2',2,'2016-03-03','2'),('3',3,'2016-03-03','4'),('4',4,'2016-03-04','4');

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

insert  into `reposiciondetalle`(`OIDReposicionDetalle`,`OIDReposicion`,`OIDArticulo`,`renglonReposicion`,`cantidadAReponer`) values ('1','1','1',1,25),('2','1','1',2,50),('3','1','1',3,55),('4','1','1',4,20);

UNLOCK TABLES;

/*Table structure for table `tipoproducto` */

DROP TABLE IF EXISTS `tipoproducto`;

CREATE TABLE `tipoproducto` (
  `OIDTipoProducto` varchar(40) NOT NULL,
  `codigoTipo` varchar(40) NOT NULL,
  `nombreTipo` varchar(45) NOT NULL,
  PRIMARY KEY (`OIDTipoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tipoproducto` */

LOCK TABLES `tipoproducto` WRITE;

insert  into `tipoproducto`(`OIDTipoProducto`,`codigoTipo`,`nombreTipo`) values ('1','1','Lampazo'),('2','2','Balde'),('3','3','Brillapiso');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
