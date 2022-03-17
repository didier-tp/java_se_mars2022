package tp;

public class CodeTraitement implements Runnable{
	
	private final int coeff; //partagé et constant
	private int compteurPartage=0;//partagé et modifiable (par les différents Threads)
	

	public CodeTraitement(int coeff) {
		super();
		this.coeff = coeff;
	}


	public CodeTraitement() {
		super();
		this.coeff =1;
	}



	@Override
	public void run() {
		//chaque Thread qui execute ce code aura sa propre pile
		//et donc ses propres versions des variables locales n et i
		int n=10;
		for(int i=0;i<n;i++) {
			//bloc "synchronized" pour verouiller this le temps de modifier le compteur partagé
			//chaque thread va executeer ce code en mode "un seul à la fois" (mode fiable).
			synchronized (this) {
				//debut de code synchronisé
				this.compteurPartage = this.compteurPartage + 1;
				System.out.println("i=" + i + " compteurPartage=" + this.compteurPartage + " sur instance " + this + " via Thread " + Thread.currentThread().getName());
				//fin de code synchronisé
			}
			
			try {
				Thread.sleep(500*this.coeff); //pause de 500ms (simuler un traitement long / bloquant)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//fin du code à executer par le thread .
	}



}
