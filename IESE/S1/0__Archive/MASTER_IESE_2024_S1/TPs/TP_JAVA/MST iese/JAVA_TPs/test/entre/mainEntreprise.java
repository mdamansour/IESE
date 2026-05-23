package entre;

import java.util.ArrayList;

public class mainEntreprise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Employe emp1=new Employe("said",123456,2500),emp2=new Employe("layla",789456,5000),emp3=new Employe("fatima zahrae",788256,250000),emp4=new Employe("achraf",100456,1154);
       ArrayList<Employe> list =new ArrayList <Employe>(),list2=new ArrayList<Employe>();
       list.add(emp1);
       list.add(emp2);
       list2.add(emp3);
       list2.add(emp4);
       Departement embarque=new Departement ("système embarqué",list),informatique=new Departement("INFORMAQTIQUE",list2);
       ArrayList<Departement> list3=new ArrayList<Departement>();
       list3.add(informatique);
       list3.add(embarque);
       Entreprise ALTEN=new Entreprise("ALTEN",list3);
       System.out.println(ALTEN);
       System.out.println(ALTEN.masseEntreprise());
       
	}

}
