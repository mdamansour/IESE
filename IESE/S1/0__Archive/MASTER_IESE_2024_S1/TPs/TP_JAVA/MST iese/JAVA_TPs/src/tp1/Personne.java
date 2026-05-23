package tp1;

public class Personne {
	String nom;
	Date dateNaissance;
	public void ff() ;
	public Personne (String nom,Date dateNaissance) {
		this.nom=nom;
		this.dateNaissance=dateNaissance;
	}

	public Personne() {
		this.nom="none";
		this.dateNaissance=new Date(1,1,2000);
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Personne(String nom,int j,int m,int a) {
		this.nom=nom;
		this.dateNaissance=new Date(j,m,a);		
	}
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + "\n " + dateNaissance + "]";//crtl espace pour la suite
	}
	
	
}
