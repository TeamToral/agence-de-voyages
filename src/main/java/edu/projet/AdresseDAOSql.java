package edu.projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdresseDAOSql implements AdresseDAO
{

	@Override
	public List<Adresse> findAll()
	{

		List<Adresse> adresses = new ArrayList<>();

		try
		{
			/*
			 * Etape 0: chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * Etape 1: se connecter à la BDD
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");
			/*
			 * Etape 2: Création du statement
			 */
			Statement statement = connexion.createStatement();
			/*
			 * Etape 3: Execution de la requète SQL
			 */
			ResultSet resultset = statement.executeQuery("SELECT * FROM adresse");
			/*
			 * Etape 4: Parcours des résultats
			 */
			while (resultset.next())
			{
				/*
				 * Chaque ligne du tableau de résultat peut être exploitée on va
				 * donc récupérer chaque valeur de chaque colonne
				 */
				// Je crée l'objet adresse
				Adresse adresse = new Adresse();
				// appel des mutateurs
				adresse.setIdAdd(resultset.getInt("idAdd"));
				adresse.setAdresse(resultset.getString("adresse"));
				adresse.setCodePostal(resultset.getString("codePostal"));
				adresse.setVille(resultset.getString("ville"));
				adresse.setPays(resultset.getString("pays"));
				adresses.add(adresse);
			}

			/*
			 * Etape 5: Je ferme la connexion
			 */
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

		// on retourne la liste des adresses de la base de données
		return adresses;
	}

	@Override
	public Adresse findById(int id)
	{
		Adresse adresse = new Adresse();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 1: se connecter à la BDD
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence", "user",
					"password");

			// Etape 2 : création du statement
			Statement statement = connexion.createStatement();

			// Etape 3 : Execution de la requete SQL
			ResultSet resultSet = statement.executeQuery("SELECT * FROM adresse");
			System.out.println();

			// Etape 4 : Parcours des résultats
			while (resultSet.next())
			{
				// on teste si l'id de l'adresse est égal à celui placé en
				// parametre de la méthode
				if (resultSet.getInt("idAdd") == id)
				{
					// chaque ligne du tableau peut etre exploitée, on va
					// recuperer chaque valeur de chaque colonne

					// appel des mutateurs
					adresse.setIdAdd(resultSet.getInt("idAdd"));
					;
					adresse.setAdresse(resultSet.getString("adresse"));
					adresse.setCodePostal(resultSet.getString("codePostal"));
					adresse.setVille(resultSet.getString("ville"));
					adresse.setPays(resultSet.getString("pays"));
					
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
		return adresse;
	}

}
