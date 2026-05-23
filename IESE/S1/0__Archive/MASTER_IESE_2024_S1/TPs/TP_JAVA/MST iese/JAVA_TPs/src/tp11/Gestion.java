package tp11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestion {
	Connection notreConnexion;
	String url="jdbc:mysql://localhost:3306/bibliotheque";
	String userName="root";
	String pass="";
	public Gestion() {
		//etape 1 : tester si le driver mysql-java est accessible 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
		} catch (ClassNotFoundException e) {
		System.out.println("Driver ... not OK!!!");
		System.exit(0);
		}
		//etape2 : se connecter au serveur et a la BD
	
		try {
			notreConnexion = DriverManager.getConnection(url, userName, pass);
			System.out.println("Connexion a la base OK");
		} catch (SQLException e) {
			System.out.println("acces bd ... not ok");
			System.exit(0);
		}

		System.out.println("Weee");
	}
void afficherBaseDonnee() throws SQLException {
	String query = "select * from livre";
	Statement st = notreConnexion.createStatement();
	ResultSet resultat = st.executeQuery(query);
	while(resultat.next()) {
			System.out.println("-----------------------------------------------------");
			System.out.println(" Titre      = "+resultat.getString(1));
			System.out.println(" Auteur    = "+resultat.getString(2));
			System.out.println(" Annee     = "+resultat.getInt(3));
			System.out.println(" Nb pages  = "+resultat.getInt(4));
	}}
	void insererLivre(String titre, String auteur, int annee , int nbPages) throws SQLException {
		String query = "insert into livre values(?,?,?,?)";
		PreparedStatement st =notreConnexion.prepareStatement(query);
		st.setString(1, titre);
		st.setString(2, auteur);
		st.setInt(3, annee);
		st.setInt(4, nbPages);
		int nb =st.executeUpdate();
		System.out.println(nb+"livre(s) inseré(s) dans votre base de données");
	}
	void supprimerLivre(String titre) throws SQLException {
		String query = "delete from livre where titre=?";
		PreparedStatement st =notreConnexion.prepareStatement(query);
		st.setString(1, titre);

		int nb =st.executeUpdate();
		System.out.println(nb+"livre(s) supprimé(s) dans votre base de données");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Gestion g=new Gestion();
g.afficherBaseDonnee();
//g.insererLivre("Anglais","pr",2015,80);
//g.insererLivre("numerique","Ali",2018,50);
//g.insererLivre("math","anis",2022,150);
g.afficherBaseDonnee();
g.supprimerLivre("Anglais");
System.out.println("--------------------apres suppression-----------------");
g.afficherBaseDonnee();
	}

}
