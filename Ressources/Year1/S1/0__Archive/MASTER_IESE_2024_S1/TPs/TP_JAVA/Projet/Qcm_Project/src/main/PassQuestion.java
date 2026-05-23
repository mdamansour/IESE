package main;

public class PassQuestion {
	int num;
	String quetexte;
	String choix1;
	String choix2;
	String choix3;
	int bonnereponse;
	String id;
	String nomE;
	
	
	public PassQuestion() {
		super();
	}
	
	

	public PassQuestion(String id,String nomE, int num, String quetexte, String choix1, String choix2, String choix3, int bonnereponse) {
		super();
		this.id = id;
		this.nomE = nomE;
		this.num = num;
		this.quetexte = quetexte;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.bonnereponse = bonnereponse;
		
	}



	public String getQuetexte() {
		return quetexte;
	}

	public void setQuetexte(String quetexte) {
		this.quetexte = quetexte;
	}

	public String getChoix1() {
		return choix1;
	}

	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}

	public String getChoix2() {
		return choix2;
	}

	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}

	public String getChoix3() {
		return choix3;
	}

	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}

	public int getBonnereponse() {
		return bonnereponse;
	}
	public int getBnreponse() {
	    return bonnereponse;
	}
	public void setBonnereponse(int bonnereponse) {
		this.bonnereponse = bonnereponse;
	}

	@Override
	public String toString() {
		return "Question [quetexte=" + quetexte + ", choix1=" + choix1 + ", choix2=" + choix2 + ", choix3=" + choix3
				+ ", bonnereponse=" + bonnereponse + "]";
	}
	
	
	
}
