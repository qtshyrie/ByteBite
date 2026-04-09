-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2026 at 07:58 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bytebitedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `id` int(255) NOT NULL,
  `foods` varchar(255) NOT NULL,
  `category` enum('foods','sides','drinks') NOT NULL,
  `quantity` int(255) NOT NULL,
  `price` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`id`, `foods`, `category`, `quantity`, `price`) VALUES
(1, 'Big Mac', 'foods', 50, 180),
(2, 'Cheeseburger', 'foods', 60, 120),
(3, 'McChicken', 'foods', 45, 150),
(4, 'Chicken McNuggets (6pcs)', 'foods', 70, 160),
(5, 'Filet-O-Fish', 'foods', 40, 140),
(6, 'French Fries (Medium)', 'foods', 80, 90),
(7, 'Spaghetti', 'foods', 30, 130),
(8, 'Burger McDo', 'foods', 55, 110),
(9, 'McFlurry Oreo', 'sides', 35, 100),
(10, 'Coke (Medium)', 'drinks', 90, 70),
(11, 'French Fries (Medium)', 'sides', 80, 90),
(12, 'French Fries (Large)', 'sides', 60, 110),
(13, 'Hash Browns', 'sides', 50, 70),
(14, 'Apple Pie', 'sides', 40, 80),
(15, 'Corn Cup', 'sides', 35, 60),
(16, 'Coke (Medium)', 'drinks', 90, 70),
(17, 'Coke (Large)', 'drinks', 70, 85),
(18, 'Sprite (Medium)', 'drinks', 85, 70),
(19, 'Iced Tea', 'drinks', 60, 75),
(20, 'Orange Juice', 'drinks', 50, 80),
(21, 'Coffee', 'drinks', 40, 65),
(22, 'McFlurry Oreo', '', 35, 100),
(23, 'Sundae Chocolate', '', 45, 90),
(24, 'Coke (Regular)', 'drinks', 50, 50),
(25, 'Coke (Large)', 'drinks', 40, 70),
(26, 'Sprite (Regular)', 'drinks', 45, 50),
(27, 'Sprite (Large)', 'drinks', 35, 70),
(28, 'Royal (Regular)', 'drinks', 40, 50),
(29, 'Royal (Large)', 'drinks', 30, 70),
(30, 'Iced Tea (Regular)', 'drinks', 60, 55),
(31, 'Iced Tea (Large)', 'drinks', 50, 75),
(32, 'Pineapple Juice', 'drinks', 40, 60),
(33, 'Hot Chocolate', 'drinks', 30, 65),
(34, 'Coffee', 'drinks', 25, 50),
(35, 'Bottled Water', 'drinks', 100, 25),
(36, 'French Fries (Regular)', 'sides', 60, 45),
(37, 'French Fries (Large)', 'sides', 50, 65),
(38, 'Mashed Potato', 'sides', 40, 55),
(39, 'Butter Corn', 'sides', 35, 50),
(40, 'Coleslaw', 'sides', 30, 45),
(41, 'Extra Rice', 'sides', 100, 30),
(42, 'Garlic Rice', 'sides', 80, 35),
(43, 'Macaroni Soup', 'sides', 25, 60),
(44, 'Chicken Gravy', 'sides', 70, 20),
(45, 'Peach Mango Pie', 'sides', 50, 40),
(46, 'Burger Steak (Solo)', 'sides', 45, 85),
(47, 'Shanghai Rolls', 'sides', 30, 70);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
