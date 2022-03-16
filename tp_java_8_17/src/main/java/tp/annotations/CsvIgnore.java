package tp.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * 
 * @author developpeur_fou
 * 
 * annotation dont la presence sera testée au dessus d'un champ/attribut
 * de façon à ignorer le stockage de l'attribut dans une ligne de fichier CSV à générer
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface CsvIgnore {
   
}
