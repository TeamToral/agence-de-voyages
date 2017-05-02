package edu.projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationDAOfile implements ReservationDAO
{

	@Override
	public List<Reservation> findAll()
	{

		String op = "";
		List<Reservation> ListeDesReservations = new ArrayList<>();

		File f = new File("reservations.txt");
		FileReader fr = new FileReader(f);

		// Creation d'un bufferReader qui lit ligne par ligne
		BufferedReader br = new BufferedReader(fr);

		// on lit ligne par ligne grace au bufferReader et on sotck la ligne
		// dans une chaine de charactere op tant qu'il reste une ligne
		while ((op = br.readLine()) != null)
		{
			// on sotck les chaines de characteres de chaque ligne séparées par
			// un ; dans un tableau de chaine de characteres
			String[] tabOp = op.split(";");

			if (Integer.getInteger(tabOp[0]) == 0)
			{
				// ListeDesReservations.add(new
				// Reservation(Integer.parseInt(tabOp[0]),
				// SimpleDateFormat.parse(tabOp[2]),
				// EtatReservation(tabOp[3])));
			}
		}
	}

	@Override
	public Reservation findById(Long id)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
