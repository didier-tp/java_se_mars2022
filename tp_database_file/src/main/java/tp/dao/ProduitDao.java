package tp.dao;

import java.util.List;

import tp.data.Produit;

/*
 * DAO = Data Access Object (objet java spécialisé dans l'accès aux données)
 * avec méthodes "CRUD" (Create/Créer , Rechercher , Update , Delete)
 */
public interface ProduitDao {
     public Produit creerProduit(Produit p); //ajout en memoire ou INSERT INTO
     public List<Produit> rechercherTousProduits(); //SELECT SQL
}
