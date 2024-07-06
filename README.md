
# Ejercicio de Sesión de usuario (Springboot y React)

Este breve ejercicio tuvo el objetivo de explorar la creación de sesiones de usuario manejadas por parte de un backend basado en Java Springboot que consume datos de una base de datos hecha con MySql, presentada en un login hecho con React.js. 

En este ejercicio se amplió el conocimiento sobre el funcionamiento de los servidores de backend y cómo implementar medidas de seguridad tales como:

- Encriptación de contraseñas de usuario
- Manejo de sesiones con tokens JWT


## Set-up del proyecto

Para poder usar el proyecto se necesita instalar las siguientes tecnologías:

- IntelliJ Idea (Preferiblemente)
- JDK 18 o superiores
- MySQL

### Script de SQL

Por defecto la base de datos lleva el nombre "loginweb" sin embargo, puede ser cambiado en las propiedades de la aplicacion de springboot reemplazando la cadena de conexión.

```sql
USE loginweb;

 -- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: loginweb
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;
```
    
## Tech Stack

**Client:** React with Vite, TailwindCSS

**Server:** Springboot Web

**Database:** MySQL

