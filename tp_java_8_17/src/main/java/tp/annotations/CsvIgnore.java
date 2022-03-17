package tp.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author developpeur_fou
 * 
 * annotation dont la presence sera testée au dessus d'un champ/attribut
 * de façon à ignorer le stockage de l'attribut dans une ligne de fichier CSV à générer
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CsvIgnore {

}
