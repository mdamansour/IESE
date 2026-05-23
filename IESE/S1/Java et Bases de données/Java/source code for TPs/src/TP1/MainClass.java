package TP1;

public class MainClass 
{

	public static void main(String[] args) 
	{
		Complexamen a = new Complexamen();
		Complexamen b = new Complexamen(1, 5);
		//Complexamen c = new Complexamen();
		Complexamen d = new Complexamen();
		
		//a.re = 10;
		//a.img = 20;
		b.setRe(10);
		d.setImg(-147);
		//float i = b.getRe();
		
		//c = a.somme(b);
		System.out.println(a.toString());
		//b.afficher();
		//c.afficher();

	}

}
