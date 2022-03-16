package tp.j15_16_17;

public class TestTextBlocApp {

	public static void main(String[] args) {
		oldStyleWithoutTextBloc();
		newStyleWithTextBloc();
		someTextBlocs();
		textBlocsWithFormattedParams();
	}
	
	public static void oldStyleWithoutTextBloc() {
		String myJsonString 
		  = "{\r\n" + "\"username\" : \"JeanBon\",\r\n" + "\"country\" : \"France\"\r\n" + "}";
		System.out.println("myJsonString="+myJsonString);
	}
	
    public static void newStyleWithTextBloc() {
    String myJsonStringAsTextBloc = """
    		{
    		"username" : "AlexTherieur",
    		"country" : "Belgique"
    		}
    		""";
	System.out.println("myJsonStringAsTextBloc="+myJsonStringAsTextBloc);
	}
    
    public static void someTextBlocs() {
    	//au minimum 2 lignes de code :
    	//    """ suivi de newligne pour commencer
    	//    texte quelconque au milieu
    	//    """; pour finir
    	String simpleTextBloc0 = """
    	blabla""";
    	System.out.println("simpleTextBloc0="+simpleTextBloc0);
    	
    	//pas bien:
    	String simpleTextBloc1AvecEspacesSurDebutLigne2 = """
		        { "username" : "AlexTherieur", "country" : "Belgique" }
    			""";
		System.out.println("simpleTextBloc1AvecEspacesSurDebutLigne2="+simpleTextBloc1AvecEspacesSurDebutLigne2);
    	
		//bien:
		String simpleTextBloc2AvecTabulationSurDebutLigne2 = """
				{ "username" : "AlexTherieur", "country" : "Belgique" }
				""";
		System.out.println("simpleTextBloc2AvecTabulationSurDebutLigne2="+simpleTextBloc2AvecTabulationSurDebutLigne2);
	
		//pour bien controller l'intentation , il faut savoir que lorsque le compilateur va analyser
		//le code source, il va supprimer le nombre minimum de tabulations qu'il y a
		//au niveau de toutes les lignes de code (du textBloc sans tenir compte du tout début =""") 
		//Bonne pratique : au sens IDE (eclipse/IntelliJ/...) placer des tabulations pour indenter le code
		//                 au sens contenu final du textBloc , utiliser plutôt des espaces et sauts de lignes
		//                 placer la fin """ sur une ligne séparée 
		//                 (comportant le nombre de tabulations qui seront explicitement supprimées du texte)
		String textBloc3AvecIndentationControlee = """
				{ 
				  "username" : "AlexTherieur", 
				  "country" : "Belgique" 
				}
				""";
		System.out.println("textBloc3AvecIndentationControlee="+textBloc3AvecIndentationControlee);
				
		//par défaut les espaces en fin de ligne sont considérés inutiles et ne sont pas conservés
		//le caractère d'échappement \s permet d'explicitement demander à conserver les espaces en fin de ligne
		String textBloc4AvecEspacesConservesEnFinDeLignes = """
				blabla     \s""";
		System.out.println("textBloc4AvecEspacesConservesEnFinDeLignes="
				           +textBloc4AvecEspacesConservesEnFinDeLignes + "suiteApres");
				
    }
    
    public static void textBlocsWithFormattedParams() {
    	String username="toto";
    	int age=40;
    	double height = 1.73;
    	boolean ok=true;
    	String jsonString = """
				{ 
				  "username" : "%s", 
				  "age" : %d,
				  "height" : %s,
				  "ok" : %b 
				}
				""".formatted(username,age,String.valueOf(height),ok); //same syntax of String.format 
		System.out.println("jsonString="+jsonString);
			
    }

}
