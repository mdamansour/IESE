package TP9;

public class Bilbiotheque{ //CRUD?
	
	public Bilbiotheque()
	{
		//
		try {
			Class.forName("com.mysql.jdc.Driver");
			System.out.println("Driver MySQL Java est OK.");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver pas installé ! Au revoir.");
			System.examenit(0);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Bilbiotheque b = new Bilbiotheque();
	}

}
