package edu.projet;

import java.sql.Date;

public class Reservation {
	
	private int id;
	private Date dateReservation;
	private int numeroReservation;
	private EtatReservation etatReservation;
	public static int nbReservation=0;
		
	
	public Reservation(int id, Date dateReservation, int numeroReservation, EtatReservation etatReservation) {
		this.id = id;
		this.dateReservation = dateReservation;
		this.numeroReservation = numeroReservation;
		this.etatReservation = etatReservation;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public int getNumeroReservation() {
		return numeroReservation;
	}
	public void setNumeroReservation(int numeroReservation) {
		this.numeroReservation = numeroReservation;
	}
	
	
	

}
