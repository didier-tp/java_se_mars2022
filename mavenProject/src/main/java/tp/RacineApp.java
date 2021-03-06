package tp;

public class RacineApp {

	
	
	public static void main(String[] args) {
		// java tp.RacineApp 81 et ça calcule et affiche 9
		// java tp.RacineApp et ça doit afficher un message d'erreur manque un arg
		// java tp.RacineApp 6a et ça doit afficher un message d'erreur 6a pas numerique
		// java tp.RacineApp -16 et ça doit afficher un message d'erreur arg devant être positif
        String sVal=null;
		try {
			sVal = args[0];
			double val = Double.parseDouble(sVal);
	        double res = Math.sqrt(val);
	        System.out.println("la racinne carre de " + sVal +  "  est " + res);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("il manque un argument. Usage: java tp.RacineApp 81 ");
		}
		catch (NumberFormatException nfe) {
			System.err.println("Erreur, l'argument  " + sVal + " doit être numérique");
		}
        
	}
	
	public static double caculerRacineCarree(double x) {
		return Math.sqrt(x);
	}

}
