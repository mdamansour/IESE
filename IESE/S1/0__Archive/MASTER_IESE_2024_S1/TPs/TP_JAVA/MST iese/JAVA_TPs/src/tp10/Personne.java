package tp10;

public class Personne {
	int age;
	String nom;
	public Personne(int age, String nom) throws AgeException, NomException {
		super();
		if(age<0)
			throw new AgeException(age);
		this.age = age;
		if(nom.contains("/"))
			throw new NomException();
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeException {
		if(age<0)
			throw new AgeException(age);
		this.age = age;
	}
	@Override
	public String toString() {
		return "Personne [age=" + age + ", nom=" + nom + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) throws NomException {
		if(nom.contains("/"))
			throw new NomException();
		this.nom = nom;
	}
	
}
