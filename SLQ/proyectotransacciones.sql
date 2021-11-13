-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-11-2021 a las 23:21:51
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectotransacciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

DROP TABLE IF EXISTS `compras`;
CREATE TABLE IF NOT EXISTS `compras` (
  `ID` int(100) NOT NULL AUTO_INCREMENT,
  `DNI` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `CodigoProducto` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `Precio` float NOT NULL,
  `Puntos` int(100) NOT NULL,
  `FechaCompra` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Comprador` (`DNI`),
  KEY `ProductoComprado` (`CodigoProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`ID`, `DNI`, `CodigoProducto`, `Precio`, `Puntos`, `FechaCompra`) VALUES
(3, '123', '0432-IU', 1.99, 90, '2021-11-09'),
(4, '123', '0382-AP', 3.85, 120, '2021-11-09'),
(5, '123', '0382-AP', 3.85, 120, '2021-11-09'),
(6, '123', '0721-HI', 4.11, 280, '2021-11-09'),
(7, '123', '0872-LK', 10.95, 400, '2021-11-09'),
(8, '123', '0872-LK', 10.95, 400, '2021-11-09'),
(9, '123', '0872-LK', 10.95, 400, '2021-11-09'),
(12, '123', '0872-LK', 10.95, 400, '2021-11-09'),
(13, '123', '0872-LK', 10.95, 400, '2021-11-09'),
(15, '123', '1123-ER', 1.08, 130, '2021-11-10'),
(16, '123', '0382-AP', 3.85, 120, '2021-11-10'),
(17, '123', '0382-AP', 3.85, 120, '2021-11-10'),
(18, '123', '0382-AP', 3.85, 120, '2021-11-10'),
(19, '123', '0721-HI', 4.11, 280, '2021-11-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ewallet`
--

DROP TABLE IF EXISTS `ewallet`;
CREATE TABLE IF NOT EXISTS `ewallet` (
  `DNI` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `Saldo` float NOT NULL,
  `Puntos` int(100) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `ewallet`
--

INSERT INTO `ewallet` (`DNI`, `Saldo`, `Puntos`) VALUES
('123', 16.3, 255),
('12345678A', 0, 0),
('22222222P', 0, 0),
('43434343T', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `Codigo` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `Nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Precio` float NOT NULL,
  `Puntos` int(100) NOT NULL,
  `cantidad` int(50) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Codigo`, `Nombre`, `Precio`, `Puntos`, `cantidad`) VALUES
('0382-AP', 'Naranjas 4Kg', 3.85, 120, 11),
('0432-IU', 'Jamón cocido 125g', 1.99, 90, 19),
('0531-PU', 'Lechuga romana', 1.39, 120, 8),
('0721-HI', 'Pechuga de pavo', 4.11, 280, 30),
('0872-LK', 'Rabo vacuno 1Kg', 10.95, 400, 9),
('0927-FI', 'Pan de perrito 6Ud', 1.65, 100, 33),
('1123-ER', 'Ensalada gourmet', 1.08, 130, 14),
('1233-LH', 'Setas enteras 300g', 2.99, 200, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `DNI` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `Nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Apellidos` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `correo` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `FechaNacimiento` date NOT NULL,
  `Password` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Posicion` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`DNI`, `Nombre`, `Apellidos`, `correo`, `FechaNacimiento`, `Password`, `Posicion`) VALUES
('123', 'Victor', 'Perez Villanueva', 'PedritoElCrack@gmail.com', '1999-01-01', '123', 'ClienteAdministrador'),
('12345678A', 'Guille', 'Guillamon', '', '2000-04-02', '123', 'Cliente'),
('22222222P', 'Yoel', 'Ikea', '', '1970-04-02', '123', 'Administrador'),
('43434343T', 'Isak', 'Isak', '', '1991-11-02', '123', 'Cliente');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `Comprador` FOREIGN KEY (`DNI`) REFERENCES `usuarios` (`DNI`),
  ADD CONSTRAINT `ProductoComprado` FOREIGN KEY (`CodigoProducto`) REFERENCES `productos` (`Codigo`);

--
-- Filtros para la tabla `ewallet`
--
ALTER TABLE `ewallet`
  ADD CONSTRAINT `Propietario` FOREIGN KEY (`DNI`) REFERENCES `usuarios` (`DNI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
