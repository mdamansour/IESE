package TP1;

public class Complexamen 
{
	//liste des attributs
	private float re;
	private float img;
	
	//les constructeurs
	public Complexamen()
	{
		re = 10;
		img = -20;
	}
	public Complexamen(float a, float b)
	{
		re = a;
		img = b;
	}
	
	// setters and getters"
	public float getRe()
	{
		return re;
	}
	
	public void setRe(float a)
	{
		re = a;
	}
	public float getImg()
	{
		return img;
	}
	
	public void setImg(float a)
	{
		img = a;
	}
	
	//liste des methodes
	public void afficher()
	{
		if(img>=0)
			System.out.println(re + " +" + img + "i");
		else
			System.out.println(re + " " + img + "i");
	}
	public String toString()
	{
		if(img>=0)
			return re + " +" + img + "i";
		else
			return re + " " + img + "i";
	}
	Complexamen somme(Complexamen X)
	{
		Complexamen res = new Complexamen();
		res.re = re + X.re;
		res.img = img + X.img;
		return res;
	}

}
