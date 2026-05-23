package tp2auteurlivre;

import java.util.ArrayList;

import tp1.Personne;


public class Auteur {
     String  nom;
      int age;
      ArrayList<Livre> listeLivres;
     
	 /*public Auteur(String nom, int age, ArrayList<Livre> listeLivres) {
		this.nom = nom;
		this.age = age;
		this.listeLivres = listeLivres;
	}*/
	 public Auteur(String nom, int age, ArrayList<Livre> L) {
		this.nom = nom;
		this.age = age;
		this.listeLivres=new ArrayList<Livre>();// il est important de linisialiser sinon lappli sarrete
		for(int i=0;i<L.size();i++) {
			if(!this.listeLivres.contains(L.get(i))) this.listeLivres.add(L.get(i));		
		}//pour eviter la repetition de livre
		//this.listeLivres = L;
	}

	 public Auteur(String nom, int age, Livre ... l) {
		this.nom = nom;
		this.age = age;
		this.listeLivres=new ArrayList<Livre>();
		for(int i=0;i<l.length;i++ ) {
			if(!this.listeLivres.contains(l[i]))
				this.listeLivres.add(l[i]);
		}
		
	}

		public String toString() {
			String ch="Auteur [nom=" + nom + ", age=" + age + ", listeLivres : \n" ;
			for (Livre x:listeLivres) {
				ch+="\t-"+x+"\n";
			}
			return ch;
		}
		public void ajouterlivre (Livre L) {
			if(!this.listeLivres.contains(L))
			listeLivres.add(L);
		}
		public void supprimerlivre (Livre L) {
			if(this.listeLivres.contains(L))
			listeLivres.remove(L);
		}
}
