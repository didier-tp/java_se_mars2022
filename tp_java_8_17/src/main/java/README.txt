quelques soucis potentiels entre java16/17 , eclipse 2021_09 , lombok et module-info.java
NB: si module-info.java est présent tout devient plus rigoureux
et le code interne du module lombok a besoin d'accéder à notre code
pour découvrir les private par intropsection et genérer les get/set
---> besoin donc de exports tp.data;
	et              opens tp.data;