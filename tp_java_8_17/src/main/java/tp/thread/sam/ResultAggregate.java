package tp.thread.sam;
//interface d'une reférence de fonction pour recombiner 2 sous sommes ou 2 sous moyennes
public interface ResultAggregate {
	Double composeTotalRes(double res_tab1, int taille_tab1,double res_tab2, int taille_tab2);
}
