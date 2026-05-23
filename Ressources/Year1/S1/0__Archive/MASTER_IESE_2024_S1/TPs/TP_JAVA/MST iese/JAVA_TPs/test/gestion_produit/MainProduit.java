package gestion_produit;

import java.util.Scanner;
import tp1.*;
public class MainProduit {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Entrer le nombre de vos produits : ");
		int n=scan.nextInt();
		Date d=new Date(10,12,2024);
		String z;
		int p=0,j=0,m=0,a=0;
		Date x=new Date();
		ProduitAlimentaire[] no=new ProduitAlimentaire[n];
		for (int i = 0; i < n; i++) {
		    System.out.println("Entrer le prix du produit numero " + (i + 1));
		    p = scan.nextInt();

		    System.out.println("Entrer la date du produit numero " + (i + 1));
		    j = scan.nextInt();
		    m = scan.nextInt();
		    a = scan.nextInt();
		    scan.nextLine(); 

		    System.out.println("Entrer le nom du produit numero " + (i + 1));
		    z = scan.nextLine();

		    x = new Date(j, m, a);
		    no[i] = new ProduitAlimentaire(z, p, x);
		}
		System.out.println("vous avez "+no.length+ " produits \n");
		for(ProduitAlimentaire f:no) {
			System.out.println(f);
		}

	}

}
