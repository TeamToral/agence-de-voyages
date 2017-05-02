package edu.projet;

import java.util.*;

public interface Interface<T, PK>
{
	public List<T> findAll();

	public T findById (int id);
}

