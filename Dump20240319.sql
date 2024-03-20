-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: codeplatformdb
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `code_challenge`
--

DROP TABLE IF EXISTS `code_challenge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `code_challenge` (
  `id` int NOT NULL,
  `code` text,
  `description` text,
  `input` text,
  `level` varchar(255) DEFAULT NULL,
  `output` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_challenge`
--

LOCK TABLES `code_challenge` WRITE;
/*!40000 ALTER TABLE `code_challenge` DISABLE KEYS */;
INSERT INTO `code_challenge` VALUES (1,'aW1wb3J0IGphdmEudXRpbC4qOwppbXBvcnQgamF2YS5pby4qOwoKcHVibGljIGNsYXNzIE1haW4gewogIHB1YmxpYyBzdGF0aWMgYm9vbGVhbiB2YWxpZGF0ZVN5bWJvbChTdHJpbmcgcGFyYW0pIHsKICAgIExpc3Q8U3RyaW5nPiBzeW1ib2xzID0gbmV3IEFycmF5TGlzdDw+KCk7CiAgICB0cnl7CiAgICAgIGlmKHBhcmFtLmNoYXJBdCgwKSA9PSAnKCcpewogICAgICAgIHN5bWJvbHMuYWRkKCIoIik7CiAgICAgIH0KICAgICAgZWxzZXsKICAgICAgICByZXR1cm4gZmFsc2U7CiAgICAgIH0KICAgICAgZm9yKGludCBpID0gMTsgaSA8IHBhcmFtLmxlbmd0aCgpOyBpKyspewogICAgICAgIGlmKHBhcmFtLmNoYXJBdChpKSA9PSAnKCcpewogICAgICAgICAgc3ltYm9scy5hZGQoIigiKTsKICAgICAgfQogICAgICAgIGVsc2UgaWYocGFyYW0uY2hhckF0KGkpID09ICcpJyl7CiAgICAgICAgICBzeW1ib2xzLnJlbW92ZSgwKTsKICAgICAgICB9CiAgICAgIH0KICAgICAgaWYoc3ltYm9scy5zaXplKCkgPT0gMCkKICAgICAgICByZXR1cm4gdHJ1ZTsKICAgICAgZWxzZQogICAgICAgIHJldHVybiBmYWxzZTsKICAgIH0KICAgIGNhdGNoKEV4Y2VwdGlvbiBlKXsKICAgICAgcmV0dXJuIGZhbHNlOwogICAgfQogIH0KCiAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4gKFN0cmluZ1tdIGFyZ3MpIHsKCVNjYW5uZXIgaW5wdXQgPSBuZXcgU2Nhbm5lcihTeXN0ZW0uaW4pOwoJU3RyaW5nIGlucCA9IGlucHV0Lm5leHQoKTsKICAgIFN5c3RlbS5vdXQucHJpbnQodmFsaWRhdGVTeW1ib2woaW5wKSk7CiAgfQoKfQ==','R2l2ZW4gYW4gYXJyYXkgb2Ygc2ltYm9scywgcGxlYXNlIHZhbGlkYXRlIHRoYXQgaXQgaXMgd2VsbCBmb3JtZWQuIAoKSXQgaGFzIHRoZSBzYW1lIG51bWJlciBvZiBjbG9zaW5nIGFuZCBvcGVuaW5nIHBhcmVudGhlc2lzLgoKSXQgc2hvdWxkIHN0YXJ0IHdpdGggYW4gb3BlbiBwYXJlbnRoZXNpcy4gCgpOZXN0ZWQgcGFyZW50aGVzaXMgYXJlIGFsbG93ZWQgYnV0IGl0IHNob3VsZCBiZSBjbG9zZWQKCkl0IHNob3VsZCBiZSBhbHdheXMgYW4gb3BlbmluZyBwYXJlbnRoZXNpcyBmaXJzdC4KCgoKMS4tIGlucHV0PSgpIDsgcj10cnVlIAoKMS4tIGlucHV0PSgpKCkgOyByPXRydWUgCgoxLi0gaW5wdXQ9KCgpKSA7IHI9dHJ1ZSAKCjEuLSAgaW5wdXQ9KCgpIDsgcj1mYWxzZQoKMS4tIGlucHV0PSkoIDsgcj1mYWxzZQoKMS4tIGlucHV0PSgpKSggOyByPWZhbHNlIAoKMS4tICgoKSkpKCgpOyByPWZhbHNl','KCgpKCkp','JR','true'),(2,'aW1wb3J0IGphdmEudXRpbC4qOyAKaW1wb3J0IGphdmEuaW8uKjsKCnB1YmxpYyBjbGFzcyBNYWluIHsKCiAgcHVibGljIHN0YXRpYyBTdHJpbmcgRml6ekJ1enooaW50IG51bSkgewogICAgU3RyaW5nIHJlc3VsdD0iIjsKICAgIGZvciAoIGludCBpID0xIDsgaSA8PSBudW0gOyBpKyspewogICAgICBpZiAoIGkgJSAzID09MCAgICYmIGkgJSA1ID09MCl7CiAgICAgICAgcmVzdWx0Kz0iRml6ekJ1enoiOwogICAgICB9ZWxzZSBpZiAoIGkgJSAzID09MCl7CiAgICAgICAgcmVzdWx0Kz0iRml6eiI7CiAgICAgIH1lbHNlIGlmICggaSAlNSA9PTApewogICAgICAgIHJlc3VsdCs9IkJ1enoiOwogICAgICB9ZWxzZXsKICAgICAgICByZXN1bHQrPVN0cmluZy52YWx1ZU9mKGkpOwogICAgICB9CiAgICAgICByZXN1bHQrPSIgIjsKICAgIH0KICAgIHJldHVybiByZXN1bHQ7CiAgfQoKICBwdWJsaWMgc3RhdGljIHZvaWQgbWFpbiAoU3RyaW5nW10gYXJncykgeyAgCiAgICBTY2FubmVyIHMgPSBuZXcgU2Nhbm5lcihTeXN0ZW0uaW4pOwogICAgU3lzdGVtLm91dC5wcmludChGaXp6QnV6eihzLm5leHRJbnQoKSkpOyAKICB9Cgp9','VGhlIHJ1bGVzIG9mIHRoZSBGaXp6QnV6eiBnYW1lIGFyZSB2ZXJ5IHNpbXBsZS4KClNheSBGaXp6IGlmIHRoZSBudW1iZXIgaXMgZGl2aXNpYmxlIGJ5IDMuCgpTYXkgQnV6eiBpZiB0aGUgbnVtYmVyIGlzIGRpdmlzaWJsZSBieSA1LgoKU2F5IEZpenpCdXp6IGlmIHRoZSBudW1iZXIgaXMgZGl2aXNpYmxlIGJ5IGJvdGggMyBhbmQgNS4KClJldHVybiB0aGUgbnVtYmVyIGl0c2VsZiwgaWYgdGhlIG51bWJlciBpcyBub3QgZGl2aXNpYmxlIGJ5IDMgYW5kIDUu','MjA=','JR','1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz'),(3,'aW1wb3J0IGphdmEudXRpbC4qOwppbXBvcnQgamF2YS5pby4qOwoKcHVibGljIGNsYXNzIE1haW4geyAgCiAgLy9Zb3Ugc2hvdWxkIGNoYW5nZSB0aGlzIGZ1bmN0aW9uCiAgcHJpdmF0ZSBzdGF0aWMgYm9vbGVhbiBpc1BhbGluZHJvbWUoU3RyaW5nIHN0cikgewogICAgY2hhcltdIHN0ckFyciA9IHN0ci50b0NoYXJBcnJheSgpOwogICAgaW50IGxlbiA9IHN0ckFyci5sZW5ndGg7CiAgICBmb3IgKGludCBpID0gMDsgaSA8IGxlbiAvIDI7IGkrKykgewogICAgICBpZiAoc3RyQXJyW2ldICE9IHN0ckFycltsZW4gLSBpIC0gMV0pIHsKICAgICAgICByZXR1cm4gZmFsc2U7CiAgICAgIH0KICAgIH0KICAgIHJldHVybiB0cnVlOwogIH0KCiAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewoJU2Nhbm5lciBzID0gbmV3IFNjYW5uZXIoU3lzdGVtLmluKTsKICAgIFN5c3RlbS5vdXQucHJpbnQoaXNQYWxpbmRyb21lKHMubmV4dCgpKSk7CiAgfQp9','SGF2ZSB0aGUgZnVuY3Rpb24gUGFsaW5kcm9tZShzdHIpIHRha2UgdGhlIHN0ciBwYXJhbWV0ZXIgYmVpbmcgcGFzc2VkIAoKcmV0dXJuIHRoZSBzdHJpbmcgdHJ1ZSBpZiB0aGUgcGFyYW1ldGVyIGlzIGEgcGFsaW5kcm9tZSwgKHRoZSBzdHJpbmcgaXMgdGhlIHNhbWUgZm9yd2FyZCBhcyBpdCBpcyBiYWNrd2FyZCkKCm90aGVyd2lzZSByZXR1cm4gdGhlIHN0cmluZyBmYWxzZS4KCkZvciBleGFtcGxlOiAicmFjZWNhciIgaXMgYWxzbyAicmFjZWNhciIgYmFja3dhcmRzLgoKUHVuY3R1YXRpb24gYW5kIG51bWJlcnMgd2lsbCBub3QgYmUgcGFydCBvZiB0aGUgc3RyaW5nLg==','cmFjZWNhcg==','JR','true');
/*!40000 ALTER TABLE `code_challenge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_test_case`
--

DROP TABLE IF EXISTS `code_test_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `code_test_case` (
  `id` int NOT NULL,
  `input` text,
  `max_duration` int NOT NULL,
  `output` text,
  `code_challenge_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKckulnh1w03iu8axvvgochqwdg` (`code_challenge_id`),
  CONSTRAINT `FKckulnh1w03iu8axvvgochqwdg` FOREIGN KEY (`code_challenge_id`) REFERENCES `code_challenge` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_test_case`
--

LOCK TABLES `code_test_case` WRITE;
/*!40000 ALTER TABLE `code_test_case` DISABLE KEYS */;
INSERT INTO `code_test_case` VALUES (1,'()',1,'true',1),(2,'()()',1,'true',1),(3,'(())',1,'true',1),(4,'(()',1,'false',1),(5,')(',1,'false',1),(6,'())(',1,'false',1),(7,'10',1,'1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz ',2),(8,'20',1,'1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz ',2),(9,'30',1,'1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz ',2),(10,'40',1,'1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz ',2),(11,'50',1,'1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz 41 Fizz 43 44 FizzBuzz 46 47 Fizz 49 Buzz ',2),(12,'racecar',1,'true',3),(13,'kayak',1,'true',3),(14,'rotator',1,'true',3),(15,'palindromes',1,'false',3),(16,'dog',1,'false',3),(17,'words',1,'false',3);
/*!40000 ALTER TABLE `code_test_case` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-19  9:29:03
