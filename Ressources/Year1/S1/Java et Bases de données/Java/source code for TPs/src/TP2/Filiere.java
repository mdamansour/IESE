package TP2;

import java.util.ArrayList;

public class Filiere 
{
	String nom;
	Professeur responsable;
	ArrayList<Etudiant> listeEtudiants;
	ArrayList<Professeur> intervenants;
	
	public Filiere(String nom, Professeur responsable)
	{
		this.nom = nom;
		this.responsable = responsable;
		this.listeEtudiants = new ArrayList<Etudiant>();
		this.intervenants = new ArrayList<Professeur>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Professeur getResponsable() {
		return responsable;
	}

	public void setResponsable(Professeur responsable) {
		this.responsable = responsable;
	}

	public ArrayList<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

	public ArrayList<Professeur> getIntervenants() {
		return intervenants;
	}

	public void setIntervenants(ArrayList<Professeur> intervenants) {
		this.intervenants = intervenants;
	}
	
	public Filiere()
	{
		this.nom = "SansNom";
		this.responsable = new Professeur();
		this.listeEtudiants = new ArrayList<Etudiant>();
		this.intervenants = new ArrayList<Professeur>();
	}
	
	//creud?
	
	void ajouterEtudiant(Etudiant x)
	{
		if (listeEtudiants.contains(x) == false)
			listeEtudiants.add(x);
	}
	
	void supprimerEtudiant(Etudiant x)
	{
		listeEtudiants.remove(x);
	}
	
	void ajouterProfesseur(Professeur x)
	{
		if (intervenants.contains(x) == false)
			intervenants.add(x);
	}
	
	void supprimerProfesseur(Professeur x)
	{
		intervenants.remove(x);
	}
	
	public String toString()
	{
		String ch = "Filiere [" + this.nom + "]\nResponsable : " + this.responsable + "\n";
		ch = ch + "Liste des Profs : \n";
		for(int i = 0; i < intervenants.size(); i++)
		{
			ch = ch + "\t" + intervenants.get(i) + "\n";
		}
		return ch;
	}
}
