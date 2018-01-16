
public class Libro 
{
	//attributi 
	private String titolo;
	private String autore;
	private int numeroPagine;
	private static double costoPagine=0.05;
	private final double COSTO_FISSO=5.5;
	
	//costruttori
	public Libro(String titolo, String autore, int numeroPagine)
	{
		this.titolo=titolo;		//this.titolo= titolo negli attributi
		this.autore=autore;
		this.numeroPagine=numeroPagine;
	}
	
	//getter e setter
	public String getTitolo()
	{
		return titolo;
	}
	
	public String getAutore()
	{
		return autore;
	}
	
	public int getNumeroPagine()
	{
		return numeroPagine;
	}
	
	public static double getCostoPagine()
	{
		return costoPagine;
	}
	
	public double getCostoFisso()
	{
		return COSTO_FISSO;
	}
	
	public void setTitolo(String titolo)
	{
		this.titolo=titolo;
	}
	
	public void setAutore(String autore)
	{
		this.autore=autore;
	}
	
	public void setNumeroPagine(int numeroPagine)
	{
		this.numeroPagine=numeroPagine;
	}
	
	public static void setCostoPagine (double costo)
	{
		costoPagine=costo;
	}
	
	public double prezzo()
	{
		return ((numeroPagine*costoPagine)+COSTO_FISSO);
	}
}
