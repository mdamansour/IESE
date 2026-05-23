package main;

public class Etudiant {
	String nom;
	String filiere;
	String niveau;
	public Etudiant(String nom, String filiere, String niveau) {
		super();
		this.nom = nom;
		this.filiere = filiere;
		this.niveau = niveau;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
}
