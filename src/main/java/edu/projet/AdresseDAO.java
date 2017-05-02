package edu.projet;

import java.util.List;

public interface AdresseDAO
{
	public List<Adresse> findAll();

	public Adresse findById (int id);
}
