package edu.projet;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassagerDAOSql implements PassagerDAO
{

	@Override
	public List<Passager> findAll()
	{
		// Initialiser ma liste de passagers
		List<Passager> listePassager = new ArrayList<>();
		try
		{
			// Etape 0: chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 1: se connecter à la BDD
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			// Etape 2 : création du statement
			Statement statement = connexion.createStatement();

			// Etape 3 : Execution de la requete SQL
			ResultSet resultSet = statement.executeQuery("SELECT * FROM passager");
			System.out.println();

			// Etape 4 : Parcours des résultats
			while (resultSet.next())
			{
				// chaque ligne du tableau peut etre exploitée, on va recuperer
				// chaque valeur de chaque colonne
				AdresseDAOSql ads = new AdresseDAOSql();
				Passager passager = new Passager();
				// appel des mutateurs
				passager.setIdPas(resultSet.getInt("idPassager"));
				;
				passager.setNom(resultSet.getString("nom"));
				passager.setPrenom(resultSet.getString("prenom"));
				
				Adresse a = ads.findById(resultSet.getInt("idAdd"));
				passager.setAdresse(a);
				// on ajoute l'objet adresse à la liste de passagers
				listePassager.add(passager);
			}

			// Etape 5 : Fermeture de la connexion
			connexion.close();
		} catch (ClassNotFoundException e)
		{
			System.err.println("Chargement du pilote de lecture de BDD impossible");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.err.println("Impossible de trouver la base de donnée");
			e.printStackTrace();
		}
		return listePassager;
	}

	@Override
	public Passager findById(int id)
	{
		// Initialisation d'un objet Passager
		Passager passager = new Passager();
		// Initialisation d'un objet AdresseDAOSql pour récupérer l'adresse du
		// passager grâce à l'idAdd
		AdresseDAOSql adresseDao = new AdresseDAOSql();
		try
		{
			// Etape 0: chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 1: se connecter à la BDD
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			// Etape 2 : création du statement
			Statement statement = connexion.createStatement();

			// Etape 3 : Execution de la requete SQL
			ResultSet resultSet = statement.executeQuery("SELECT * FROM passager");
			System.out.println();

			// Etape 4 : Parcours des résultats
			while (resultSet.next())
			{
				// chaque ligne du tableau peut etre exploitée, on va recuperer
				// chaque valeur de chaque colonne

				if (resultSet.getInt("idPAssager") == id)
				{
					// appel des mutateurs
					passager.setIdPas(resultSet.getInt("idPassager"));
					;
					passager.setNom(resultSet.getString("nom"));
					passager.setPrenom(resultSet.getString("prenom"));
					Adresse adresse = adresseDao.findById(resultSet.getInt("idAdd"));
					passager.setAdresse(adresse);
					// on retourne le passager associé au param
					
				}
			}

			// Etape 5 : Fermeture de la connexion
			connexion.close();
		} catch (ClassNotFoundException e)
		{
			System.err.println("Chargement du pilote de lecture de BDD impossible");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.err.println("Impossible de trouver la base de donnée");
			e.printStackTrace();
		}
		return passager;

	}

}