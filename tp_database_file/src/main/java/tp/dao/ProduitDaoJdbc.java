package tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tp.data.Devise;
import tp.data.Produit;
import util.MyJdbcUtil;

public class ProduitDaoJdbc implements ProduitDao {
	
	//private String typeBase="mysql";
	private String typeBase="h2";

	
	@Override
	public Produit creerProduit(Produit p) {
		Connection cn = null;
		try {
			cn=MyJdbcUtil.etablishConnection(typeBase);
			cn.setAutoCommit(false);
			ResultSet rsKeys = null;
			Integer pk;
			String reqSql = "INSERT INTO produit(label , prix_ht, taux_tva) VALUES(?,?,?)";
			PreparedStatement pst = 
					cn.prepareStatement(reqSql,
							            Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getLabel()); //valeur de remplacement du premier ?
			pst.setDouble(2, p.getPrixHt()); //valeur de remplacement du second  ?
			pst.setDouble(3, p.getTauxTva()); //valeur de remplacement du troisieme ?
			pst.executeUpdate();
			rsKeys = pst.getGeneratedKeys();//r�cup�rer valeur clef primaire (ici numCpt)
			   if(rsKeys.next()){ 
				   pk= rsKeys.getInt(1);
				   p.setId(pk);
			   }
			cn.commit();
			//cn.rollback();
			 //fermetures dans l'ordre inverse des ouvertures
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}
		return p;
	}

	@Override
	public List<Produit> rechercherTousProduits() {
		List<Produit> listeProduits = new ArrayList<>();
		Connection cn = null;
		try {
			cn=MyJdbcUtil.etablishConnection(typeBase);
			Statement st = cn.createStatement();
			String reqSql = "SELECT * from produit";
			ResultSet rs = st.executeQuery(reqSql);
			while(rs.next()) {
				Produit produit = new Produit(rs.getInt("id"),
						                   rs.getString("label"),
						                   rs.getDouble("prix_ht"),
				                           rs.getDouble("taux_tva"));
			    listeProduits.add(produit);
			}
			rs.close(); //fermetures dans l'ordre inverse des ouvertures
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}
		return listeProduits;
	}

}
