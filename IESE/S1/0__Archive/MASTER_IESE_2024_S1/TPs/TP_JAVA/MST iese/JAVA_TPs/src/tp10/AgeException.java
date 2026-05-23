package tp10;

public class AgeException extends Exception{
	public AgeException(int a)
	{
		super("Age negatif "+a);
		
	}
}
