package tp;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import tp.data.Produit;
import tp.data.Stat;
import util.MyCsvUtil;

public class FileApp {
	
	

	public static void main(String[] args) {
		// lire le fichier produits.csv et remonter le contenu dans une collection de String
		List<String> listeLignes = new ArrayList<>();
		try {
			FileInputStream ifile = new FileInputStream("produits.csv"); 
			//sera recherché à la racine du projet eclipse tpJavaMaven
			
			//BufferedReader dis =  new BufferedReader(new InputStreamReader(ifile));
			Scanner scanner = new Scanner(ifile);
			
			String ligneLue="";
			while (ligneLue!=null) {
				   if(scanner.hasNext()) {
				       ligneLue=scanner.nextLine();//better than .next() if space in value
				       //System.out.println("ligneLue="+ligneLue);
				   }
				   else ligneLue=null; 
			       //ligneLue = dis.readLine(); // lecture d'une ligne dans le fichier
			       //ajouter ligneLue dans listeLignes
			       if(ligneLue!=null)
			    	   listeLignes.add(ligneLue);
			}
			//dis.close();
			scanner.close();
			ifile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*//version simplifiée via nio (classes java plus récentes)
		try {
			listeLignes = Files.readAllLines(
					FileSystems.getDefault().getPath("produits.csv"), StandardCharsets.UTF_8);
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
		
		// transformer la liste de lignes lues (List<String>) en liste de produit (List<Produit>)
		List<Produit> listeProduits = new ArrayList<>();
		listeLignes.remove(0);//on ignore la première ligne lue
		for(String ligne : listeLignes  ) {
			String[] parties = ligne.split(";");
			//parties[0] : valeur de l'id , Integer.parseInt()
			//parties[1] : valeur du label , 
			//parties[2] : valeur du prixHt , Double.parseDouble()
			//parties[3] : valeur du tauxTva , Double.parseDouble()	
			Produit produit = new Produit();
			produit.setId(Integer.parseInt(parties[0])); 
			produit.setLabel(parties[1]);
			produit.setPrixHt(Double.parseDouble(parties[2]));
			produit.setTauxTva(Double.parseDouble(parties[3]));
			listeProduits.add(produit);
		}
		// via une boucle for , on calculera la somme des prix
		double prixTotalHt=0.0;
		double prixTotalTtc=0.0;
		double prixHtCarreTotal=0.0;
		double prixTtcCarreTotal=0.0;
		for(Produit prod : listeProduits) {
			prixTotalHt+=prod.getPrixHt(); //prixTotal=prixTotal+prod.getPrixHt(); 
			prixHtCarreTotal+=(prod.getPrixHt() * prod.getPrixHt());
			double prixTtc= prod.getPrixHt() * (1+ prod.getTauxTva()/100.0);
			prixTotalTtc+=prixTtc;
			prixTtcCarreTotal+=prixTtc*prixTtc;
		}
		Stat statHt = new Stat();		statHt.setLabel("statHt");
		statHt.setSomme(prixTotalHt);   statHt.setMoyenne(prixTotalHt/listeProduits.size());
		statHt.setEcartType(Math.sqrt(prixHtCarreTotal/listeProduits.size() - Math.pow(statHt.getMoyenne(),2)));      
		Stat statTtc = new Stat("statTtc",prixTotalTtc,prixTotalTtc/listeProduits.size(),
				Math.sqrt(prixTtcCarreTotal/listeProduits.size() - Math.pow(prixTotalTtc/listeProduits.size(),2)));
		List<Stat> listeStats = new ArrayList<>();
		listeStats.add(statHt); 	listeStats.add(statTtc); 
		MyCsvUtil.writeValuesAsCsvFile(listeStats,"stats.csv");
		
		List<Produit> listeProduitsApresSolde = new ArrayList<>();
		for(Produit p : listeProduits) {
			listeProduitsApresSolde.add(new Produit(p.getId(),p.getLabel(),p.getPrixHt()*0.5,p.getTauxTva()));//solde de 50%
		}
		MyCsvUtil.writeValuesAsCsvFile(listeProduitsApresSolde,"produitsApresSoldes.csv");
		//serialisationXmlViaJaxb2(listeProduitsApresSolde.get(0));
		
		//générer un fichier produits.json dans le format JSON .
		try {
			ObjectMapper objMapperJackson = new ObjectMapper();
			String listeProduitsAsJsonString = objMapperJackson.writeValueAsString(listeProduits);
			//equivalent java de JSON.stringify()
			/*
			Produit[] tabProduits = objMapperJackson.readValue(listeProduitsAsJsonString, Produit[].class);
			//equivalent java de JSON.parse()
			for(Produit p: tabProduits)
			    System.out.println("p="+p);
			*/
			System.out.println("listeProduitsAsJsonString="+listeProduitsAsJsonString);
			
			FileOutputStream of = new FileOutputStream("produits.json");
			objMapperJackson.writeValue(of, listeProduits);
			of.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		// afficher la somme des prix à l'écran
		System.out.println("prixTotalHt="+prixTotalHt);
		
		//Tp falculatif , générer un fichiers stats.txt
		//qui comporte la ligne prixTotal=...
		try {
			FileOutputStream of = new FileOutputStream("stats.txt"); //ce fichier sera visible après un refresh
			PrintStream ps = new PrintStream(of);
			ps.println("prixTotal (HT)="+prixTotalHt);
			ps.println("prixTotal (ttc)="+prixTotalTtc);
			ps.close(); of.close();// fermetures dans l'ordre inverse des ouvertures:
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
