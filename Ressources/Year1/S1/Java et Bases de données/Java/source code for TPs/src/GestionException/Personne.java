package GestionException;

public class Personne {
	String nom;
	int age;
	public Personne(String nom, int age) throws AgeException {
		super();
		this.nom = nom;
		if(age < 0) 
			throw new AgeException(age); // le programme s'arrette l'objet est bloqué, on aura besoin d'un autre
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + "]";
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeException {
		if(age < 0) 
			throw new AgeException(age);
		this.age = age;
	}
	
	
}
