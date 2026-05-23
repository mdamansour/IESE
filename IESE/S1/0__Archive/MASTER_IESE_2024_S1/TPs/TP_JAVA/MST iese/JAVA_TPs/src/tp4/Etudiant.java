package tp4;
import tp1.*; //pour importer tout le package
//import tp1.Personne; 
public class Etudiant extends Personne {
     protected String cne;
     protected String filiere;
     protected int niveau;
     public void ff() {

     }
     
     public Etudiant (String nom,Date dn,String cne,String filiere,int niveau) {
    	 super(nom,dn);//si je nappelle pas super ou j'ecris 'super()' le constructeur va appeller le constructeur sans parametre si il nexiste pas il va generer une erreur et il doit etre en premiere ligne
    	 this.cne=cne;//this designe lobjet qui a appeler le service
    	 this.filiere=filiere;
    	 this.niveau=niveau;
     }
     
     public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	@Override
	public String toString() {
		
		return "Etudiant ["+super.toString()+" \n cne=" + cne + ", filiere=" + filiere + ", niveau=" + niveau + "]";
	}
	public Etudiant () {
    	 this.cne="N";// ou bien this.cne=new String("N");
    	 this.filiere="";
    	 this.niveau=1;
    	 /*
    	  * je peux ecrire 
    	cne="N";// ou bien this.cne=new String("N");
    	filiere="";
    	niveau=1;
    	  * 
    	  * */
}
}