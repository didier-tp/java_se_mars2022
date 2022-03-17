drop table if exists devise;
drop table if exists produit;
create table devise(code varchar(8) not null primary key,
                   monnaie varchar(128) not null,
                   d_change double);
     
CREATE TABLE produit(
    id INTEGER auto_increment ,
	label VARCHAR(64),
	prix_ht double,
	taux_tva double,
	PRIMARY KEY(id));                   
                   
insert into devise(code,monnaie,d_change) values('EUR','euro',0.9);
insert into devise(code,monnaie,d_change) values('USD','dollar',1);
insert into devise(code,monnaie,d_change) values('JPY','yen',125);
insert into devise(code,monnaie,d_change) values('GBP','livre',0.8);

INSERT INTO produit (label , prix_ht, taux_tva) VALUES ('prod_A',10.78,20.0);
INSERT INTO produit (label , prix_ht, taux_tva) VALUES ('prod_B',7.78,20.0);

select * from devise;
SELECT * FROM produit;

	