-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2025 a las 12:41:33
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `eventos_kodegune`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `fechai` date NOT NULL,
  `eventotrans` tinyint(1) NOT NULL DEFAULT 0,
  `eventoseg` tinyint(1) NOT NULL DEFAULT 0,
  `eventodiseno` tinyint(1) NOT NULL DEFAULT 0,
  `eventonet` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripciones`
--

INSERT INTO `inscripciones` (`id`, `nombre`, `apellidos`, `email`, `telefono`, `fechai`, `eventotrans`, `eventoseg`, `eventodiseno`, `eventonet`) VALUES
(1, 'Sara', 'Rodriguez Lopez', 'sararodriguezlopez88@gmail.com', '546657768', '2025-11-21', 1, 1, 0, 0),
(2, 'Pablo', 'Anula De Dios', 'pabloanuladedios@gmail.com', '890667755', '2025-11-13', 1, 0, 1, 0),
(3, 'Alexander', 'Echeveste Velasco', 'al.echeveste@nazaret.team', '123456789', '2025-11-11', 1, 1, 1, 0),
(4, 'Sebastian', 'Gonzales Gonzales', 'se.gonzales@nazaret.team', '677889900', '2025-11-29', 1, 0, 1, 0),
(5, 'Kevin', 'Gonzalez Gonzalez', 'ke.gonzalez@nazaret.team', '334556688', '2025-11-29', 0, 1, 0, 0),
(6, 'Laura', 'Rodriguez Hernandez', 'laurarodri@gmail.com', '655443322', '2025-11-15', 0, 1, 0, 1),
(7, 'Juan', 'López Rodríguez', 'juanlopezrodri@gmail.com', '699006677', '2025-11-29', 1, 0, 0, 0),
(8, 'Maialen', 'Arano Etxebeste', 'maialenarano@gmail.com', '556002211', '2025-11-28', 0, 0, 1, 0),
(9, 'Naiara', 'Suescun Beloki', 'naiarasuescunb@gmail.com', '655444455', '2025-11-30', 1, 1, 1, 1),
(10, 'Iker', 'Martin López', 'ikermartinlo@gmail.com', '677884455', '2025-11-30', 0, 1, 1, 0),
(11, 'Mikel', 'Sanchez Hernandez', 'mikelsannn@gmail.com', '677442211', '2025-11-28', 0, 1, 1, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
