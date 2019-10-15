-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2019 at 02:43 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oms`
--

-- --------------------------------------------------------

--
-- Table structure for table `certificate`
--

CREATE TABLE `certificate` (
  `certificate_id` int(11) NOT NULL,
  `certificate_name` varchar(50) NOT NULL,
  `certificate_amount` decimal(18,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `certificate`
--

INSERT INTO `certificate` (`certificate_id`, `certificate_name`, `certificate_amount`) VALUES
(1, 'Rock Certificate', '100.00'),
(2, 'Delivery Receipt', '200.00'),
(3, 'Mine Minerals Extraction Certificate', '500.00'),
(4, 'Document Stamp', '10.00');

-- --------------------------------------------------------

--
-- Table structure for table `order_payment`
--

CREATE TABLE `order_payment` (
  `order_id` int(11) NOT NULL,
  `entity_name` varchar(50) NOT NULL,
  `serial_no` varchar(50) NOT NULL,
  `fund_cluster` varchar(50) NOT NULL,
  `date_encoded` varchar(50) NOT NULL,
  `payor_name` varchar(50) NOT NULL,
  `payor_address` varchar(50) NOT NULL,
  `certificate_name` varchar(50) NOT NULL,
  `certificate_amount` decimal(18,2) NOT NULL,
  `prepared_by` varchar(50) NOT NULL,
  `approved_by` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_payment`
--

INSERT INTO `order_payment` (`order_id`, `entity_name`, `serial_no`, `fund_cluster`, `date_encoded`, `payor_name`, `payor_address`, `certificate_name`, `certificate_amount`, `prepared_by`, `approved_by`, `status`) VALUES
(2, 'CERT-001', '10152019', 'OLAP', '2019-10-15', 'Reynand', 'Cebu City', 'Rock Certificate', '100.00', 'Encoder1', '1', 'APPROVED'),
(3, 'CERT-002', '10152019', 'OLAP', '2019-10-15', 'Reynand', 'Cebu City', 'Document Stamp', '10.00', 'Encoder1', '', 'DECLINED');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `enabled` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `name`, `enabled`, `role`) VALUES
('1', '1', '1', '1', 'ROLE_ADMIN'),
('2', '2', '2', '2', 'ROLE_USER'),
('3', '3', '3', '1', 'ROLE_ADMIN'),
('Encoder1', '1234', 'Encoder Encoder', '1', 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `certificate`
--
ALTER TABLE `certificate`
  ADD PRIMARY KEY (`certificate_id`);

--
-- Indexes for table `order_payment`
--
ALTER TABLE `order_payment`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `certificate`
--
ALTER TABLE `certificate`
  MODIFY `certificate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `order_payment`
--
ALTER TABLE `order_payment`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
