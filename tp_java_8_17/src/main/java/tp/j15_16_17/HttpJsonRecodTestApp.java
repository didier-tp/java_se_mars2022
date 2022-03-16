package tp.j15_16_17;

public class HttpJsonRecodTestApp {

	public static void main(String[] args) {
		// autre exercice de synthese:
		
		//1 via l'api HttpClient , appeler en mode GET 
		//le web service REST dont l'URL est "https://catfact.ninja/fact"
		//Ce WS facile à appeler (sans api_key) retourne
		//une réponse au format JSON de type
		// { "fact" : "un fait sur les chats" , "length" :  21_ou_autre }
		
		//On pourra effectuer l'appel en mode synchrone ou bien en asynchrone via
		//client.sendAsync(req, BodyHandlers.ofString()).thenAccept(resp -> ...);
		//si mode asynchrone choisie prévoir pause d'attente en fin du main()

		//2. au sein de la callback appelée pour gérer la réponse on pourra:
		// transformer la réponse du format "jsonString" vers le format
		// instance de DTO.CatFact (record à coder avec propriétés .fact et .length )
		//en s'appuyant sur l'api jackson databind en version >= 2.12.0 gérant bien les "record"
		//catFact = jacksonObjectMapper.readValue(catFactAsJsonString,CatFact.class);
						
		//3. on affichera finalement les valeurs du DTO/record java construit via ... .toString()
		
	}

}
