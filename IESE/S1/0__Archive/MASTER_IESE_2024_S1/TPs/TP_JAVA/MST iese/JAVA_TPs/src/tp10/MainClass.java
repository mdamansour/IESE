package tp10;


public class MainClass {
	
	static void exemple1() {
		System.out.println("Debut de lexemple1");
		int a=10,b=10,c;
		try {
			//Personne p=new Personne();
			//p.getNom();
		c=a/0;
		System.out.println("c = "+c);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Attention pas de divisionn par 0");//code de correction
		}
		catch(Exception e)
		{
			System.out.println("objet non initialiser");//code de correction
		}
		System.out.println("fin de lexemple1");
	}
	static void exemple2() throws  NomException {
		System.out.println("Debut de lexemple2");
		try {
		Personne p1=new Personne(-10,"zared");
		System.out.println(p1);}
		catch(AgeException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			
		}
		System.out.println("fin de lexemple2");
	}
	public static void main(String[] args) throws  NomException {
		// TODO Auto-generated method stub
		//exemple1();
		exemple2();
		System.out.println("Fin MAIN..........");
	}

}
