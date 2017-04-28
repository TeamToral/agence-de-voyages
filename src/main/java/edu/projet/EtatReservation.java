package edu.projet;

public enum EtatReservation {
		
	ANNULEE("Annul�e"), CONFIRMEE("Confirm�e");

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
