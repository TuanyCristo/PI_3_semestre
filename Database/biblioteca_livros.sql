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
-- Table structure for table `livros`
--

DROP TABLE IF EXISTS `livros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livros` (
  `id_livro` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(80) NOT NULL,
  `autor` varchar(80) DEFAULT NULL,
  `quantExemplares` int(11) NOT NULL,
  PRIMARY KEY (`id_livro`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livros`
--

LOCK TABLES `livros` WRITE;
/*!40000 ALTER TABLE `livros` DISABLE KEYS */;
INSERT INTO `livros` VALUES (1,'A raiva não educa, a calma educa','Maya Eigenmann',2),(2,'A Culpa é das Estrelas','John Green',2),(3,'Harry Potter e a Pedra Filosofal','J.K. Rowling',3),(4,'O Pequeno Príncipe','Antoine de Saint-Exupéry',4),(5,'Cem Anos de Solidão','Gabriel García Márquez',2),(6,'O Senhor dos Anéis: A Sociedade do Anel','J.R.R. Tolkien',3),(7,'O Código Da Vinci','Dan Brown',4),(8,'1984','George Orwell',2),(9,'Orgulho e Preconceito','Jane Austen',3),(10,'A Revolução dos Bichos','George Orwell',4),(11,'Dom Quixote','Miguel de Cervantes',2),(12,'Harry Potter e a Câmara Secreta','J.K. Rowling',3),(13,'O Hobbit','J.R.R. Tolkien',4),(14,'O Alquimista','Paulo Coelho',2),(15,'A Menina que Roubava Livros','Markus Zusak',3),(16,'Harry Potter e o Prisioneiro de Azkaban','J.K. Rowling',4),(17,'Os Miseráveis','Victor Hugo',2),(18,'As Crônicas de Nárnia: O Leão, a Feiticeira e o Guarda-Roupa','C.S. Lewis',3),(19,'O Diário de Anne Frank','Anne Frank',4),(20,'A Metamorfose','Franz Kafka',2),(21,'O Senhor dos Anéis: O Retorno do Rei','J.R.R. Tolkien',3);
/*!40000 ALTER TABLE `livros` ENABLE KEYS */;
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
