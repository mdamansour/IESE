package TP2;

import java.util.ArrayList;

public class MainClass {
	
	void testerDate()
	{
		Date a = new Date();
		Date b = new Date(21, 10, 2025);
		System.out.println(a);
		System.out.println(b);
	}
	
	void testerPersonne()
	{
		Personne p1 = new Personne("A", "AA", new Date(10, 12, 2025));
		Personne p2 = new Personne();
		Personne p3 = new Personne("C", "CC", new Date(10, 12, 2025)) {
			//interieur d'une classe derivée
			int salaire;
			@Override
			public String toString() {
				return super.toString() + "Je suis votre responsable!";
			}
		};
		System.out.println(p1);
		System.out.println(p2);
		p3.setDateNaissance(11, 11, 2011);
		//p1.setNom("Ahmed");
		//p1.setDateNaissance(new Date(10, 10, 2010));
		System.out.println(p3);
	}
	
	void testerEtudiant()
	{
		Etudiant e1 = new Etudiant();
		Etudiant e2 = new Etudiant("BAALI","Yasser", new Date(), "cne123", 4, "IESE");
		System.out.println(e1);
		System.out.println(e2);
	}
	
	void testerProfesseur()
	{
		ArrayList<String> liste = new ArrayList<String>();
		liste.add("Java");
		liste.add("Cpp");
		liste.add("Base de donnee");
		Professeur pr1 = new Professeur();
		Professeur pr2 = new Professeur("pr2","pr2", new Date(12, 12, 2012), "Informatique", liste);
		System.out.println(pr1);
		System.out.println(pr2);
	}
	
	public static void main(String[] args) {
		//static: element de class, partagé par les objets, ne peut pas modifier un element non static
		// null: l'objet n'exameniste pas
		MainClass obj = new MainClass();
		obj.testerPersonne();
		
	}
	
}
