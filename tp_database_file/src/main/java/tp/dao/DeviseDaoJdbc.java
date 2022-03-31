package tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tp.data.Devise;
import util.MyJdbcUtil;

public class DeviseDaoJdbc implements DeviseDao {
	
	//INSERT INTO devise (code,d_change,monnaie) VALUES ('EUR',1,'euro'); dans init_db.sql
	private String typeBase="mysql";
	//private String typeBase="h2";

	@Override
	public Devise creerDevise(Devise d) {
		Connection cn = null;
		try {
			cn=MyJdbcUtil.etablishConnection(typeBase);
			
			//Statement st = cn.createStatement();
			//String reqSql = "INSERT INTO devise(code,d_change,monnaie) VALUES('m1',12.4,'monnaie1')";
			//st.executeUpdate(reqSql);
			
			String reqSql = "INSERT INTO devise(code,d_change,monnaie) VALUES(?,?,?)";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setString(1, d.getCode()); //valeur de remplacement du premier ?
			pst.setDouble(2, d.getChange()); //valeur de remplacement du second  ?
			pst.setString(3, d.getNom()); //valeur de remplacement du troisieme ?
			pst.executeUpdate();
			 //fermetures dans l'ordre inverse des ouvertures
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}
		return d;
	}

	@Override
	public Devise rechercherDevise(String code) {
		Devise devise = null;
		Connection cn = null;
		try {
			cn=MyJdbcUtil.etablishConnection(typeBase);
			String reqSql = "SELECT * FROM devise WHERE code=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setString(1, code);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				devise = new Devise(rs.getString("code"),
						            rs.getString("monnaie"),
						            rs.getDouble("d_change"));
			}
			rs.close(); //fermetures dans l'ordre inverse des ouvertures
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}
		return devise;
	}

	@Override
	public List<Devise> rechercherToutesDevises() {
		List<Devise> listeDevises = new ArrayList<>();
		Connection cn = null;
		try {
			cn=MyJdbcUtil.etablishConnection(typeBase);
			Statement st = cn.createStatement();
			String reqSql = "SELECT * from devise";
			ResultSet rs = st.executeQuery(reqSql);
			while(rs.next()) {
				Devise devise = new Devise(rs.getString("code"),
						                   rs.getString("monnaie"),
						                   rs.getDouble("d_change"));
			    listeDevises.add(devise);
			}
			rs.close(); //fermetures dans l'ordre inverse des ouvertures
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}
		return listeDevises;
	}

	@Override
	public void updateDevise(Devise d) {
		Connection cn = null;
		try {
			cn=MyJdbcUtil.etablishConnection(typeBase);
		
			String reqSql = "UPDATE devise SET d_change=? , monnaie=? WHERE code=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setString(3, d.getCode()); //valeur de remplacement du troisieme ?
			pst.setDouble(1, d.getChange()); //valeur de remplacement du premier  ?
			pst.setString(2, d.getNom()); //valeur de remplacement du  second  ?
			pst.executeUpdate();
			 //fermetures dans l'ordre inverse des ouvertures
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}
	}

	@Override
	public void supprimerDevise(String code) {
		Connection cn = null;
		try {
			cn=MyJdbcUtil.etablishConnection(typeBase);
		
			String reqSql = "DELETE FROM devise WHERE code=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setString(1, code); //valeur de remplacement du premier  ?
			pst.executeUpdate();
			 //fermetures dans l'ordre inverse des ouvertures
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}

	}

}
