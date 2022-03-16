package tp.thread.sam;

//interface d'une reférence de fonction pour calcul ordinaire de somme ou moyenne ou  ...
public interface SequentialComputing {
	//start et end sont les indices sur la plage du tableau à manipuler .
	//arg = null ou éventuel argument nécessaire à un  calcul (ex: arg=moyenne pour calcul de variance)
	double basicCompute(double[] numbers, int start, int end,Double arg); //sum or average or ....
}
