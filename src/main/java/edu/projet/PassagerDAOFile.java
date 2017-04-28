package edu.projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PassagerDAOFile implements PassagerDAO

{

	private static File f = new File ("passagers.csv");
	
	public List<Passager> findAll()
	{
		List<String> errorMsg = new ArrayList<>();
		List<Passager> passager = new ArrayList<>();

		try
		{
			// ouverture du lecteur de fichier
			BufferedReader br = new BufferedReader(new FileReader(f));
			String c = "";

			while ((c = br.readLine()) != null)
			{
				String[] cSplit = c.split(";");

				if (Integer.getInteger(cSplit[0]) != null)
				{
					passager.add(new Passager(Integer.parseInt(cSplit[0]), cSplit[1], cSplit[2]));
				}

			}

			br.close();

		} catch (IOException e)
		{
			errorMsg.add(e.getMessage());
		}

		for (String error : errorMsg)
		{
			System.err.println(error);
		}

		return passager;
	}

	
	public Passager findById(Long id)
	{
		List<String> errorMsg = new ArrayList<>();
		Passager passager = null;

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(f));
			String c = "";

			while ((c = br.readLine()) != null)
			{
				String[] cSplit = c.split(";");

				if (!(cSplit[0].length() > 1) && Integer.parseInt(cSplit[0]) == id)
				{
					passager = new Passager(Integer.parseInt(cSplit[0]), cSplit[1], cSplit[2]);
				}

			}

			br.close();

		}

		catch (IOException e)
		{
			errorMsg.add(e.getMessage());
		}

		for (String error : errorMsg)
		{
			System.err.println(error);
		}

		return passager;
	}
}
