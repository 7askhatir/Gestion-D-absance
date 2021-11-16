-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 08 Février 2021 à 10:57
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `absent`
--

-- --------------------------------------------------------

--
-- Structure de la table `absences`
--

CREATE TABLE IF NOT EXISTS `absences` (
  `idabsence` int(40) NOT NULL AUTO_INCREMENT,
  `idformateur` int(40) NOT NULL,
  `idapprenant` int(40) NOT NULL,
  `typeabs` varchar(40) NOT NULL,
  `dateabs` date NOT NULL,
  PRIMARY KEY (`idabsence`),
  KEY `formateur2` (`idformateur`),
  KEY `id_apprenant2` (`idapprenant`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `absences`
--

INSERT INTO `absences` (`idabsence`, `idformateur`, `idapprenant`, `typeabs`, `dateabs`) VALUES
(1, 1, 1, 'justife', '2021-01-06'),
(2, 1, 5, 'No justife', '2021-01-27'),
(3, 3, 1, 'No justife', '2021-01-05'),
(4, 2, 8, 'No justife', '2021-01-07');

-- --------------------------------------------------------

--
-- Structure de la table `apprenant`
--

CREATE TABLE IF NOT EXISTS `apprenant` (
  `iduser` int(11) NOT NULL,
  `nomuser` varchar(11) NOT NULL,
  `emailuser` varchar(100) NOT NULL,
  `passuser` varchar(11) NOT NULL,
  `promotion` int(40) NOT NULL,
  PRIMARY KEY (`iduser`),
  KEY `promotion` (`promotion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `apprenant`
--

INSERT INTO `apprenant` (`iduser`, `nomuser`, `emailuser`, `passuser`, `promotion`) VALUES
(0, 'khalidvvv', 'vvvvvvvvv', 'vvvvvvvvvvv', 0),
(1, 'khalid', 'askhatir7@g', '1234', 1),
(5, 'khalid 2', 'ccccccccccccc', 'ccccccc', 0),
(8, 'khalid', 'vvvvvvvvvvvc', 'qqqqqqq', 0);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

CREATE TABLE IF NOT EXISTS `promotion` (
  `idpromotion` int(40) NOT NULL,
  `nompromotion` varchar(40) NOT NULL,
  `annéepromotion` varchar(40) NOT NULL,
  `formateur` int(40) NOT NULL,
  PRIMARY KEY (`idpromotion`),
  KEY `formateur3` (`formateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `promotion`
--

INSERT INTO `promotion` (`idpromotion`, `nompromotion`, `annéepromotion`, `formateur`) VALUES
(0, 'pro 2', '2323', 2),
(1, 'FTTDR', '2323', 2),
(4, 'promo3', '2323', 2),
(10, 'promo 4', '2323', 2);

-- --------------------------------------------------------

--
-- Structure de la table `retar`
--

CREATE TABLE IF NOT EXISTS `retar` (
  `idretar` int(11) NOT NULL AUTO_INCREMENT,
  `duréretar` int(11) NOT NULL,
  `idformateur` int(11) NOT NULL,
  `idapprenant` int(11) NOT NULL,
  `jusif` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idretar`),
  KEY `formateur` (`idformateur`),
  KEY `id_apprenant` (`idapprenant`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `retar`
--

INSERT INTO `retar` (`idretar`, `duréretar`, `idformateur`, `idapprenant`, `jusif`) VALUES
(3, 3, 2, 1, 'No justife');

-- --------------------------------------------------------

--
-- Structure de la table `staf`
--

CREATE TABLE IF NOT EXISTS `staf` (
  `iduser` int(40) NOT NULL AUTO_INCREMENT,
  `nomuser` varchar(40) NOT NULL,
  `emailuser` varchar(40) NOT NULL,
  `passuser` varchar(40) NOT NULL,
  `typeuser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `staf`
--

INSERT INTO `staf` (`iduser`, `nomuser`, `emailuser`, `passuser`, `typeuser`) VALUES
(1, 'fatimazehra', 'fatimazehra@youcode.com', '1234', 'secrétaire'),
(2, 'hanae', 'hanae@youcode.com', '1234', 'staff'),
(3, 'khalid', 'askhatir7@gmail.com', '1234', 'aprenent');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `absences`
--
ALTER TABLE `absences`
  ADD CONSTRAINT `formateur2` FOREIGN KEY (`idformateur`) REFERENCES `staf` (`iduser`),
  ADD CONSTRAINT `id_apprenant2` FOREIGN KEY (`idapprenant`) REFERENCES `apprenant` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `apprenant`
--
ALTER TABLE `apprenant`
  ADD CONSTRAINT `promotion` FOREIGN KEY (`promotion`) REFERENCES `promotion` (`idpromotion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `formateur3` FOREIGN KEY (`formateur`) REFERENCES `staf` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `retar`
--
ALTER TABLE `retar`
  ADD CONSTRAINT `formateur` FOREIGN KEY (`idformateur`) REFERENCES `staf` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_apprenant` FOREIGN KEY (`idapprenant`) REFERENCES `apprenant` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
