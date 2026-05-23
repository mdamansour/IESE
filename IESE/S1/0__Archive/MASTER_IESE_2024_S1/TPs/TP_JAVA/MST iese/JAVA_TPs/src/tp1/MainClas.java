package tp1;

public class MainClas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bonjour !");// syso crtl+espace
		Personne a,b=new Personne(),c=new Personne("npc",12,12,2001); //a est une reference ou pointeur donc pas d'etoile pour le differencier /on java toute est dynamique pas de reservation static donc nous avons une seule synthaxe
		a=new Personne("mohamed",new Date(21,2,2002));//ou Date a=new Date ();
		Personne c2=new Personne("omis",12,12,2001) {
			int r=10;
			public String toString () {
				return super.toString()+"-- je test--";
			}
			};
		System.out.println(a);
		System.out.println(b);
		System.out.println(c2);
	}

}
