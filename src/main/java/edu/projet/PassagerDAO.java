package edu.projet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public interface PassagerDAO extends Interface<Passager, Integer>
{	
	public List<Passager> findAll();

	public Passager findById (Long id);

}
