package saisir_tableau;

import java.util.Scanner;

public class Stableau {
static void demande_tableau() {
	int n=0;
	System.out.println("Saisir la dimension de votre tableau :");
	Scanner scan=new Scanner(System.in);
	n=scan.nextInt();
	int t[]=new int[n];
	for(int i=0;i<t.length;i++) {
		t[i]=scan.nextInt();
	}
	System.out.println("\n votre tableau est : ");
	for(int x:t) {
		System.out.print(x+"\t");
	}
	System.out.println("\n la somme des elements du tableau est : ");
	System.out.print(somme(t));
	System.out.println("\n la moyenne des elements du tableau est : ");
	System.out.print(moyenne(t));
	System.out.println("\n le maximum des elements du tableau est : ");
	System.out.print(maximum(t));
}
	static int somme(int ... n) {
		int s=0;
		for(int i=0;i<n.length;i++) {
			s+=n[i];
		}
		return s;
	}
	static int moyenne(int ... n) {
		int s=0;
		for(int i=0;i<n.length;i++) {
			s+=n[i];
		}
		return s/n.length;
	}
	static int maximum(int ... n) {
		int s=n[0];
		for(int i=1;i<n.length;i++) {
			if(s<n[i])s=n[i];
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demande_tableau() ;
	}

}
