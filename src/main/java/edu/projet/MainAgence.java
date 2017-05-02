package edu.projet;import java.util.ArrayList;import java.util.List;public class MainAgence 
{
	public static void main (String[] args)
	{
		System.out.println("Hello World!");		List <Adresse> adresses =	new ArrayList<>();		List <Adresse> uneAdresse = new ArrayList<>();				AdresseDAOSql passagerSql = new AdresseDAOSql();		adresses.addAll(passagerSql.findAll());		uneAdresse.add(passagerSql.findById(2));
	}
}
