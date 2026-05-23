package TP2;

public class Personne {
	public String nom; // package a priorite sur protected !!
	private String prenom; // seul cette classe a access
	protected Date dateNaissance; //protected: private pour l'examenterieur, public pour les classes filles

	public Personne(String nom, String prenom, Date dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	public Personne(String n, String p, int j, int m, int a) {
		this.nom = n;
		this.prenom = p;
		this.dateNaissance = new Date(j, m, a);
	}

	public Personne() {
		this.nom = "SansNom";
		this.prenom = "SansPrenom";
		this.dateNaissance = new Date(); //composition
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public void setDateNaissance(int j, int m, int a) {
		this.dateNaissance.setJour(j);
		this.dateNaissance.setMois(m);
		this.dateNaissance.setAnnée(a);
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}

}
