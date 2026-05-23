package tableau;

import java.util.Scanner;

public class tableau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("enter le nombre : ");
		int n=scan.nextInt();
		int j[]=new int[n];
		for(int i=0;i<n;i++) {
			j[i]=scan.nextInt();
		}
		for(int x:j) {
			System.out.print(x+"\t");
		}
	}

}
