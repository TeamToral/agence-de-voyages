package edu.projet;

import java.util.List;



public interface ReservationDAO extends Interface<Reservation,Integer>{
	
	@Override
	public  List<Reservation> findAll();

		
	@Override
	public Reservation findById (int id);
	
	
	
	
}
