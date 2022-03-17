package tp;

import util.MyUtil;

public class DevinerNombreApp {

	public static void main(String[] args) {
		// jeux: faire deviner un nombre
		int nombreAdeviner = (int)(100 * Math.random());
		//MyUtil.display("nombreAdeviner="+nombreAdeviner);
        int valeurProposee =-1;
        int nbEssais = 0;
		//TP , via une boucle while , demande à l'utilisateur de saisir un nombre 
		//puis afficher , la valeur à deviner est plus petite ou plus grande.
        while(valeurProposee!=nombreAdeviner) {
        	nbEssais++;
        	valeurProposee=Integer.parseInt(MyUtil.input("nombre à deviner (entre 0 et 100):"));
        	if(valeurProposee>nombreAdeviner) {
        		MyUtil.display("valeur proposee trop grande");
        	}else if(valeurProposee<nombreAdeviner) {
        		MyUtil.display("valeur proposee trop petite");
        	}else if(valeurProposee==nombreAdeviner) {
        		MyUtil.display("bravo, vous avez deviné le nombre:"+nombreAdeviner + " en " + nbEssais +  " essai(s)");
        	}
        }
	}

}
