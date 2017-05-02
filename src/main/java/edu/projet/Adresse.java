package edu.projet;

public class Adresse
{

	private int idAdd;
	private String adresse;
	private String codePostal;
	private String ville;
	private String pays;

	public Adresse()
	{

	}

	public Adresse(String adresse, String codePostal, String ville, String pays)
	{

		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	/**
	 * @return the idAdd
	 */
	public int getIdAdd()
	{
		return idAdd;
	}

	/**
	 * @param idAdd
	 *            the idAdd to set
	 */
	public void setIdAdd(int idAdd)
	{
		this.idAdd = idAdd;
	}

	public String getAdresse()
	{
		return adresse;
	}

	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}

	public String getCodePostal()
	{
		return codePostal;
	}

	public void setCodePostal(String codePostal)
	{
		this.codePostal = codePostal;
	}

	public String getVille()
	{
		return ville;
	}

	public void setVille(String ville)
	{
		this.ville = ville;
	}

	public String getPays()
	{
		return pays;
	}

	public void setPays(String pays)
	{
		this.pays = pays;
	}

	public String toString()
	{
		return "Adresse [adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays
				+ "]";
	}
}
