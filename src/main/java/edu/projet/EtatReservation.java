package edu.projet;

public enum EtatReservation {
		
	ANNULEE("Annulée"), CONFIRMEE("Confirmée");

    private final String label;

    private EtatReservation(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }
}
