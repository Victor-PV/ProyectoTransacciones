-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 08-11-2021 a las 23:21:30
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

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
('123', 1200, 600),
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
('0382-AP', 'Naranjas 4Kg', 3.85, 120, 8),
('0432-IU', 'Jamón cocido 125g', 1.99, 90, 20),
('0531-PU', 'Lechuga romana', 1.39, 120, 0),
('0721-HI', 'Pechuga de pavo', 4.11, 280, 32),
('0872-LK', 'Rabo vacuno 1Kg', 0.95, 400, 17),
('0927-FI', 'Pan de perrito 6Ud', 1.65, 100, 33),
('1123-ER', 'Ensalada gourmet', 1.08, 120, 13),
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
('11111111D', 'asa', 'sas', '', '3804-05-02', '123', 'Cliente'),
('11111111F', 'Lucas', 'si', '', '3801-01-31', '123', 'Cliente'),
('11111111O', 'Lucas', 'Garin', '', '2001-04-02', '123', 'Cliente'),
('12121212A', 'Hugo', 'Si', '', '3803-04-01', '123', 'ClienteAdministrador'),
('12211212R', 'Pablo', 'Si', 'Pablo@gmail.com', '3862-05-01', '123', 'ClienteAdministrador'),
('123', '123', '123', NULL, '1999-01-01', '123', 'ClienteAdministrador'),
('22222222D', 'ded', 'ded', '', '3899-04-02', '123', 'Administrador'),
('34439012Y', 'Gustabo', 'Si', '', '3804-05-04', '123', 'Administrador'),
('43434343T', 'Isak', 'Isak', '', '1991-11-02', '123', 'Cliente'),
('54786345E', 'Fran', 'Alvarez', NULL, '2000-05-04', '123', 'Cliente'),
('89898989U', 'Juan', 'Garcia', 'Juanito@a.com', '1972-04-02', '123', 'Cliente');

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
