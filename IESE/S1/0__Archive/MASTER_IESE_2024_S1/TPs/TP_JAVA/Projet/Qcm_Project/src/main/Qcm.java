package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Qcm {
	String titre;
	String prof;
	String niveau;
	String filiere;
	PassQuestion[] questions = new PassQuestion[20];

	
	
	
	public Qcm(String titre, String prof, String niveau, String filiere) {
		super();
		this.titre = titre;
		this.prof = prof;
		this.niveau = niveau;
		this.filiere = filiere;

	}

	public Qcm() {
		super();
	}
	
	public void ajouterQuestion(PassQuestion question, int i) {
            this.questions[i] = question;
    
    }

	@Override
	public String toString() {
		return "Qcm [titre=" + titre + ", prof=" + prof + ", niveau=" + niveau + ", filiere=" + filiere + ", questions="
				+ Arrays.toString(questions) + "]";
	}
	
	

}
