package entre;

import java.util.ArrayList;

public class Entreprise {
		private String nom;
		ArrayList<Departement> listDep;
		
		public Entreprise(String nom,ArrayList<Departement> listDep) {
			this.nom=nom;
			this.listDep=new ArrayList<Departement>();
			for(int i=0;i<listDep.size();i++) {
				if(!this.listDep.contains(listDep.get(i))) {
					this.listDep.add(listDep.get(i));
				} 
			}
		}
		
		public void addDepartement(Departement x) { 
			if(!this.listDep.contains(x))this.listDep.add(x);
		}
		public int masseEntreprise() {
			int s=0;
			for(int i=0;i<listDep.size();i++) {
				s+=listDep.get(i).masseSalariale();
			}
			return s;
		}
		public String toString() {
			return "L'entreprise "+nom+ " contient "+listDep.size()+ " departements : \n"+listDep;
		}
		
}
