package tp.j15_16_17;

//NB: "SEALED" signifiant scelé en francais 
//est une nouveauté du langage java permettant d'indiquer que seules certaines classes
//(précisées par permits ... , ... )
//auront le droit d'hériter de la classe ou interface actuelle
//cela ressemble à final class qui interdit carrément tout héritage

//sealed keyword can be used if option "enabled preview features for java 16"
public sealed interface AnimalDomestique permits Chat, Chien {
	public void sayHello();
	//...
}

/*
//HERITAGE via extends ou implements INTERDIT via sealed sur AnimalDomestique :
final class Cc implements  AnimalDomestique{
//...	
}
*/