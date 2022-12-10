-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2022 at 05:29 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cellphonedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `mobile_shop`
--

CREATE TABLE `mobile_shop` (
  `mobileid` int(11) NOT NULL,
  `brandname` varchar(30) DEFAULT NULL,
  `modelname` varchar(30) DEFAULT NULL,
  `ram` varchar(20) DEFAULT NULL,
  `rom` varchar(20) DEFAULT NULL,
  `processor` varchar(30) DEFAULT NULL,
  `buydate` date DEFAULT NULL,
  `purchaseprice` double DEFAULT NULL,
  `selldate` date DEFAULT NULL,
  `coustomername` varchar(30) DEFAULT NULL,
  `coustomeraddress` varchar(50) DEFAULT NULL,
  `sellprice` double DEFAULT NULL,
  `coustomermobileno` varchar(15) DEFAULT NULL,
  `currentstatus` varchar(30) DEFAULT NULL CHECK (`currentstatus` in ('Available','Sold'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mobile_shop`
--

INSERT INTO `mobile_shop` (`mobileid`, `brandname`, `modelname`, `ram`, `rom`, `processor`, `buydate`, `purchaseprice`, `selldate`, `coustomername`, `coustomeraddress`, `sellprice`, `coustomermobileno`, `currentstatus`) VALUES
(1, 'mi', 'redmi 5a', '4GB', '128GB', 'Snapdragon', '2022-02-20', 21000, '2022-05-10', 'salman', 'bhopal', 40000, '2300023434', 'Sold'),
(6, 'Sumsung', 'Note 10 pro', '6', '128', 'Snapdragon 8 pro', '2022-05-13', 20000, '2022-11-21', 'Sameer', 'bhopal', 30000, '9876534567', 'Sold'),
(7, 'mi', 'redmi 7', '4', '64', 'Snapdragon 8', '2022-09-08', 9000, '2022-11-22', 'Zoheb', 'bhopal', 20000, '9302555895', 'Sold'),
(8, 'realme', 'realme 8 pro', '4', '128', 'Snapdragon 8', '2022-08-01', 14000, '2022-11-01', 'Zoheb khan', 'Bhopal', 19000, '9021078345', 'Sold'),
(11, 'mi', 'redmi 6', '4', '64', 'Snapdragon 8', '2022-01-10', 11000, '2022-10-01', 'Aamir', 'bhopal', 33000, '9876', 'sold'),
(12, 'sumsung', 'note 3', '4', '128', 'Snapdragon 8 pro', '2022-02-15', 20000, '2022-11-01', ' shazeb', 'bhopal', 33000, '9876', 'sold'),
(13, 'realme', 'narzo 50a', '4', '64', 'Snapdragon 8 por', '2022-02-10', 19000, '2022-11-10', 'Saad', 'Faratabza, Bhopal', 35000, '98769876', 'sold'),
(14, 'vivo', 'vivo X pro', '12', '256', 'Snapdragon latest virsion', '2021-08-20', 30000, '2022-11-01', 'salman khan', 'bhopal', 50000, '9876567', 'sold'),
(15, 'mi', 'redmi 7 pro', '4', '128', 'Snapdragon ', '2022-07-10', 20000, '2022-11-01', 'Ajay', 'Raisen', 30000, '9876543456', 'sold'),
(16, 'Sumsung ', 'note 11', '8', '256', 'Snapdragon 8 pro', '2022-05-10', 20000, '2022-12-01', 'Rehan', 'Jahangirabad,Bhopal', 30000, '8765434567', 'Sold'),
(17, 'Realme', 'Narzo 30a', '6', '64', 'Snapdragon 8', '2022-09-10', 13000, '2022-12-01', 'Abdan', 'Khan', 20000, '23456765432', 'sold'),
(19, 'mi', 'redmi 5', '4', '128', 'Snapdragon 8', '2022-07-01', 21000, '2022-11-23', 'Sameer Khan', 'Jahangirabad, bhopal, MP', 12000, '9304666843', 'sold'),
(20, 'realme', 'realme 8', '4', '64', 'Snapdragon 8', '2022-06-06', 12000, '2022-11-22', 'Sakib khan', 'Jahangirabad, bhopal', 19000, '0293747543', 'Sold'),
(21, 'Realme', 'narzo 50A', '4', '64', 'Helio G8', '2022-08-01', 7000, '2022-12-03', 'Ajay', 'Delhi', 23000, '8765567821', 'Sold'),
(23, 'Lava', 'Lava 4', '3', '64', 'Snapdragon 5', '2022-08-02', 800, NULL, NULL, NULL, NULL, NULL, 'Available'),
(24, 'Vivo ', 'Vivo 7', '4', '128', 'Helio G20', '2022-08-08', 9000, '2022-12-01', 'shazeb', 'bhopal', 35000, '34567844', 'Sold'),
(25, 'mi', 'redmi 7', '4', '64', 'Snapdragon 8 pro', '2022-07-04', 9000, '2022-12-01', 'Faisal', 'Bhopal', 14000, '0938499923', 'sold'),
(26, 'VIvo ', 'Vivo 5', '4', '64', 'Snapdragon 8 pro', '2022-09-07', 9000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(27, 'mi', 'redmi 6', '4', '64', 'Snapdragon 8', '2022-11-01', 12000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(28, 'realmi', 'realme 8', '4', '64', 'Snapdragon 8', '2022-12-01', 14000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(29, 'realme', 'narzo 50a', '6', '256', ' Helio G8', '2022-11-01', 20000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(30, 'mi', 'note 11 pro', '6', '256', 'Helio G7', '2022-10-01', 19000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(31, 'Lava', 'Lava 5', '3', '32', 'Snapdragon 5', '2022-10-01', 7000, '2022-12-02', 'Sohal', 'Bhopal', 9000, '9876543', 'sold'),
(32, 'Realme', 'narzo 50a', '4', '128', ' Helio G9', '2022-09-12', 21000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(33, 'mi ', 'redmi 8', '3', '32', 'Snapdragon 8', '2022-11-01', 9000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(34, 'mi', 'redmi 9 pro', '6', '256', 'Snapdragon 9', '2022-10-01', 23000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(35, 'Apple', 'iphone 11 ', '4', '128', 'IOS 14', '2022-10-01', 50000, NULL, NULL, NULL, NULL, NULL, 'Available'),
(36, 'realme', 'realme 8', '4', '64', 'Snapdragon 8', '2022-11-01', 9000, NULL, NULL, NULL, NULL, NULL, 'Available');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mobile_shop`
--
ALTER TABLE `mobile_shop`
  ADD PRIMARY KEY (`mobileid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mobile_shop`
--
ALTER TABLE `mobile_shop`
  MODIFY `mobileid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
