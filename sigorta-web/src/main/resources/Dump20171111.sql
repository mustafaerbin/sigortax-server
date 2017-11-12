-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sigortax
-- ------------------------------------------------------
-- Server version	5.5.55-log

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
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
INSERT INTO `agency` VALUES (1,'2017-10-28 00:32:01',NULL,0,NULL,NULL,'Demo Sigorta',''),(2,NULL,NULL,0,NULL,NULL,'A Acentesi','');
/*!40000 ALTER TABLE `agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `agency_user`
--

LOCK TABLES `agency_user` WRITE;
/*!40000 ALTER TABLE `agency_user` DISABLE KEYS */;
INSERT INTO `agency_user` VALUES ('mustafaerbin@hotmail.com','2018-10-03 12:00:00',5433148674,1,1,''),(NULL,'2018-10-03 12:00:00',NULL,2,1,''),(NULL,'2018-10-03 12:00:00',NULL,3,1,NULL),(NULL,'2018-10-03 12:00:00',NULL,4,1,NULL);
/*!40000 ALTER TABLE `agency_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'2017-10-28 00:32:03',NULL,0,'Anadolu Sigorta',''),(2,'2017-10-28 00:32:03',NULL,0,'Ak Sigorta','');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_product`
--

LOCK TABLES `company_product` WRITE;
/*!40000 ALTER TABLE `company_product` DISABLE KEYS */;
INSERT INTO `company_product` VALUES (1,'2017-10-28 00:32:03',NULL,0,'Araç','',1),(2,'2017-10-28 00:32:03',NULL,0,'Konut Sigortası','',1);
/*!40000 ALTER TABLE `company_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_sub_product`
--

LOCK TABLES `company_sub_product` WRITE;
/*!40000 ALTER TABLE `company_sub_product` DISABLE KEYS */;
INSERT INTO `company_sub_product` VALUES (1,'2017-10-28 00:32:03',NULL,0,'Trafik Sigortası','',1),(2,'2017-10-28 00:32:03',NULL,0,'Tam Bakım Trafik Sigortası','',1);
/*!40000 ALTER TABLE `company_sub_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'2017-10-28 00:32:02','2017-11-06 19:54:53',1,NULL,1,NULL,'aaa@aaa.aaa','Serbest Meslek','0(555) 555-5555','Kamil','','Baş',12212323323,2),(2,'2017-10-28 00:32:02','2017-11-06 19:54:47',1,NULL,1,NULL,'bbb@bbb.bbb','Esnaf','0(444) 444-4444','Cafer','','Taş',12212323323,2),(3,'2017-11-11 14:43:38',NULL,0,'',1,'','hasan_60@hotmail.com','','0(543) 321-2323','Hasan','','Kağan',45612323236,1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `job_control`
--

LOCK TABLES `job_control` WRITE;
/*!40000 ALTER TABLE `job_control` DISABLE KEYS */;
INSERT INTO `job_control` VALUES (1,'2017-10-28 00:32:03',NULL,0,'policy','0 0 2 ? 1/1 MON#1 *','Bitiş tarihi geçmiş poliçeleri kapatır., her ayın ilk pazartesi çalışır',''),(2,'2017-10-28 00:32:03',NULL,0,'message','0 0 7 1/1 * ? *','Bitiş tarihi yaklamış poliçeleri kullanıcıya mail gönderir., her gün sabah 7 de çalışır','');
/*!40000 ALTER TABLE `job_control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2017-10-28 00:32:01',NULL,0,'fa-cogs',1,'Manager','Manager','Manager',NULL),(2,'2017-10-28 00:32:01',NULL,0,'fa-users',2,'User','manager/user/User','Users',1),(3,'2017-10-28 00:32:01',NULL,0,'fa-file-text-o',2,'Roles','manager/role/Role','Role',1),(4,'2017-10-28 00:32:01',NULL,0,'fa-tasks',3,'Menu','manager/menu/Menu','Menu',1),(5,'2017-10-28 00:32:01',NULL,0,'fa-cogs',4,'Permission','manager/permission/Permission','Permissions',1),(6,'2017-10-28 00:32:01',NULL,0,'fa-cogs',2,'Site','Site','Site',NULL),(7,'2017-10-28 00:32:01',NULL,0,'fa-list-alt',5,'Todo','app/Application','Todo',6),(8,'2017-10-28 00:32:01',NULL,0,'fa-rebel',6,'Showcase','app/Showcase','Showcase',6),(9,'2017-10-28 00:32:01',NULL,0,'fa-users',1,'Customer','site/customer/Customer','Müşteri Yönetimi',6),(10,'2017-10-28 00:32:01',NULL,0,'fa-file-text-o',2,'Policy','site/policy/Policy','Poliçe Yönetimi',6),(11,'2017-10-28 00:32:02',NULL,0,'fa-file-text-o',3,'OldPolicy','site/oldPolicy/OldPolicy','Geçmiş Poliçeler',6),(12,'2017-10-28 00:32:02',NULL,0,'fa-users',5,'Agency','manager/agency/Agency','Acente Yönetimi',1),(13,'2017-10-28 00:32:02',NULL,0,'fa-users',6,'AgencyUser','manager/agencyUser/AgencyUser','Acente Kullanıcı Yönetimi',1),(14,'2017-10-28 00:32:02',NULL,0,'fa-cogs',3,'Parameter','Parameter','Parametreler',NULL),(15,'2017-10-28 00:32:02',NULL,0,'fa-cogs',1,'Company','parameter/company/Company','Şirket Yönetimi',14),(16,'2017-10-28 00:32:02',NULL,0,'fa-cogs',2,'CompanyProduct','parameter/companyProduct/CompanyProduct','Şirket Ürün Yönetimi',14),(17,'2017-10-28 00:32:02',NULL,0,'fa-cogs',3,'CompanySubProduct','parameter/companySubProduct/CompanySubProduct','Şirket Alt Ürün Yönetimi',14),(18,'2017-11-01 19:20:03',NULL,0,'fa-user',4,'UserManager','site/user/UserManager','Kullanıcı Yönetimi',6);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (18,'2017-10-28 00:32:02',NULL,0,'rolePermission','REST',NULL,NULL,1),(19,'2017-10-28 00:32:02',NULL,0,'menuPermission','REST',NULL,NULL,1),(20,'2017-10-28 00:32:02',NULL,0,'userPermission','REST',NULL,NULL,1),(21,'2017-10-28 00:32:02',NULL,0,'permissionController','REST',NULL,NULL,1),(22,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',1,NULL,1),(23,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',10,NULL,1),(24,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',11,NULL,1),(25,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',12,NULL,1),(26,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',13,NULL,1),(27,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',14,NULL,1),(28,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',15,NULL,1),(29,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',16,NULL,1),(30,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',17,NULL,1),(31,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',18,NULL,1),(32,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',2,NULL,1),(33,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',3,NULL,1),(34,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',4,NULL,1),(35,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',5,NULL,1),(36,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',6,NULL,1),(37,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',7,NULL,1),(38,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',8,NULL,1),(39,'2017-11-01 19:20:18',NULL,0,NULL,'MENU',9,NULL,1),(40,'2017-11-01 19:20:30',NULL,0,NULL,'MENU',10,NULL,2),(41,'2017-11-01 19:20:30',NULL,0,NULL,'MENU',11,NULL,2),(42,'2017-11-01 19:20:30',NULL,0,NULL,'MENU',18,NULL,2),(43,'2017-11-01 19:20:30',NULL,0,NULL,'MENU',6,NULL,2),(44,'2017-11-01 19:20:30',NULL,0,NULL,'MENU',9,NULL,2),(45,'2017-11-01 19:20:36',NULL,0,NULL,'MENU',10,NULL,3),(46,'2017-11-01 19:20:36',NULL,0,NULL,'MENU',11,NULL,3),(47,'2017-11-01 19:20:36',NULL,0,NULL,'MENU',18,NULL,3),(48,'2017-11-01 19:20:36',NULL,0,NULL,'MENU',6,NULL,3),(49,'2017-11-01 19:20:36',NULL,0,NULL,'MENU',9,NULL,3);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
INSERT INTO `policy` VALUES (5,'2017-11-01 19:45:33',NULL,0,2,'','açıklama','2019-10-31 00:00:00',1002.00,'2','2019-10-23 00:00:00','2018-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(6,'2017-11-01 19:45:37',NULL,0,1,'','2','2018-10-28 00:00:00',2.00,'2','2018-10-21 00:00:00','2017-10-28 00:00:00','Kamil Baş isimli müşterinin poliçesi bitmek üzere.',1,1,1,2,1,0),(7,'2017-11-01 19:45:40','2017-11-01 19:45:33',1,2,'','açıklama','2019-10-31 00:00:00',1002.00,'2','2019-10-23 00:00:00','2018-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(8,'2017-11-01 19:45:45','2017-11-01 19:45:33',1,2,'','açıklama','2019-10-31 00:00:00',1002.00,'2','2019-10-23 00:00:00','2018-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(9,'2017-11-01 19:45:49','2017-11-01 19:45:33',1,2,'','açıklama','2019-10-31 00:00:00',1002.00,'2','2019-10-23 00:00:00','2018-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(10,'2017-11-01 19:45:53','2017-11-01 19:45:37',1,1,'','2','2018-10-28 00:00:00',2.00,'2','2018-10-21 00:00:00','2017-10-28 00:00:00','Kamil Baş isimli müşterinin poliçesi bitmek üzere.',1,1,1,2,1,0),(11,'2017-11-01 19:45:59','2017-11-01 19:28:01',1,2,'','açıklama','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(12,'2017-11-01 19:46:05','2017-11-01 19:28:01',1,2,'','açıklama','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(13,'2017-11-01 19:46:09','2017-11-01 19:28:01',1,2,'','açıklama','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(14,'2017-11-01 19:46:12','2017-11-01 19:28:01',1,2,'','açıklama','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(15,'2017-11-01 19:46:15','2017-11-01 19:28:01',1,2,'','açıklama','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(16,'2017-11-01 19:46:36','2017-11-01 19:28:01',1,2,'','açıklama','2018-10-28 00:00:00',1000.00,'3','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(17,'2017-11-01 20:03:01','2017-11-01 19:59:27',2,2,'','son kayıt','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(18,'2017-11-01 20:03:11','2017-11-01 19:59:27',2,2,'','son kayıt','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,1),(19,'2017-11-01 20:10:43',NULL,0,2,'','1','2018-10-31 00:00:00',1.00,'1','2018-10-24 00:00:00','2017-11-01 00:00:00','son kayıt',1,1,1,1,2,1),(20,'2017-11-01 23:44:25','2017-11-01 19:59:27',2,2,'','son kayıt','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,1),(21,'2017-11-01 23:45:27','2017-11-01 23:51:43',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(22,'2017-11-01 23:49:51','2017-11-01 19:59:27',2,2,'','son kayıt','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,1),(23,'2017-11-01 23:52:02','2017-11-01 23:58:57',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(24,'2017-11-01 23:59:01','2017-11-02 00:01:52',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(25,'2017-11-02 00:01:52','2017-11-02 00:05:10',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(26,'2017-11-02 00:05:10','2017-11-02 00:06:51',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(27,'2017-11-02 00:06:51','2017-11-02 00:11:00',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(28,'2017-11-02 00:11:00','2017-11-02 00:14:50',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(29,'2017-11-02 00:14:50','2017-11-02 00:15:20',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(30,'2017-11-02 00:15:20','2017-11-02 00:16:46',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(31,'2017-11-02 00:16:46','2017-11-02 00:18:16',3,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(32,'2017-11-02 00:18:16','2017-11-01 19:59:27',2,2,'','son kayıt1','2018-10-28 00:00:00',1000.00,'1','2021-10-15 00:00:00','2017-10-28 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,1),(33,'2017-11-02 00:19:35','2017-11-02 00:19:45',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(34,'2017-11-02 00:19:45','2017-11-02 00:20:02',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(35,'2017-11-02 00:20:02','2017-11-02 00:21:06',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(36,'2017-11-02 00:21:06','2017-11-02 00:23:12',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(37,'2017-11-02 00:23:12','2017-11-02 00:39:19',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(38,'2017-11-02 00:39:19','2017-11-02 00:47:01',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(39,'2017-11-02 00:47:01','2017-11-02 00:50:19',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(40,'2017-11-02 00:50:19','2017-11-02 00:54:20',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(41,'2017-11-02 00:54:20','2017-11-02 01:02:12',1,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(42,'2017-11-02 01:02:18',NULL,0,2,'','22','2018-11-01 00:00:00',22.00,'22','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,1),(43,'2017-11-02 01:02:42','2017-11-02 01:02:51',1,2,'','33','2018-11-01 00:00:00',33.00,'33','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(44,'2017-11-02 01:02:51','2017-11-02 01:03:46',1,2,'','33','2018-11-01 00:00:00',33.00,'33','2018-10-25 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(46,'2017-11-02 01:03:46','2017-11-02 01:09:51',1,2,'','33','2018-11-01 00:00:00',33.00,'33','2018-10-19 00:00:00','2017-11-02 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(47,'2017-11-02 01:04:49','2017-11-02 01:08:29',3,2,'','33','2018-11-01 00:00:00',33.00,'33','2018-10-11 00:00:00','2017-11-09 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,1),(48,'2017-11-02 01:09:51','2017-11-02 01:10:13',1,2,'','33','2018-11-01 00:00:00',33.00,'33','2018-10-19 00:00:00','2018-11-08 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(49,'2017-11-02 01:10:13','2017-11-02 01:15:04',1,2,'','33','2018-11-01 00:00:00',33.00,'33','2018-10-18 00:00:00','2018-11-08 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,0),(50,'2017-11-02 01:15:04',NULL,0,2,'','33','2018-11-01 00:00:00',33.00,'33','2018-10-18 00:00:00','2018-11-08 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',1,1,1,1,2,1),(51,'2017-11-06 19:43:57',NULL,0,2,'','1','2018-11-14 00:00:00',1.00,'1','2018-11-07 00:00:00','2017-11-15 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',2,1,1,1,2,1),(52,'2017-11-06 19:48:09',NULL,0,2,'','12','2018-11-05 00:00:00',12.00,'12','2018-10-29 00:00:00','2017-11-06 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',2,1,1,1,2,1),(53,'2017-11-06 19:49:28',NULL,0,2,'','1','2018-11-05 00:00:00',1.00,'1','2018-10-29 00:00:00','2017-11-06 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',2,1,1,1,2,1),(54,'2017-11-06 19:52:51',NULL,0,2,'','33','2018-11-05 00:00:00',33.00,'33','2018-10-29 00:00:00','2017-11-06 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',2,1,1,2,2,1),(55,'2017-11-06 19:53:45',NULL,0,1,'','12','2018-11-05 00:00:00',12.00,'12','2018-10-29 00:00:00','2017-11-06 00:00:00','Cafer Taş isimli müşterinin poliçesi bitmek üzere.',2,1,1,1,2,1);
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `policy_old`
--

LOCK TABLES `policy_old` WRITE;
/*!40000 ALTER TABLE `policy_old` DISABLE KEYS */;
INSERT INTO `policy_old` VALUES (1,'2017-11-01 23:53:14',NULL,0,2,'Anadolu Sigorta','Araç','Trafik Sigortası','Cafer Taş','','son kayıt','2018-10-28 00:00:00',1000.00,'1','2018-10-21 00:00:00','2017-10-28 00:00:00',NULL,1),(2,'2017-11-01 23:53:25',NULL,0,1,'Anadolu Sigorta','Araç','Tam Bakım Trafik Sigortası','Kamil Baş','','2','2018-10-28 00:00:00',2.00,'2','2018-10-21 00:00:00','2017-10-28 00:00:00',NULL,1),(3,'2017-11-01 23:53:30',NULL,0,2,'Anadolu Sigorta','Araç','Trafik Sigortası','Cafer Taş','','açıklama','2019-10-31 00:00:00',1002.00,'2','2019-10-23 00:00:00','2018-10-28 00:00:00',NULL,1),(4,'2017-11-01 23:53:35',NULL,0,1,'Anadolu Sigorta','Araç','Tam Bakım Trafik Sigortası','Kamil Baş','','2','2018-10-28 00:00:00',2.00,'2','2018-10-21 00:00:00','2017-10-28 00:00:00',NULL,1),(5,'2017-11-02 01:08:12',NULL,0,2,'Anadolu Sigorta','Araç','Trafik Sigortası','Cafer Taş','','33','2018-11-01 00:00:00',33.00,'33','2018-10-27 00:00:00','2017-11-02 00:00:00',NULL,1);
/*!40000 ALTER TABLE `policy_old` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rest`
--

LOCK TABLES `rest` WRITE;
/*!40000 ALTER TABLE `rest` DISABLE KEYS */;
INSERT INTO `rest` VALUES (1,'2017-10-28 13:20:57',NULL,0,'\0','','PUT','','/rest/agency',''),(2,'2017-10-28 13:20:57',NULL,0,'\0','','DELETE','','/rest/agency/{oid}',''),(3,'2017-10-28 13:20:57',NULL,0,'\0','','POST','','/rest/agency',''),(4,'2017-10-28 13:20:57',NULL,0,'\0','','GET','','/rest/agency',''),(5,'2017-10-28 13:20:57',NULL,0,'\0','','PUT','','/rest/agency-user',''),(6,'2017-10-28 13:20:57',NULL,0,'\0','','DELETE','','/rest/agency-user/{oid}',''),(7,'2017-10-28 13:20:57',NULL,0,'\0','','POST','','/rest/agency-user',''),(8,'2017-10-28 13:20:57',NULL,0,'\0','','GET','','/rest/agency-user/{id}',''),(9,'2017-10-28 13:20:57',NULL,0,'\0','','GET','','/rest/agency-user/check/{id}',''),(10,'2017-10-28 13:20:57',NULL,0,'\0','','GET','','/rest/agency-user',''),(11,'2017-10-28 13:20:57',NULL,0,'\0','','PUT','','/rest/company',''),(12,'2017-10-28 13:20:57',NULL,0,'\0','','DELETE','','/rest/company/{oid}',''),(13,'2017-10-28 13:20:57',NULL,0,'\0','','POST','','/rest/company',''),(14,'2017-10-28 13:20:57',NULL,0,'\0','','POST','','/rest/company/list-company-product',''),(15,'2017-10-28 13:20:57',NULL,0,'\0','','GET','','/rest/company',''),(16,'2017-10-28 13:20:57',NULL,0,'\0','','POST','','/rest/company/list-company-sub-product',''),(17,'2017-10-28 13:20:57',NULL,0,'\0','','GET','','/rest/company/all',''),(18,'2017-10-28 13:20:57',NULL,0,'\0','','PUT','','/rest/company-product',''),(19,'2017-10-28 13:20:57',NULL,0,'\0','','DELETE','','/rest/company-product/{oid}',''),(20,'2017-10-28 13:20:57',NULL,0,'\0','','POST','','/rest/company-product',''),(21,'2017-10-28 13:20:57',NULL,0,'\0','','GET','','/rest/company-product',''),(22,'2017-10-28 13:20:57',NULL,0,'\0','','PUT','','/rest/company-sub-product',''),(23,'2017-10-28 13:20:57',NULL,0,'\0','','DELETE','','/rest/company-sub-product/{oid}',''),(24,'2017-10-28 13:20:57',NULL,0,'\0','','POST','','/rest/company-sub-product',''),(25,'2017-10-28 13:20:57',NULL,0,'\0','','GET','','/rest/company-sub-product',''),(26,'2017-10-28 13:20:58',NULL,0,'\0','','PUT','','/rest/customer',''),(27,'2017-10-28 13:20:58',NULL,0,'\0','','DELETE','','/rest/customer/{oid}',''),(28,'2017-10-28 13:20:58',NULL,0,'\0','','POST','','/rest/customer',''),(29,'2017-10-28 13:20:58',NULL,0,'\0','','GET','','/rest/customer',''),(30,'2017-10-28 13:20:58',NULL,0,'\0','','DELETE','','/rest/dao-todos/{oid}',''),(31,'2017-10-28 13:20:58',NULL,0,'\0','','POST','','/rest/dao-todos',''),(32,'2017-10-28 13:20:58',NULL,0,'\0','','GET','','/rest/dao-todos/properties',''),(33,'2017-10-28 13:20:58',NULL,0,'\0','','GET','','/rest/dao-todos/select',''),(34,'2017-10-28 13:20:58',NULL,0,'\0','','GET','','/rest/dao-todos',''),(35,'2017-10-28 13:20:58',NULL,0,'','','GET','','/rest/dao-todos/secure',''),(36,'2017-10-28 13:20:58',NULL,0,'\0','','DELETE','','/rest/dao-todo-items/{oid}',''),(37,'2017-10-28 13:20:58',NULL,0,'\0','','POST','','/rest/dao-todo-items',''),(38,'2017-10-28 13:20:58',NULL,0,'\0','','PUT','','/rest/policy',''),(39,'2017-10-28 13:20:58',NULL,0,'\0','','DELETE','','/rest/policy/{oid}',''),(40,'2017-10-28 13:20:58',NULL,0,'\0','','POST','','/rest/policy',''),(41,'2017-10-28 13:20:58',NULL,0,'\0','','GET','','/rest/policy',''),(42,'2017-10-28 13:20:58',NULL,0,'\0','','GET','','/rest/policy/mail',''),(43,'2017-10-28 13:20:58',NULL,0,'\0','','GET','','/rest/policy-old',''),(44,'2017-10-28 13:20:58',NULL,0,'\0','','DELETE','','/rest/repository-todos/{oid}',''),(45,'2017-10-28 13:20:58',NULL,0,'\0','','POST','','/rest/repository-todos',''),(46,'2017-10-28 13:20:58',NULL,0,'\0','','GET','','/rest/repository-todos',''),(47,'2017-10-28 13:20:58',NULL,0,'\0','','DELETE','','/rest/repository-todo-items/{oid}',''),(48,'2017-10-28 13:20:58',NULL,0,'\0','','POST','','/rest/repository-todo-items',''),(49,'2017-10-28 13:20:58',NULL,0,'','Menü Kaydı Güncelleme','PUT','menusPUT','/rest/menus/{oid}','menuPermission'),(50,'2017-10-28 13:20:58',NULL,0,'','ID ile Menü Bilgisi Görüntüleme','GET','menusOidGET','/rest/menus/{oid}','menuPermission'),(51,'2017-10-28 13:20:58',NULL,0,'','Menü Kaydı Silme','DELETE','menusDELETE','/rest/menus/{oid}','menuPermission'),(52,'2017-10-28 13:20:58',NULL,0,'','Menü Kaydı Oluşturma','POST','menusPOST','/rest/menus','menuPermission'),(53,'2017-10-28 13:20:59',NULL,0,'','Menü Listesi Görüntüleme','GET','menusAllGET','/rest/menus/all','menuPermission'),(54,'2017-10-28 13:20:59',NULL,0,'','Üst Menüleri Görüntüleme','GET','menusParentsGET','/rest/menus/parents','menuPermission'),(55,'2017-10-28 13:20:59',NULL,0,'','Menü Ağacı Görüntüleme','GET','menusGET','/rest/menus','menuPermission'),(56,'2017-10-28 13:20:59',NULL,0,'','Yetki Verilecek Tüm Menüleri Görüntüleme','GET','permissionMenusGET','/rest/permissions/menus','permissionController'),(57,'2017-10-28 13:20:59',NULL,0,'','Tüm Servisleri Görüntüleme','GET','permissionEndPointsGET','/rest/permissions/endPoints','permissionController'),(58,'2017-10-28 13:20:59',NULL,0,'','Rol Bilgisine Ait Menüleri Görüntüleme','GET','permissionMenusRoleGET','/rest/permissions/menus/{oid}','permissionController'),(59,'2017-10-28 13:20:59',NULL,0,'','Rol Bilgisine Menü Yetkisi Verme','POST','permissionMenusRolePOST','/rest/permissions/configuresMenu/{oid}','permissionController'),(60,'2017-10-28 13:20:59',NULL,0,'','Rol Bilgisine Ait Servisleri Görüntüleme','GET','permissionEndPointsRoleGET','/rest/permissions/endPoints/{oid}','permissionController'),(61,'2017-10-28 13:20:59',NULL,0,'','Rol Bilgisine Servis Yetkisi Verme','POST','permissionEndPointsRolePOST','/rest/permissions/configurePermission/{oid}','permissionController'),(62,'2017-10-28 13:20:59',NULL,0,'','Rol Kaydı Güncelleme','PUT','rolesPUT','/rest/roles/{oid}','rolePermission'),(63,'2017-10-28 13:20:59',NULL,0,'','ID ile Rol Bilgisi Görüntüleme','GET','rolesOidGET','/rest/roles/{oid}','rolePermission'),(64,'2017-10-28 13:20:59',NULL,0,'','Rol Kaydı Silme','DELETE','rolesDELETE','/rest/roles/{oid}','rolePermission'),(65,'2017-10-28 13:20:59',NULL,0,'','Rol Kaydı Oluşturma','POST','rolesPOST','/rest/roles','rolePermission'),(66,'2017-10-28 13:20:59',NULL,0,'','Rol Bilgilerini Görüntüleme','GET','rolesGET','/rest/roles','rolePermission'),(67,'2017-10-28 13:20:59',NULL,0,'','Kullanıcı Güncelleme','PUT','usersPUT','/rest/users/{oid}','userPermission'),(68,'2017-10-28 13:20:59',NULL,0,'','ID İle Kullanıcı Bilgisi Görüntüleme','GET','usersGETID','/rest/users/{oid}','userPermission'),(69,'2017-10-28 13:20:59',NULL,0,'','Kullanıcı Silme','DELETE','usersPUT','/rest/users/{oid}','userPermission'),(70,'2017-10-28 13:20:59',NULL,0,'','Kullanıcı Oluşturma','POST','usersPOST','/rest/users','userPermission'),(71,'2017-10-28 13:20:59',NULL,0,'','Kullanıcı Entity Bilgilerini Görüntüleme','GET','usersPropertiesGET','/rest/users/properties','userPermission'),(72,'2017-10-28 13:20:59',NULL,0,'','Kullanıcı Listesi Görüntüleme','GET','usersGET','/rest/users','userPermission'),(73,'2017-10-28 13:20:59',NULL,0,'','Login Olan Kullanıcı Bilgilerini Görüntüleme','GET','usersSessionUserGET','/rest/users/sessionUser','userPermission'),(74,'2017-10-28 13:20:59',NULL,0,'','Kullanıcı Listeleme','GET','usersSelectGET','/rest/users/select','userPermission'),(75,'2017-10-28 13:20:59',NULL,0,'\0','','GET','','/rest/v2/api-docs',''),(76,'2017-11-01 19:17:46',NULL,0,'\0','','GET','','/rest/agency-user/agencyUser',''),(77,'2017-11-01 19:17:47',NULL,0,'\0','','GET','','/rest/policy/{oid}',''),(78,'2017-11-01 19:17:47',NULL,0,'\0','','POST','','/rest/policy/{oldId}',''),(79,'2017-11-02 00:30:32',NULL,0,'\0','','POST','','/rest/policy/policyOld',''),(80,'2017-11-02 00:30:32',NULL,0,'\0','','POST','','/rest/policy/policyOld',''),(81,'2017-11-02 00:57:40',NULL,0,'\0','','POST','','/rest/policy/old','');
/*!40000 ALTER TABLE `rest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'2017-10-28 00:32:01',NULL,0,'ADMIN',NULL,'Admin'),(2,'2017-10-28 00:32:01',NULL,0,'AGENCY_USER',NULL,'user'),(3,'2017-10-28 00:32:01',NULL,0,'AGENCY_ADMIN',NULL,'Admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `todo`
--

LOCK TABLES `todo` WRITE;
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `todo_items`
--

LOCK TABLES `todo_items` WRITE;
/*!40000 ALTER TABLE `todo_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `todo_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2017-10-28 00:32:01','2017-11-01 19:21:19',1,'','Mustafa','96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e','Erbin','admin',1),(2,'2017-10-28 00:32:01','2017-11-06 20:09:38',1,'','User','96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e','User','agencyUser',2),(3,'2017-10-28 00:32:01',NULL,0,'','Admin','96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e','Admin','agencyAdmin',3),(4,'2017-10-28 22:39:08',NULL,0,'','testt','96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e','testt','testt',2);
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

-- Dump completed on 2017-11-11 14:54:58
