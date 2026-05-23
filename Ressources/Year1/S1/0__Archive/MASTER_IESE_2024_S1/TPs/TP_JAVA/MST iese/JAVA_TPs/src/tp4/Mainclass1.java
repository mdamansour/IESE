package tp4;
import tp1.*;
public class Mainclass1 {
	//int r=20; cest un attribut
static void testerEtudiant() {
	Etudiant e=new Etudiant("oumi", new Date(26,10,2001),"N13256897","IESE",1);
	Etudiant e2=new Etudiant();
	System.out.println(e);
	System.out.println(e2);
}
static void testerProfesseur() {
	Professeur e=new Professeur("oumayma", new Date(26,10,2001),"physique des composants","FST FES");
	Professeur e2=new Professeur();
	System.out.println(e);
	System.out.println(e2);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testerProfesseur() ;
	}

}
