-- CREATE DATABASE hilario IF NOT EXISTS

CREATE TABLE IF NOT EXISTS  personne(
  identifiant int(11) NOT NULL AUTO_INCREMENT,
  nom varchar(150) NOT NULL,
  prenom varchar(150) NOT NULL,
  mot_passe varchar(150) DEFAULT 'nada' ,
  type varchar(1) NOT NULL DEFAULT 'z',
  PRIMARY KEY (identifiant)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS  employee(
  identifiant int(11) NOT NULL,
  droits varchar(1) DEFAULT NULL,
  salaire int(11) DEFAULT '0',
  PRIMARY KEY(identifiant),
  FOREIGN KEY(identifiant) REFERENCES personne(identifiant)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS  commande(
  identifiant int(11) NOT NULL AUTO_INCREMENT,
  date datetime NOT NULL,
  prix_negociee int(11) NOT NULL,
  identifiant_vendeur int(11) NOT NULL,
  PRIMARY KEY (identifiant),
  FOREIGN KEY (identifiant_vendeur) REFERENCES personne(identifiant)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE  IF NOT EXISTS  achat(
  identifiant int(11) NOT NULL AUTO_INCREMENT,
  date datetime NOT NULL,
  identifiant_prop int(11) NOT NULL,
  identifiant_fournisseur int(11) NOT NULL,
  PRIMARY KEY (identifiant),
  FOREIGN KEY (identifiant_prop) REFERENCES personne(identifiant),
  FOREIGN KEY (identifiant_fournisseur) REFERENCES personne(identifiant)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS local(
  nom VARCHAR(50) NOT NULL,
  defaut boolean NOT NULL,
  PRIMARY KEY (nom)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS chaussure(
  identifiant int(11) NOT NULL AUTO_INCREMENT,
  reference varchar(25) NOT NULL,
  prix_unitaire float NOT NULL,
  nom_local VARCHAR(50) NOT NULL,
  identifiant_commande int(11) NOT NULL,
  identifiant_achatfrn int(11) NOT NULL,
  PRIMARY KEY (identifiant),
  FOREIGN KEY (nom_local) REFERENCES local(nom),
  FOREIGN KEY (identifiant_commande) REFERENCES commande(identifiant),
  FOREIGN KEY (identifiant_achatfrn) REFERENCES achat(identifiant)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS factures(
  identifiant int(11) NOT NULL AUTO_INCREMENT,
  date date NOT NULL,
  detail text,
  status varchar(1) DEFAULT NULL,
  identifiant_prop int(11) NOT NULL,
  montant int(11) NOT NULL,
  PRIMARY KEY (identifiant),
  FOREIGN KEY (identifiant_prop) REFERENCES personne(identifiant)
) ENGINE=InnoDB CHARSET=utf8;
