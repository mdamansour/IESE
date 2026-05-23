package BibliothequeLivre;

import java.util.ArrayList;

public class Bibliotheque {
	private String nom;
	ArrayList<Books> book ;
	public Bibliotheque(String nom,ArrayList<Books> b ) {
		this.nom=nom;
		this.book=new ArrayList<Books>();
		for(int i=0;i<b.size();i++) {
			if(!this.book.contains(b.get(i)))this.book.add(b.get(i));
		}
	}
	public Bibliotheque(String nom,Books ...b) {
		this.nom=nom;
		this.book=new ArrayList<Books>();
		for(int i=0;i<b.length;i++) {
			if(!this.book.contains(b[i]))this.book.add(b[i]);
		}
	}
	void ajouterLivre(Books b) {
		if(!this.book.contains(b))this.book.add(b);
	}
	public String toString() {
		return "La bibliotheque "+nom+" contient "+book.size()+" livres : \n"+book.toString();
	}
}
