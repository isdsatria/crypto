-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2023 at 03:40 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cashwallet`
--

-- --------------------------------------------------------

--
-- Table structure for table `cash_account`
--

CREATE TABLE `cash_account` (
  `account_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `cash_balance` decimal(15,2) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `reserved_balance` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cash_account`
--

INSERT INTO `cash_account` (`account_id`, `customer_id`, `cash_balance`, `date_created`, `reserved_balance`) VALUES
(1, 1, 16999999.96, '2023-04-20 17:00:00', 0),
(2, 2, 15000000.00, '2023-04-20 17:00:00', 0),
(5, 8, 15000000.00, '2023-04-20 17:00:00', 0),
(6, 3, 30000000.00, '2023-04-20 17:00:00', 0),
(7, 4, 2500000.00, '2023-04-20 17:00:00', 0),
(8, 5, 115000000.00, '2023-04-20 17:00:00', 0),
(9, 6, 232000000.00, '2023-04-20 17:00:00', 0),
(10, 7, 5203000000.00, '2023-04-20 17:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_history`
--

CREATE TABLE `transaction_history` (
  `transaction_history_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `transaction_type` varchar(10) NOT NULL,
  `transaction_amount` decimal(20,0) NOT NULL,
  `transaction_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction_history`
--

INSERT INTO `transaction_history` (`transaction_history_id`, `account_id`, `transaction_type`, `transaction_amount`, `transaction_date`) VALUES
(1, 1, 'Credit', 777778, '2023-04-21 21:56:45'),
(2, 1, 'Credit', 777778, '2023-04-27 13:08:29'),
(3, 1, 'Credit', 777778, '2023-04-27 13:11:31'),
(4, 1, 'Credit', 777778, '2023-04-27 14:54:21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cash_account`
--
ALTER TABLE `cash_account`
  ADD PRIMARY KEY (`account_id`),
  ADD UNIQUE KEY `customerId` (`customer_id`);

--
-- Indexes for table `transaction_history`
--
ALTER TABLE `transaction_history`
  ADD PRIMARY KEY (`transaction_history_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cash_account`
--
ALTER TABLE `cash_account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `transaction_history`
--
ALTER TABLE `transaction_history`
  MODIFY `transaction_history_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
