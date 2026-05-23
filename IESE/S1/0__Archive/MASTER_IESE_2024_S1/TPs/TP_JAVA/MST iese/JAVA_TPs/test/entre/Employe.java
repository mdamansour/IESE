package entre;

public class Employe {
	private String nom;
	private int numero;
	private int salaire;
      public Employe(String nom, int numero, int salaire) {
    	  this.nom=nom;
    	  this.numero=numero;
    	  this.salaire=salaire;
      }
     
     String getNom() {return nom; }
     int getNumero() {return numero; }
     int getSalaire() {return salaire; }
     void setNom(String nom) {this.nom=nom;}
     void setNumero(int numero) {this.numero=numero;}
     void setSalaire(int salaire) {this.salaire=salaire;}
     
     void augmenterSalaire(int prime) {
    	 salaire+=prime;
    	 System.out.println("le salaire est : "+salaire+" DH");
     }
     @Override
     public String toString() {
		return "L'employé "+nom+" ,titulaire du numero "+numero+ " ,et un salaire de "+salaire +" DH. \n";}
}
