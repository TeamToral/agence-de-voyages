package edu.projet;

import java.util.*;

public interface PassagerDAO extends Interface<Passager, Integer>
{	
	public List<Passager> findAll();

	public Passager findById (int id);
}
