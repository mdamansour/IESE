package BibliothequeLivre;
import tp1.*;
public class Books {
	private String nom;
	private String auteur;
	private Date pub;
	public Books(String nom,String auteur,Date pub) {
		this.nom=nom;
		this.auteur=auteur;
		pub=new Date();
		this.pub=pub;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Date getPub() {
		return pub;
	}
	public void setPub(Date pub) {
		this.pub = pub;
	}
	@Override
	public String toString() {
		return "Le livre "+nom+", publier par "+auteur+" le :"+pub;
	}
	
}
