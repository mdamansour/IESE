package tp4;

import tp1.Date;
import tp1.Personne;

public class Professeur extends Personne {
    protected String matiere;
    protected String etablissement;
    public Professeur(String nom,Date dn,String matiere,String etablissement) {
   	 super(nom,dn);
   	 this.matiere=matiere;
   	 this.etablissement=etablissement;
    }
    public Professeur() {
      	 this.matiere="X";
      	 this.etablissement="X";
       }
	public String getMatiere() {
		return matiere;
	}
	public String getEtablissement() {
		return etablissement;
	}    
	@Override
	public String toString() {
		return "Professeur ["+super.toString()+" \n matiere=" + matiere + ", etablissement=" + etablissement + "]";
	}
}
