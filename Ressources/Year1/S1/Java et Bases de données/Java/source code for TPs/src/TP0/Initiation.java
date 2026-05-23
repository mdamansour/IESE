package TP0;

public class Initiation {
	
	int somme(int a, int b)
	{
		return a+b;
	}
	
	int somme(int ... t)//t est un tableau statique
	{
		int s=0;
		for(int i=0; i<t.length;i++) s+=t[i];
		return s;
	}

	public static void main(String[] args) {
		
		Initiation obj = new Initiation();
		
		int a[] = {1, 2 , 3, 4};
		
		System.out.println(obj.somme(a));
	}
}