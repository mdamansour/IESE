package BibliothequeLivre;
import java.util.ArrayList;

import tp1.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1=new Date(12,12,1990);
		Books b1=new Books("la boite à merveille","Ahmed sefrioui",d1);
		Date d2=new Date(18,02,1998);
		Books b2=new Books("miserable","Victor HUGO",d2);
		ArrayList<Books> list=new ArrayList<Books>();
		list.add(b1);
		list.add(b2);
		Bibliotheque alfajr=new Bibliotheque("alfajr",b1,b2);
		System.out.println(alfajr);
		//System.out.println(b2);
	}

}
