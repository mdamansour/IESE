package GestionException;

public class AgeException examentends Exception
{
	public AgeException(int age)
	{
		super("L'age que tu as saisie " + age + " est négatif.");
	}
	
}
