package edu.projet;

import java.io.File;

public class Passager
{

	private int id;
	private String nom;
	private String prenom;
	private Adresse adresse;

	public static int nbPassager = 0;

	public Passager(int id, String nom, String prenom)
	{
		this.id = ++nbPassager;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public Adresse getAdresse()
	{
		return adresse;
	}

	public void setAdresse(Adresse adresse)
	{
		this.adresse = adresse;
	}

}
