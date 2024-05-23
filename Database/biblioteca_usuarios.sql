CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: biblioteca
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(8) NOT NULL,
  `tipo` enum('regular','admin') DEFAULT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Tuany','tuany@senacsp.edu.br','Tuany00!','regular',NULL),(2,'Guto','guto@senacsp.edu.br','Gutoo00!','regular',NULL),(3,'Gabriel','gabe@senacsp.edu.br','1234aA!','admin','Gestor'),(5,'Fulano Silva','fulano@senacsp.edu.br','Senha#12','regular',NULL),(6,'Beltrano Santos','beltrano@senacsp.edu.br','Senac123','regular',NULL),(7,'Ciclano Oliveira','ciclano@senacsp.edu.br','Cicla#98','regular',NULL),(8,'João Pereira','joao@senacsp.edu.br','Senha123','regular',NULL),(9,'Maria Souza','maria@senacsp.edu.br','Mari@567','regular',NULL),(10,'Pedro Almeida','pedro@senacsp.edu.br','Pedro#32','regular',NULL),(11,'Ana Lima','ana@senacsp.edu.br','Anali$56','regular',NULL),(12,'Paulo Costa','paulo@senacsp.edu.br','Paulo123','regular',NULL),(13,'Luiza Fernandes','luiza@senacsp.edu.br','Luiza@09','regular',NULL),(14,'Carlos Santos','carlos@senacsp.edu.br','Santos#3','regular',NULL),(15,'João Silva','joaosilva@senacsp.edu.br','Joao@123','admin','Gerente'),(16,'Maria Santos','mariasantos@senacsp.edu.br','Maria@45','admin','Coordenador'),(17,'Pedro Oliveira','pedrooliveira@senacsp.edu.br','Pedro#78','admin','Supervisor'),(18,'Ana Souza','anasouza@senacsp.edu.br','Ana&321','admin','Administrador'),(19,'Carlos Silva','carlossilva@senacsp.edu.br','Carlos*6','admin','Diretor');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22 22:40:53
