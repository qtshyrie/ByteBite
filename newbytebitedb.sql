-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2026 at 01:39 PM
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
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`) VALUES
(1, 'admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

SELECT SUM(Price) FROM sales WHERE Date = CURDATE();
SELECT SUM(Price) FROM sales WHERE YEARWEEK(Date, 1) = YEARWEEK(CURDATE(), 1);
SELECT SUM(Price) FROM sales WHERE MONTH(Date) = MONTH(CURDATE()) AND YEAR(Date) = YEAR(CURDATE());
SELECT SUM(Price) FROM sales WHERE YEAR(Date) = YEAR(CURDATE());

CREATE TABLE `foods` (
  `id` int(255) NOT NULL,
  `foods` varchar(255) NOT NULL,
  `category` enum('foods','sides','drinks') NOT NULL,
  `price` int(255) NOT NULL,
  `status` enum('Available','Not Available') DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`id`, `foods`, `category`, `price`, `status`, `path`) VALUES
(1, 'Big Mac', 'foods', 180, 'Available', 'IMG/newpackage/Admin.png'),
(2, 'Cheeseburger', 'foods', 120, 'Available', 'IMG/newpackage/Admin.png'),
(3, 'McChicken', 'foods', 150, 'Not Available', 'IMG/newpackage/Admin.png'),
(4, 'Chicken McNuggets (6pcs)', 'foods', 160, 'Not Available', 'IMG/newpackage/Admin.png'),
(5, 'Filet-O-Fish', 'foods', 140, 'Not Available', 'IMG/newpackage/Admin.png'),
(6, 'French Fries (Medium)', 'foods', 90, 'Not Available', 'IMG/newpackage/Admin.png'),
(7, 'Spaghetti', 'foods', 130, 'Available', 'IMG/newpackage/Admin.png'),
(8, 'Burger McDo', 'foods', 110, 'Not Available', 'IMG/newpackage/Admin.png'),
(9, 'McFlurry Oreo', 'sides', 100, 'Available', 'IMG/newpackage/Admin.png'),
(10, 'Coke (Medium)', 'drinks', 70, 'Available', 'IMG/newpackage/Admin.png'),
(11, 'French Fries (Medium)', 'sides', 90, 'Not Available', 'IMG/newpackage/Admin.png'),
(12, 'French Fries (Large)', 'sides', 110, 'Available', 'IMG/newpackage/Admin.png'),
(13, 'Hash Browns', 'sides', 70, 'Available', 'IMG/newpackage/Admin.png'),
(14, 'Apple Pie', 'sides', 80, 'Not Available', 'IMG/newpackage/Admin.png'),
(15, 'Corn Cup', 'sides', 60, 'Not Available', 'IMG/newpackage/Admin.png'),
(16, 'Coke (Medium)', 'drinks', 70, 'Not Available', 'IMG/newpackage/Admin.png'),
(17, 'Coke (Large)', 'drinks', 85, 'Available', 'IMG/newpackage/Admin.png'),
(18, 'Sprite (Medium)', 'drinks', 70, 'Available', 'IMG/newpackage/Admin.png'),
(19, 'Iced Tea', 'drinks', 75, 'Available', 'IMG/newpackage/Admin.png'),
(20, 'Orange Juice', 'drinks', 80, 'Available', 'IMG/newpackage/Admin.png'),
(21, 'Coffee', 'drinks', 65, 'Available', 'IMG/newpackage/Admin.png'),
(22, 'McFlurry Oreo', 'sides', 100, 'Available', 'IMG/newpackage/Admin.png'),
(23, 'Sundae Chocolate', 'sides', 90, 'Available', 'IMG/newpackage/Admin.png'),
(24, 'Coke (Regular)', 'drinks', 50, 'Not Available', 'IMG/newpackage/Admin.png'),
(25, 'Coke (Large)', 'drinks', 70, 'Available', 'IMG/newpackage/Admin.png'),
(26, 'Sprite (Regular)', 'drinks', 50, 'Available', 'IMG/newpackage/Admin.png'),
(27, 'Sprite (Large)', 'drinks', 70, 'Not Available', 'IMG/newpackage/Admin.png'),
(28, 'Royal (Regular)', 'drinks', 50, 'Available', 'IMG/newpackage/Admin.png'),
(29, 'Royal (Large)', 'drinks', 70, 'Available', 'IMG/newpackage/Admin.png'),
(30, 'Iced Tea (Regular)', 'drinks', 55, 'Available', 'IMG/newpackage/Admin.png'),
(31, 'Iced Tea (Large)', 'drinks', 75, 'Available', 'IMG/newpackage/Admin.png'),
(32, 'Pineapple Juice', 'drinks', 60, 'Not Available', 'IMG/newpackage/Admin.png'),
(33, 'Hot Chocolate', 'drinks', 65, 'Not Available', 'IMG/newpackage/Admin.png'),
(34, 'Coffee', 'drinks', 50, 'Not Available', 'IMG/newpackage/Admin.png'),
(35, 'Bottled Water', 'drinks', 25, 'Not Available', 'IMG/newpackage/Admin.png'),
(36, 'French Fries (Regular)', 'sides', 45, 'Not Available', 'IMG/newpackage/Admin.png'),
(37, 'French Fries (Large)', 'sides', 65, 'Not Available', 'IMG/newpackage/Admin.png'),
(38, 'Mashed Potato', 'sides', 55, 'Available', 'IMG/newpackage/Admin.png'),
(39, 'Butter Corn', 'sides', 50, 'Not Available', 'IMG/newpackage/Admin.png'),
(40, 'Coleslaw', 'sides', 45, 'Available', 'IMG/newpackage/Admin.png'),
(41, 'Extra Rice', 'sides', 30, 'Available', 'IMG/newpackage/Admin.png'),
(42, 'Garlic Rice', 'sides', 35, 'Not Available', 'IMG/newpackage/Admin.png'),
(43, 'Macaroni Soup', 'sides', 60, 'Not Available', 'IMG/newpackage/Admin.png'),
(44, 'Chicken Gravy', 'sides', 20, 'Not Available', 'IMG/newpackage/Admin.png'),
(45, 'Peach Mango Pie', 'sides', 40, 'Available', 'IMG/newpackage/Admin.png'),
(46, 'Burger Steak (Solo)', 'sides', 85, 'Available', 'IMG/newpackage/Admin.png'),
(47, 'Shanghai Rolls', 'sides', 70, 'Available', 'IMG/newpackage/Admin.png'),
(49, 'HAHAHAHHAHA', 'foods', 88888, 'Available', 'IMG/newpackage/Admin.png'),
(50, 'asfdasdfsa', 'foods', 20, 'Available', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `ID` int(255) NOT NULL,
  `Item Name` varchar(255) NOT NULL,
  `Price` int(255) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`ID`, `Item Name`, `Price`, `Date`) VALUES
(1, 'Big Mac', 180, '2026-04-14'),
(2, 'Big Mac', 180, '2026-04-14'),
(3, 'Big Mac', 180, '2026-04-14'),
(4, 'Coke (Medium)', 70, '2026-04-14'),
(5, 'Coke (Medium)', 70, '2026-04-14'),
(6, 'Coke (Medium)', 70, '2026-04-14'),
(7, 'McChicken', 150, '2026-04-14'),
(8, 'Cheeseburger', 120, '2026-04-14'),
(9, 'Filet-O-Fish', 140, '2026-04-14'),
(10, 'McChicken', 150, '2026-04-14'),
(11, 'McChicken', 150, '2026-04-14'),
(12, 'Big Mac', 180, '2026-04-15'),
(13, 'Big Mac', 180, '2026-04-15'),
(14, 'Big Mac', 180, '2026-04-15'),
(15, 'Big Mac', 180, '2026-04-15'),
(16, 'Big Mac', 180, '2026-04-15'),
(17, 'Big Mac', 180, '2026-04-15'),
(18, 'Big Mac', 180, '2026-04-15'),
(19, 'Coke (Medium)', 70, '2026-04-16'),
(20, 'Coke (Medium)', 70, '2026-04-16'),
(21, 'Coke (Medium)', 70, '2026-04-16'),
(22, 'Coke (Medium)', 70, '2026-04-16'),
(23, 'Coke (Medium)', 70, '2026-04-16'),
(24, 'Iced Tea', 75, '2026-04-16'),
(25, 'Iced Tea', 75, '2026-04-16'),
(26, 'Iced Tea', 75, '2026-04-16'),
(27, 'Iced Tea', 75, '2026-04-16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;