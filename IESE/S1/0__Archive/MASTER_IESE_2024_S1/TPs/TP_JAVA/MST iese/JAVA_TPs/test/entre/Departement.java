package entre;

import java.util.ArrayList;

public class Departement {
	  private String nom;
      ArrayList<Employe> listeEmploye;
      
      public Departement(String nom,ArrayList<Employe> listeEmploye) {
    	  this.nom=nom;
    	  this.listeEmploye=new ArrayList<Employe>();
    	  for(int i=0;i<listeEmploye.size();i++) {
    		  if(!this.listeEmploye.contains(listeEmploye.get(i))) {
    			  this.listeEmploye.add(listeEmploye.get(i));
    		  }
    	  }
      }
      
      void addEmploye(Employe x) {
    	  if(!this.listeEmploye.contains(x)) {listeEmploye.add(x);}
      }
      int masseSalariale() {
    	  int s=0;
    	  for (int i=0;i<listeEmploye.size();i++) {
    		  s+=listeEmploye.get(i).getSalaire();
    	  }
    	  return s;
      }
      @Override
      public String toString(){
    	  return "le departement "+nom+" contient "+listeEmploye.size()+" employés : \n"+listeEmploye;
      }
}
