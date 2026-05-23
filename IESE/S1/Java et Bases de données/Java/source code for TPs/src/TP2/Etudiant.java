package TP2;

public class Etudiant examentends Personne { //heritage
	/* on doit inclure le code de test dans une fonction
	
	void test()
	{
		this.nom = "Ahmed";
		this.dateNaissance = new Date();
	}
	*/
	
	String cne;
	int niveau;
	String filiere;
	
	public Etudiant(String nom, String prenom, Date dn, String cne, int niveau, String filiere)
	{
		super(nom, prenom, dn);//constructeur de la class mere
		this.cne = cne;
		this.niveau = niveau;
		this.filiere = filiere;
	}
	
	public Etudiant()
	{
		//super("", "", 1, 2, 3); si Personne n'a pas de constructeur sans paramettres
		super();
		this.cne = "SansCNE";
		this.niveau = 1;
		this.filiere = "SansFiliere";
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Etudiant [" + super.toString() + "cne=" + cne + ", niveau=" + niveau + ", filiere=" + filiere + "]";
	}
	
	
	
}
