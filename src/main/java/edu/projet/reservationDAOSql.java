package edu.projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class reservationDAOSql implements ReservationDAO
{

	@Override
	public List<Reservation> findAll()
	{
		List<Reservation> reservations = new ArrayList<>();

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
			ResultSet resultset = statement.executeQuery("SELECT * FROM reservation");
			/*
			 * Etape 4: Parcours des résultats
			 */
			while (resultset.next())
			{
				Reservation reservation = new Reservation();
				reservation.setIdRes(resultset.getInt("idResa"));
				reservation.setNumero(resultset.getString("numero"));

				String temp = resultset.getString("etat");
				if (temp.equals("confirmee"))
				{
					reservation.setEtat(EtatReservation.CONFIRMEE);
				} else
				{
					reservation.setEtat(EtatReservation.ANNULEE);
				}
				PassagerDAOSql pds = new PassagerDAOSql();
				reservation.setPassager(pds.findById(resultset.getInt("idPassager")));

				temp = resultset.getString("dateReservation");
				String[] tempDate = temp.split("-");
				@SuppressWarnings("deprecation")
				Date d = new Date(Integer.parseInt(tempDate[0]), Integer.parseInt(tempDate[1]),
						Integer.parseInt(tempDate[2]));
				reservation.setDate(d);

				reservations.add(reservation);

			}
		} catch (ClassNotFoundException e)
		{
			System.err.println("Chargement du pilote de lecture de BDD impossible");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.err.println("Impossible de trouver la base de donnée");
			e.printStackTrace();
		}

		return reservations;
	}

	@Override
	public Reservation findById(int id)
	{
		Reservation reservation = new Reservation();

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
			ResultSet resultset = statement.executeQuery("SELECT * FROM reservation");
			/*
			 * Etape 4: Parcours des résultats
			 */
			while (resultset.next())
			{
				if (resultset.getInt("idResa") == id)
				{
					reservation.setIdRes(resultset.getInt("idResa"));
					reservation.setNumero(resultset.getString("numero"));

					String temp = resultset.getString("etat");
					if (temp.equals("confirmee"))
					{
						reservation.setEtat(EtatReservation.CONFIRMEE);
					} else
					{
						reservation.setEtat(EtatReservation.ANNULEE);
					}
					PassagerDAOSql pds = new PassagerDAOSql();
					reservation.setPassager(pds.findById(resultset.getInt("idPassager")));

					temp = resultset.getString("dateReservation");
					String[] tempDate = temp.split("-");
					@SuppressWarnings("deprecation")
					Date d = new Date(Integer.parseInt(tempDate[0]), Integer.parseInt(tempDate[1]),
							Integer.parseInt(tempDate[2]));
					reservation.setDate(d);
				}
			}
		} catch (ClassNotFoundException e)
		{
			System.err.println("Chargement du pilote de lecture de BDD impossible");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.err.println("Impossible de trouver la base de donnée");
			e.printStackTrace();
		}

		return reservation;
	}

	public List<Reservation> findByPassager(Passager p)
	{
		List<Reservation> reservations = new ArrayList<>();
		int idPAss = p.getIdPas();
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
			ResultSet resultset = statement.executeQuery("SELECT * FROM reservation");
			/*
			 * Etape 4: Parcours des résultats
			 */
			while (resultset.next())
			{
				if (resultset.getInt("idPassager") == idPAss)
				{
					Reservation reservation = new Reservation();
					reservation.setIdRes(resultset.getInt("idResa"));
					reservation.setNumero(resultset.getString("numero"));

					String temp = resultset.getString("etat");
					if (temp.equals("confirmee"))
					{
						reservation.setEtat(EtatReservation.CONFIRMEE);
					} else
					{
						reservation.setEtat(EtatReservation.ANNULEE);
					}
					PassagerDAOSql pds = new PassagerDAOSql();
					reservation.setPassager(pds.findById(resultset.getInt("idPassager")));

					temp = resultset.getString("dateReservation");
					String[] tempDate = temp.split("-");
					@SuppressWarnings("deprecation")
					Date d = new Date(Integer.parseInt(tempDate[0]), Integer.parseInt(tempDate[1]),
							Integer.parseInt(tempDate[2]));
					reservation.setDate(d);

					reservations.add(reservation);
				}

			}
		} catch (ClassNotFoundException e)
		{
			System.err.println("Chargement du pilote de lecture de BDD impossible");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.err.println("Impossible de trouver la base de donnée");
			e.printStackTrace();
		}

		return reservations;
	}

}
