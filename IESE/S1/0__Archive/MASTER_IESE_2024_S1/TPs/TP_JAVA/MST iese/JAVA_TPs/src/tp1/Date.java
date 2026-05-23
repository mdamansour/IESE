package tp1;

public class Date 
{
   public int jour;  //par defaut private, il faut montionner est ce que c'est priver ou public
   public int mois;
   int annee;//visibilité package
   
public Date() {
	super();
	this.jour = 1;
	this.mois = 1;
	this.annee = 2000;
}
public Date(int jour, int mois, int annee) {
	this.jour = jour;
	this.mois = mois;
	this.annee = annee;
}
public int getJour() {
	return jour;
}
public void setJour(int jour) {
	this.jour = jour;
}
public int getMois() {
	return mois;
}
public void setMois(int mois) {
	this.mois = mois;
}
public int getAnnee() {
	return annee;
}
public void setAnnee(int annee) {
	this.annee = annee;
}
@Override
public String toString() {
	return "Date [jour=" + jour + ", mois=" + mois + ", annee=" + annee + "]";
}
   
 
   
   
}
// pas de notion fonction que des class
//visibilité privé pachage:on a rien ecrit au debut /elle utiliser par le package donc priver package en dehors du package refusé
//private utilisé dans la classe seulement
// on java il n'ya pas de constructeur de copie pas de destructeur et loperateur affectation 
// il faut redevelopper restring pour lecriture suivante Date a+"Bonjour"