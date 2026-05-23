package TP2;

import java.util.ArrayList;

public class Professeur examentends Personne
{
	String specialite;
	//String [] matieres; tableau statique
	ArrayList<String> matieres;
	
	public Professeur(String nom, String prenom, Date dateNaissance, String specialite, ArrayList<String> matieres) {
		super(nom, prenom, dateNaissance); //super tjrs dans premiere ligne
		this.specialite = specialite;
		this.matieres = matieres;
	}

	public Professeur() {
		super();
		this.specialite = "sSansSpecialite";
		this.matieres = new ArrayList<String>();
	} 
	
	@Override
	public String toString() {
		return "Professeur [" + super.toString() + "specialite=" + specialite + ", matieres=" + matieres + "]";
	}
	
	void ajouterMatiere(String m)
	{
		if (matieres.contains(m) == false)
			matieres.add(m);
	}
	
	void supprimerMatiere(String m)
	{
		matieres.remove(m);
	}
}