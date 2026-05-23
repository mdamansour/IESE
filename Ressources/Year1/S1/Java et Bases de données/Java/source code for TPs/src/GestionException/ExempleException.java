package GestionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExempleException {
	
	void examenemple1()
	{
		int a, b, c;
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Donner a: ");
		a = scan.nexamentInt();
		do
		{
			System.out.println("Donner b: ");
			b = scan.nexamentInt();
			try
			{
				flag = true;
				c=a/b;
				System.out.println("resultat de " + a + "/" + b + " est: " + c);
			}
			catch (ArithmeticException e)
			{
				flag = false;
				System.out.println("Attention tu as divisé par zéro!");
			}
			/*
			catch (InputMismatchException e)
			{
				flag = false;
				System.out.println("Attention la saisie doit être un digit!");
			}
			*/
		} while (flag == false);
		System.out.println("Fin de la méthode.");
	}
	void examenemple2()
	{
		Personne p1;
		Personne p2;
		try {
			p1 = new Personne("Hicham", 10);
			System.out.println(p1);
			p2 = new Personne("Laila", -10);
			System.out.println(p2);
		} catch (AgeException e) {
			System.out.println("Attention!");
			//e.printStackTrace();
		}
		System.out.println("Fin de la methode.");
	}
	void examenemple3()
	{
		
	}

	public static void main(String[] args) throws AgeException {
		ExempleException e = new ExempleException();
		e.examenemple2();

	}

}
