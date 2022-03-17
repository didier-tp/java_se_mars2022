CREATE DATABASE IF NOT EXISTS deviseDBMySql ;
use deviseDBMySql;

DROP TABLE IF EXISTS devise;

DROP TABLE IF EXISTS produit;


######################## CREATE  TABLE ########################################

CREATE TABLE devise(
	code VARCHAR(8),
	monnaie VARCHAR(64),
	d_change double,
	
	PRIMARY KEY(code));	
	
CREATE TABLE produit(
    id INTEGER auto_increment ,
	label VARCHAR(64),
	prix_ht double,
	taux_tva double,
	
	PRIMARY KEY(id));	

#########################  INSERT INTO   #####################################

INSERT INTO devise (code,d_change,monnaie) VALUES ('EUR',1,'euro');
INSERT INTO devise (code,d_change,monnaie) VALUES ('JPY',123.8,'yen');
INSERT INTO devise (code,d_change,monnaie) VALUES ('USD',1.1,'dollar');
INSERT INTO devise (code,d_change,monnaie) VALUES ('GBP',0.9,'livre');


INSERT INTO produit (label , prix_ht, taux_tva) VALUES ('prod_A',10.78,20.0);
INSERT INTO produit (label , prix_ht, taux_tva) VALUES ('prod_B',7.78,20.0);

####### VERIF ######

show tables;
SELECT * FROM devise;
SELECT * FROM produit;
