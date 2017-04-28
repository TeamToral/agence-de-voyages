package edu.projet;import java.util.ArrayList;import java.util.List;public class MainAgence 
{
	public static void main (String[] args)
	{
		System.out.println("Hello World!");		List <Passager> passagers =	new ArrayList<>();				passagers.addAll( new PassagerDAOFile.findAll() );
	}
}
