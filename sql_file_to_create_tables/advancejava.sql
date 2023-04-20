-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 20, 2023 at 12:36 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `advancejava`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `address` text,
  `mobile` text,
  `city` varchar(50) DEFAULT 'Indore',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `address`, `mobile`, `city`) VALUES
(1, 'Vikas Sharma', 'Indore', '9074124763', 'Indore'),
(2, 'Vicky Sharma', 'Indore', '9074124763', 'Ujjain'),
(3, 'Testing', 'Testing', '785694123', 'Mumbai');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL,
  `name` text,
  `price` int DEFAULT '2000',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`) VALUES
(1, 'Tomato', 2000),
(2, 'Potato', 1500);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE IF NOT EXISTS `purchase` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `invoice_no` int NOT NULL,
  `customer_id` int NOT NULL,
  `product_id` int NOT NULL,
  `price` text NOT NULL,
  `qty` int NOT NULL,
  `amount` int NOT NULL,
  `purchase_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `invoice_no` (`invoice_no`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `purchase`
--

-- INSERT INTO `purchase` (`id`, `invoice_no`, `customer_id`, `product_id`, `price`, `qty`, `amount`, `purchase_date`) VALUES
-- (20, 104, 2, 2, '1500', 20, 30000, '2023-04-17'),
-- (19, 103, 1, 1, '2000', 5, 10000, '2023-04-17'),
-- (18, 102, 1, 1, '2000', 35, 70000, '2023-04-17'),
-- (17, 101, 2, 1, '2000', 50, 100000, '2023-04-17');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `invoice_no` int NOT NULL,
  `customer_id` int NOT NULL,
  `product_id` int NOT NULL,
  `price` text NOT NULL,
  `qty` int NOT NULL,
  `amount` int NOT NULL,
  `sales_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `invoice_no` (`invoice_no`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sales`
--

-- INSERT INTO `sales` (`id`, `invoice_no`, `customer_id`, `product_id`, `price`, `qty`, `amount`, `sales_date`) VALUES
-- (4, 101, 1, 1, '2000', 12, 24000, '2023-04-17'),
-- (5, 102, 2, 1, '2000', 2, 4000, '2023-04-17');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qty` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `stock`
--

-- INSERT INTO `stock` (`id`, `qty`, `product_id`) VALUES
-- (8, 20, 2),
-- (7, 76, 1);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
