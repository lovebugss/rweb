/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.19 : Database - software
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`software` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `software`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `ID` varchar(64) NOT NULL,
  `ACTIVE_FLAG` int(11) DEFAULT '1',
  `CREATE_BY` varchar(64) NOT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_BY` varchar(64) DEFAULT NULL,
  `UPDATE_TIME` timestamp NULL DEFAULT NULL,
  `ORIGINAL` varchar(64) DEFAULT NULL,
  `TAGS` varchar(64) DEFAULT NULL,
  `DESCRIPTION` varchar(400) DEFAULT NULL,
  `ARTICLE_TITLE` varchar(200) DEFAULT NULL,
  `IMG_URL` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `article_content` */

DROP TABLE IF EXISTS `article_content`;

CREATE TABLE `article_content` (
  `id` varchar(64) DEFAULT NULL,
  `content` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `article_read_count` */

DROP TABLE IF EXISTS `article_read_count`;

CREATE TABLE `article_read_count` (
  `id` varchar(64) NOT NULL,
  `read_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
