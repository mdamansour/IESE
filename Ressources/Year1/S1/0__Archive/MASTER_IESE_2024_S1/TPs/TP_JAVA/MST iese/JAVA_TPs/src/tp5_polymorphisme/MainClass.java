package tp5_polymorphisme;

import tp1.Date;
import tp4.Etudiant;
import tp4.Professeur;

public class MainClass {
	public static void main(String[] args) {
		Professeur e=new Professeur("npc", new Date(10,2,2002),"java","fst fez");
		Etudiant e1=new Etudiant("omis", new Date(23,7,2002),"M1234556","iese",1);
		EquipeFoot f=new EquipeFoot ("wydad",e,e1);
	}

}
