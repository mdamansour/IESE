package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnexionC {

	Connection notreConnexion;
	String url="jdbc:mysql://localhost:3306/profqsm";
	String userName="root";
	String pass="omar1234";
	public ConnexionC() {
	
	//etape1: Tester si le driver my sql-java est accessible 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver ..... OK !");
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("Driver ...not OK ! ... Au revoir");
				System.exit(0);
			}
	//etape2; se connecter au serveur et a la BD
			
			try {
				notreConnexion = DriverManager.getConnection(url, userName, pass);
				System.out.println("connection a la base de donnees..... OK !");
			}
			catch (SQLException e) {
				System.out.println("BD est non accessible .....!");
				System.exit(0);
			}
			System.out.println("Bravo! fin du constructeur :on peut manipuler notre bases donnes!");
		}
			
 	void creationqcm(String id, String profName, String filiereString, String niveauString, String titreString) throws SQLException {
		String query = "INSERT INTO creationqcm values (?,?,?,?,?)";
		PreparedStatement st = notreConnexion.prepareStatement(query);
		st.setString(1,id);
		st.setString(2,profName);
		st.setString(3, filiereString);
		st.setString(4, niveauString);
		st.setString(5, titreString);
		
		int nb = st.executeUpdate();
		System.out.println(nb+"qcmcree");
	}
 	
 	void questions(String id, int num, String texteDesc, String choix1, String choix2, String choix3, int bnReponse) throws SQLException {
		String query = "INSERT INTO questions values (?,?,?,?,?,?,?)";
		PreparedStatement st = notreConnexion.prepareStatement(query);
		st.setString(1,id);
		st.setInt(2,num);
		st.setString(3, texteDesc);
		st.setString(4, choix1);
		st.setString(5, choix2);
		st.setString(6, choix3);
		st.setInt(7, bnReponse);
		
		int nb1 = st.executeUpdate();
		System.out.println(nb1+"question ajouter");
	}

 	void InsertEtudiant(String id, String nom, int note) throws SQLException {
		String query = "INSERT INTO bilan values (?,?,?)";
		PreparedStatement st = notreConnexion.prepareStatement(query);
		st.setString(1,id);
		st.setString(2, nom);
		st.setInt(3, note);
		int nb2 = st.executeUpdate();
		System.out.println(nb2+"Resultat ajouter");
	}
 	ResultSet selectQcm(String filiere, String niveau) throws SQLException {
        String query = "SELECT * FROM creationqcm WHERE filiere = ? AND niveau = ?";
        PreparedStatement st = notreConnexion.prepareStatement(query);
        st.setString(1, filiere);
        st.setString(2, niveau);

        return st.executeQuery();
    }
 	
 	ResultSet selectQuestion(String id) throws SQLException {
        String query = "SELECT * FROM questions WHERE id_Qcm = ? ";
        PreparedStatement st = notreConnexion.prepareStatement(query);
        st.setString(1, id);

        return st.executeQuery();
    }

 	ResultSet selectNotes(String nom) throws SQLException {
        String query = "SELECT creationqcm.titre, bilan.Note\r\n"
        		+ "FROM creationqcm\r\n"
        		+ "JOIN bilan ON creationqcm.id-Qcm = bilan.id-Qcm\r\n"
        		+ "WHERE bilan.Nom = '?'";
        PreparedStatement st = notreConnexion.prepareStatement(query);
        st.setString(1, nom);

        return st.executeQuery();
    }

 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnexionC c =new ConnexionC();
		
	}

}

