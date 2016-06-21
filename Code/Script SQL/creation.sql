-- CREATE DATABASE hilario IF NOT EXISTS

CREATE TABLE  IF NOT EXISTS  `personne`(
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(150) NOT NULL,
  `prenom` varchar(150) NOT NULL,
  `type` varchar(1) NOT NULL DEFAULT 'b',
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE  IF NOT EXISTS  `employee` (
  `identifiant` int(11) NOT NULL,
  `droits` varchar(1) DEFAULT NULL,
  `salaire` int(11) DEFAULT '0',
  KEY `identifiant` (`identifiant`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`identifiant`) REFERENCES `personne` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  IF NOT EXISTS  `commande` (
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `prix_negociee` int(11) NOT NULL,
  `identifiant_vendeur` int(11) NOT NULL,
  PRIMARY KEY (`identifiant`),
  KEY `identifiant_vendeur` (`identifiant_vendeur`),
  CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`identifiant_vendeur`) REFERENCES `personne` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  IF NOT EXISTS  `achat` (
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `identifiant_prop` int(11) NOT NULL,
  `identifiant_fournisseur` int(11) NOT NULL,
  PRIMARY KEY (`identifiant`),
  KEY `identifiant_prop` (`identifiant_prop`),
  KEY `identifiant_fournisseur` (`identifiant_fournisseur`),
  CONSTRAINT `achat_ibfk_1` FOREIGN KEY (`identifiant_prop`) REFERENCES `personne` (`identifiant`),
  CONSTRAINT `achat_ibfk_2` FOREIGN KEY (`identifiant_fournisseur`) REFERENCES `personne` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  IF NOT EXISTS  `chaussure` (
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `reference` varchar(25) NOT NULL,
  `prix_unitaire` float NOT NULL,
  `emplacement` varchar(25) NOT NULL,
  `identifiant_commande` int(11) NOT NULL,
  `identifiant_achatfrn` int(11) NOT NULL,
  PRIMARY KEY (`identifiant`),
  KEY `identifiant_commande` (`identifiant_commande`),
  KEY `identifiant_achatfrn` (`identifiant_achatfrn`),
  CONSTRAINT `chaussure_ibfk_1` FOREIGN KEY (`identifiant_commande`) REFERENCES `commande` (`identifiant`),
  CONSTRAINT `chaussure_ibfk_2` FOREIGN KEY (`identifiant_achatfrn`) REFERENCES `achat` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  IF NOT EXISTS  `factures` (
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `detail` text,
  `status` varchar(1) DEFAULT NULL,
  `identifiant_prop` int(11) NOT NULL,
  `montant` int(11) NOT NULL,
  PRIMARY KEY (`identifiant`),
  KEY `identifiant_prop` (`identifiant_prop`),
  CONSTRAINT `factures_ibfk_1` FOREIGN KEY (`identifiant_prop`) REFERENCES `personne` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
