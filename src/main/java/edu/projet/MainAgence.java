package edu.projet;import java.util.ArrayList;import java.util.List;public class MainAgence 
{
	public static void main (String[] args)
	{
		System.out.println("Hello World!");				AdresseDAOSql adresseSql = new AdresseDAOSql();		List <Adresse> adresses =	adresseSql.findAll();		System.out.println(adresses);		Adresse uneAdresse = adresseSql.findById(2);		System.out.println(uneAdresse);				PassagerDAOSql passagerSql = new PassagerDAOSql();		List<Passager> passagers = passagerSql.findAll();		Passager unpassager = passagerSql.findById(1);		System.out.println(passagers);		System.out.println(unpassager);				reservationDAOSql reservationSql = new reservationDAOSql();		List <Reservation> reservations = reservationSql.findAll();		Reservation unereservation = reservationSql.findById(10);		List <Reservation> reservationPassager = reservationSql.findByPassager(passagers.get(1));		System.out.println(reservations);		System.out.println(unereservation);		System.out.println(reservationPassager);
	}
}
