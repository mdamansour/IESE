package TP3;

import java.util.ArrayList;

import TP2.Date;
import TP2.Etudiant;
import TP2.Personne;
import TP2.Professeur;

public class MainClass {

	static void testerEquipe()
	{
		Etudiant e1 = new Etudiant();
		Etudiant e2 = new Etudiant("A", "AA", new Date(1,4,2024), "CNE1122", 1, "Mecanique");
		Etudiant e3 = new Etudiant("B", "BB", new Date(1,5,2024), "CNE1123", 1, "Electronique");
		Etudiant e4 = new Etudiant("C", "CC", new Date(1,6,2024), "CNE1124", 1, "Physique");
		
		ArrayList<String> liste = new ArrayList<String>();
		liste.add("Java");
		liste.add("Cpp");
		liste.add("Base de donnee");
		Professeur pr1 = new Professeur();
		Professeur pr2 = new Professeur("pr2","pr2", new Date(12, 12, 2012), "Informatique", liste);
		
		//polymorphisme
		
		//Personne pers;
		/*
		pers = e1;
		System.out.println(pers);
		pers = pr1;
		System.out.println(pers);
		
		// e=p; Faux
		// p=e; Vrais
		*/
		
		EquipeFoot eq1 = new EquipeFoot("Fath de Fes", e1, e2, pr1, pr2, e3, e4);
		// abstarct dans la class persone pour interdir pers dans equipe
		//classe non instanciable
		System.out.println(eq1);
	}
	public static void main(String[] args) {
		testerEquipe();

	}

}
