-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2023 at 08:15 AM
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
-- Database: `gpa`
--

-- --------------------------------------------------------

--
-- Table structure for table `semester1`
--

CREATE TABLE `semester1` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credits` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester1`
--

INSERT INTO `semester1` (`id`, `name`, `credits`) VALUES
('HS19151', 'Technical English', 3),
('MA19152', 'Linear Algebra and Applied Calculus', 4),
('CY19143', 'Applied Chemistry', 4),
('GE19141', 'Programming using C', 4),
('GE19122', 'Engineering Practices- Electrical and Electronics', 1),
('MC19102', 'Indian Constitution and Freedom Movement', 0);

-- --------------------------------------------------------

--
-- Table structure for table `semester2`
--

CREATE TABLE `semester2` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credits` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester2`
--

INSERT INTO `semester2` (`id`, `name`, `credits`) VALUES
('MA19252', 'Differential Equations and Complex Variables', 4),
('GE19101', 'Engineering Graphics', 4),
('PH19241', 'Physics for Information Science', 4),
('EE19242', 'Basic Electrical and Electronics Engineering', 4),
('CS19241', 'Data Structures', 5),
('GE19121', 'Engineering Practices-Civil and Mechanical', 1),
('CS19211', 'Python Programming Lab', 2),
('GE3152', 'Heritage of Tamil', 1),
('MC19101', 'Environmental Science and Engineering', 0);

-- --------------------------------------------------------

--
-- Table structure for table `semester3`
--

CREATE TABLE `semester3` (
  `id` varchar(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credits` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester3`
--

INSERT INTO `semester3` (`id`, `name`, `credits`) VALUES
('MA19354', 'Transforms and Discrete Mathematics', 4),
('CS19301', 'Computer Architecture', 3),
('EC19306', 'Communication Engineering', 3),
('CS19341', 'Design and Analysis of Algorithms', 4),
('EC19341', 'Digital Logic and Microprocessor', 5),
('CS19342', 'Object Oriented Programming Paradigm', 5),
('GE19307', 'Tamils and Technology', 1),
('MC19301', 'Essence of Indian Traditional Knowledge', 0);

-- --------------------------------------------------------

--
-- Table structure for table `semester4`
--

CREATE TABLE `semester4` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credits` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester4`
--

INSERT INTO `semester4` (`id`, `name`, `credits`) VALUES
('MA19454', 'Probability, Statistics and Queuing Theory', 4),
('GE19301', 'Life Science for Engineers', 3),
('CS19441', 'Operating Systems', 5),
('CS19442', 'Software Engineering Concepts', 5),
('CS19443', 'Database Management Systems', 5),
('GE19421', 'Soft Skills–I', 1);

-- --------------------------------------------------------

--
-- Table structure for table `semester5`
--

CREATE TABLE `semester5` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credits` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester5`
--

INSERT INTO `semester5` (`id`, `name`, `credits`) VALUES
('CS19501', 'Theory of Computation', 3),
('Professional Elective-I', 'Professional Elective-I', 3),
('Open Elective – I', 'Open Elective – I', 3),
('CS19541', 'Computer Networks', 5),
('CS19542', 'Internet Programming', 5),
('AI19341', 'Principles of Artificial Intelligence', 4),
('GE19521', 'Soft Skills-II', 1);

-- --------------------------------------------------------

--
-- Table structure for table `semester6`
--

CREATE TABLE `semester6` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credits` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester6`
--

INSERT INTO `semester6` (`id`, `name`, `credits`) VALUES
('CS19601', 'Fundamentals of Mobile Computing', 3),
('BA19602', 'Fundamentals of Accounting', 3),
('Professional Elective-II', 'Professional Elective-II', 3),
('CS19641', 'Compiler Design', 4),
('CS19642', 'Cryptography and Network Security', 3),
('CS19643', 'Foundations of Machine Learning', 4),
('CS19611', 'Mobile Application Development Laboratory', 2),
('CS19612', 'Innovative Project Lab for Computer Engineers', 2),
('GE19621', 'Problem Solving Techniques', 1);

-- --------------------------------------------------------

--
-- Table structure for table `semester7`
--

CREATE TABLE `semester7` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credits` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester7`
--

INSERT INTO `semester7` (`id`, `name`, `credits`) VALUES
('Professional Elective-III', 'Professional Elective-III', 3),
('Professional Elective-IV', 'Professional Elective-IV', 3),
('Professional Elective-V', 'Professional Elective-V', 3),
('CS19721', 'Block Chain Fundamentals', 1),
('CS19741', 'Cloud Computing', 3),
('CS19711', 'Project-I', 3);

-- --------------------------------------------------------

--
-- Table structure for table `semester8`
--

CREATE TABLE `semester8` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `credits` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester8`
--

INSERT INTO `semester8` (`id`, `name`, `credits`) VALUES
('Professional Elective-VI', 'Professional Elective-VI', 3),
('Open Elective-II', 'Open Elective-II', 3),
('CS19811', 'Project-II', 6);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
