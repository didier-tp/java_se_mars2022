
TP_Decorateur_appliqué_au_caddy
===============================
* Modéliser l'essentiel de la structure du code "...Caddy , ...Deco , ..." sur
  un diagramme de classe UML
  
* Anlyser la classe de test "CaddyDecoTestApp"
  et EFFECTUER PLUSIEURS TESTS en SWITCHANT de ligne caddy = ...
  
TP_Visitor appliqué au dessin (swing , svg)
==========================================
* Analyser , comprendre et faire fonctionner l'exemple
  classe principale (avec main()) pour le démarrage: tp.dessin.app.FenetrePrincipale
  parties intéressantes: tp.dessin.fig et tp.dessin.ext (.swing et .svg)
                déclenchement dans tp.dessin.app.MyCanvas.paint()
                                et tp.dessin.app.OngletDessin.exporterSvg()
                                
TP_Observateur appliqué au second onglet de l'application de dessin
===================================================================
---> package tp.dessin.observateur et classe tp.dessin.app.OngletObservateurs

NB: AbstractSubject et IObserver sont des versions "maison" codées en quelques lignes
    java.util.Observable et java.util.Observer sont des équivalents prédéfinis
    du langage java 
                                