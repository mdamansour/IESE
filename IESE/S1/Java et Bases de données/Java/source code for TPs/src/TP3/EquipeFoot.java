package TP3;
//
import java.util.ArrayList;

import TP2.Etudiant;
import TP2.Personne;
import TP2.Professeur;

public class EquipeFoot { // abstract test
	String nom;
	ArrayList<Personne> joueurs;
	
	//abstract public int f(); //sans cod la classe doit etre abstract aussi
	
	public EquipeFoot(String nom) {
		super();
		this.nom = nom;
		this.joueurs = new ArrayList<Personne>();
	}
	
	public EquipeFoot(String nom, Personne ... tab) {
		super();
		this.nom = nom;
		this.joueurs = new ArrayList<Personne>();
		for(int i=0;i<tab.length;i++)
		{
			this.joueurs.add(tab[i]);
		}
	}
	
	
	public void ajouterJoueur(Personne p)
	{
		if (this.joueurs.contains(p) == false)
			this.joueurs.add(p);
	}
	
	//supprimer joueurs: a faire
	
	public String toString()
	{
		String s = "Equipe: " + this.nom + "\nLes joueurs sont:\n";
		s = s + "-- Etudiants: \n";
		for(Personne p : this.joueurs)
		{
			if (p instanceof Etudiant)
				s = s + "\t- " + p.toString() + "\n";
		}
		
		s = s + "-- Professeurs: \n";
		for(Personne p : this.joueurs)
		{
			if (p instanceof Professeur)
				s = s + "\t- " + p.toString() + "\n";
		}
		return s;
	}
	
}
