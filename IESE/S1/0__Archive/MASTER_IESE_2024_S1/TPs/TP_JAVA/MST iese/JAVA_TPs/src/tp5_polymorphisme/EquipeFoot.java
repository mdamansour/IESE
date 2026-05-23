package tp5_polymorphisme;

import java.util.ArrayList;

import tp1.Personne;
import tp2auteurlivre.Livre;

public class EquipeFoot {
	String nom;
	ArrayList<Personne> joueurs;

	public EquipeFoot(String nom) {
		this.nom = nom;
		this.joueurs = new ArrayList<Personne>();
	}

	public EquipeFoot(String nom,ArrayList<Personne> j) {
		this.nom=nom;
		//this.joueurs = new ArrayList<Personne>();
		this.joueurs=j;
	}
	public EquipeFoot(String nom, Personne... tab) {
		this.nom = nom;
		this.joueurs = new ArrayList<Personne>();
		for (Personne s : tab)
			this.joueurs.add(s);
	}

	public String toString() {
		String ch = "equipe [nom=" + nom + ", liste des joueurs : \n";
		for (Personne x : joueurs) {
			ch += "\t-" + x + "\n";
		}
		return ch;
	}
}
