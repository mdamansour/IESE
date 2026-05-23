package gestion_produit;
import tp1.*;


public class ProduitAlimentaire extends Produit{
	private Date dateExpiration;
	public ProduitAlimentaire(String nom, int prix,Date dateExpiration) {
		super(nom, prix);
		this.dateExpiration=dateExpiration;
	}
	public String toString() {
		return super.toString()+ "\n Sa date d'expiration : "+dateExpiration;
	}
}
