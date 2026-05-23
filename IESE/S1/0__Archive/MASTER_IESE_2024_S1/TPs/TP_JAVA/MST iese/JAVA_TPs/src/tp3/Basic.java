package tp3;

import java.util.Scanner;

public class Basic {
 static void testerTableau1D(){
	int t1[]=new int[3];
	int []t2= {10,20};	
	int []t3= new int[] {1,2,3,4,5};	//si je donne les valeur il ne faut pas preciser la taille en crochet
	System.out.println("le contenu du tableau un est : ");
	for (int i=0;i < t1.length;i++) 
		System.out.print(t1[i]+"\t");
	    System.out.println();
		System.out.println("le contenu du tableau deux est : ");//autre declaration de for dans java et cest une boucle qui sert juste a la lecture pas pour modifier le contenu de la case
		for(int x : t2)
			System.out.print(x+"\t");
	    System.out.println();
		System.out.println("le contenu du tableau trois est : ");
		for(int x : t3)
			System.out.print(x+"\t");	
		
 
 }
 /*static int somme ( int a, int b) {
	 return a+b;
 }
 static int somme ( int a, int b, int c) {
	 return a+b+c;
 }
 static int somme ( int []b) {
	 int g=0;
	 for (int i=0;i<b.length;i++) {
		g=g+b[i]; 
	 }
	 return g;
 }*/
 static int somme ( int ... b ) {
	 int g=0;
	 for (int i: b) {
		g+=i; 
	 }
	 return g;
 }
 static void saisirInfos () {
	 String nom;
	 int age;
	 Scanner scan = new Scanner(System.in);
	 System.out.println("Veuillez saisir votre nom : ");
	 nom =scan.nextLine();
	 System.out.println("Veuillez saisir votre age : ");
	 age =scan.nextInt(); 
	 System.out.println("Bonjour " + nom + " , vous avez "+ age);
 }
 static void testerTableau2D() {
 	int t1[]= {11,12,13,14};
 	int t4[][] = new int [3][2];
 
		int []t5[] = {{11,22},{1,2,3},{7,8,9}};
		int [][]t6 = new int[][] {{1,2,3,4,5},{100,200},t1}; 
		System.out.println("\nLe contenu du tableau un est :");
		for(int i=0; i<t4.length ; i++){
		     for(int j=0; j<t4[i].length; j++)
		    System.out.print( t4[i][j] + "\t");
		    System.out.println();
		  }
		System.out.println("le contenu du tableau deux est : ");
		for(int x[] : t5) {
			for(int y : x)
				System.out.print(y + "\t");
			System.out.println();
		}
		System.out.println("le contenu du tableau trois est : ");
		for(int x[] : t6) {
			for(int y : x)
				System.out.print(y + "\t");
			System.out.println();
		}
	
	}

	public static void main(String[] args) {
		//testerTableau1D();
		testerTableau2D(); 
		int v=5,k=6,g=2,f=0;
		int t[]={2,5,4,2};
		f=somme(5,6,2,8);
		//saisirInfos ();
	}

}
