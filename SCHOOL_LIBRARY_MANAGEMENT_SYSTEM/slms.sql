-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2019 at 04:26 AM
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
-- Database: `slms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `book_title` varchar(50) NOT NULL,
  `book_author` varchar(50) NOT NULL,
  `book_price` decimal(18,2) NOT NULL,
  `book_qty` int(11) NOT NULL,
  `book_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `book_title`, `book_author`, `book_price`, `book_qty`, `book_status`) VALUES
(2, 'In His Steps : Edition 1', 'Ablaze', '250.00', 9, 'Active'),
(4, 'Angels and Demons', 'Dan Brown', '500.00', 5, 'Active'),
(5, 'Davinci Code', 'Dan Brown', '750.00', 10, 'Active'),
(6, 'Digital Fortress', 'Dan Brown', '800.00', 15, 'Active'),
(7, 'End of watch', 'Stephen King', '500.00', 8, 'Active'),
(8, 'Revival', 'Stephen King', '550.00', 18, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
  `borrow_id` int(11) NOT NULL,
  `borrower_name` varchar(50) NOT NULL,
  `borrow_date` varchar(50) NOT NULL,
  `book_title` varchar(50) NOT NULL,
  `borrow_return_date` varchar(50) NOT NULL,
  `borrow_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`borrow_id`, `borrower_name`, `borrow_date`, `book_title`, `borrow_return_date`, `borrow_status`) VALUES
(10, '1', '10/10/19', 'End of watch', '2019-10-11', 'Returned'),
(11, 'borrower1', '2019-10-10', 'Angels and Demons', '2019-10-11', 'Returned'),
(12, 'borrower1', '2019-10-10', 'Revival', '2019-10-11', 'Returned'),
(13, 'borrower2', '2019-10-10', 'Davinci Code', '2019-10-11', 'Returned'),
(14, 'borrower3', '2019-10-10', 'Davinci Code', '2019-10-29', 'Returned');

-- --------------------------------------------------------

--
-- Table structure for table `borrower`
--

CREATE TABLE `borrower` (
  `borrower_id` int(11) NOT NULL,
  `borrower_name` varchar(50) NOT NULL,
  `borrower_address` varchar(50) NOT NULL,
  `borrower_type` varchar(50) NOT NULL,
  `borrower_added_date` varchar(50) NOT NULL,
  `borrower_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrower`
--

INSERT INTO `borrower` (`borrower_id`, `borrower_name`, `borrower_address`, `borrower_type`, `borrower_added_date`, `borrower_status`) VALUES
(7, 'Christian', 'Pardo, Cebu', 'Student', '2019-10-09', 'Active'),
(8, 'Jeramy M. Gella', 'Quiot, Pardo, Cebu City', 'Teacher', '2019-10-09', 'Active'),
(9, 'Chanix', 'Chanix', 'Student', '2019-10-10', 'Active'),
(10, 'borrower1', 'Cebu City', 'Other', '10/10/19', 'Active'),
(11, 'borrower2', 'Cebu', 'Student', '2019-10-10', 'Active'),
(12, 'borrower3', 'borrower3', 'Student', '2019-10-10', 'Active');

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
('1', '1', '1', '1', 'ROLE_USER'),
('admin', 'admin', 'admin', '1', 'ROLE_ADMIN'),
('borrower1', 'borrower1', 'borrower1', '1', 'ROLE_USER'),
('borrower2', 'borrower2', 'borrower2', '1', 'ROLE_USER'),
('borrower3', 'borrower3', 'borrower3', '1', 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
  ADD PRIMARY KEY (`borrow_id`);

--
-- Indexes for table `borrower`
--
ALTER TABLE `borrower`
  ADD PRIMARY KEY (`borrower_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `borrow`
--
ALTER TABLE `borrow`
  MODIFY `borrow_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `borrower`
--
ALTER TABLE `borrower`
  MODIFY `borrower_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
