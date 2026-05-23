package tp2auteurlivre;

import java.util.ArrayList;

public class MainLivre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Livre L1=new Livre("Notre Dame De Paris",200,1820),L2=new Livre("les miserables",400,1920);
		ArrayList<Livre> list =new ArrayList<Livre>();
		list.add(L1);
		//list.add(L2); 

		//Auteur v=new Auteur("Victor HUGO",80,list);	
		//Auteur v=new Auteur("Victor HUGO",80,list);
		Auteur v=new Auteur("Victor HUGO",80,L1);
		v.ajouterlivre (L2);
		System.out.println(v);
		v.supprimerlivre(L2);
		System.out.println(v);
}
}