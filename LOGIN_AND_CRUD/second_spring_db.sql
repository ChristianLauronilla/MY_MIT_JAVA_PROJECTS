-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2019 at 03:25 PM
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
-- Database: `second_spring_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `gender`
--

CREATE TABLE `gender` (
  `id` int(11) NOT NULL,
  `gender` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gender`
--

INSERT INTO `gender` (`id`, `gender`) VALUES
(1, 'Male'),
(2, 'Female'),
(3, 'Not Sure'),
(4, 'Complicated');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `location` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`location_id`, `location`, `status`) VALUES
(1, 'Garage 1', 'Active'),
(2, 'Front Door', 'Active'),
(3, 'Warehouse 1', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `email_address` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `gender` varchar(15) DEFAULT '',
  `birthday` varchar(15) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`email_address`, `name`, `gender`, `birthday`, `address`) VALUES
('e5@g.com', 'E', 'Not Sure', '2012-01-01', 'Cebu City'),
('eee@address.com', 'eee', '', '2019-01-01', 'dkshdkjshd'),
('email1@address.com', 'Rico Tree', '', '1986-10-16', 'Cebu City'),
('email1@address.coms', 'male', NULL, '2019-01-01', 'sasa'),
('email2@address.com', 'Rey', '', '2001-01-01', 'Carcar City'),
('email@address.com', 'Ryan', '', '2001-12-31', 'Cebu City'),
('email@address1.com', 'jhj', 'Male', '2014-01-01', 'jkhjkhk'),
('email@address2.com', 'jhj', 'Male', '2014-01-01', 'jkhjkhk'),
('forupdate@email.com', 'Boboy', '', '2019-12-31', 'Cebu City'),
('sassasaa@dsds.com', 'male', NULL, '2019-01-01', 'sads'),
('tags1@email.com', 'Tag', '', '2003-01-01', 'Cebu City'),
('tags@email.com', 'Tag', '', '2003-01-01', 'Cebu City'),
('tags@emasasail.com', 'male', NULL, '2019-01-01', 'sasasa');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 0,
  `role` varchar(15) NOT NULL DEFAULT 'ROLE_USER'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `name`, `enabled`, `role`) VALUES
('2', '2', '2', 1, 'ROLE_USER'),
('admin', 'admin', 'Admin', 1, 'ROLE_ADMIN'),
('lasttest', 'lasttest', 'lasttest', 1, 'ROLE_ADMIN'),
('test', 'test', 'test', 1, 'ROLE_ADMIN'),
('test1', 'test1', 'test1', 1, 'ROLE_USER'),
('testset', 'testset', 'testset', 1, 'ROLE_USER'),
('yow', 'yow', 'yow', 1, 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`email_address`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gender`
--
ALTER TABLE `gender`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `location_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
