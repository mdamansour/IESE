package tp2auteurlivre;

public class Livre {
	private String titre;
	private int nbPage;
	private int annee;
	
	public Livre (String titre,int nbPage,int annee) {
		this.titre=titre;
		this.nbPage=nbPage;
		this.annee=annee;
	}
	public Livre () {
		this.titre="Pas de titre";
		this.nbPage=0;
		this.annee=00;
	}
	String getTitre() {return titre;}
	int getNbpage() {return nbPage;}
	int getAnnee() {return annee;}
	void setTitre(String titre) {this.titre=titre;}
	void setNbpage(int nbPage) {this.nbPage=nbPage;}
	void setAnnee(int annee) {this.annee=annee;}
	
	public String toString() {
		return "Le titre du livre est '"+titre+"', son nombre de page est "+nbPage+" pages et il a été publié en "+annee;
	}
}
