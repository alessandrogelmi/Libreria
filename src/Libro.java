import java.io.Serializable;

/**
 * La classe rappresenta un libro. Il libro è costituito da un titoloun autore, un numero di pagine, il costo di ciuascuna pagina e 
 * il costo fisso per ogni copia del libro. Il costo di ciascuna pagina e il costo fisso sono uguali per ogni istanza di Libro,
 * se modificati cambiano il loro valore per ogni istanza.
 * 
 * La classe consente di impostare e rilevare i valori degli attributi pubblici e di calcolare il prezzo di un libro
 * 
 * @author Gelmi Alessandro
 * @version 1.0
 */
public class Libro implements Serializable
{
	//	ATTRIBUTI
	private String titolo;
	private String autore;
	private int numeroPagine;
	private static double costoPagina=0.05;
	private final double COSTO_FISSO=5.5;
	
/**
 * Costruttore di Libro
 * @param titolo titolo del libro
 * @param autore autore del libro
 * @param numeroPagine numero di pagine del libro
 * 
 */
	public Libro(String titolo, String autore, int numeroPagine)
	{
		this.titolo=titolo;
		this.autore=autore;
		this.numeroPagine=numeroPagine;
	}
	
/**
 * Costruttore di copia. Istanza un libro copia di un altro libro
 * @param libro da copiare
 */
	public Libro (Libro libro)
	{
		titolo=libro.getTitolo();
		autore=libro.getAutore();
		numeroPagine=libro.getNumeroPagine();
				
	}
	
/**
 * Costruttore di default. Istanzia un libro senza titolo, autore e numero pagine uguale a 0
 */
	public Libro()
	{
		titolo="";
		autore="";
		numeroPagine=0;
	}
	
	
	//	GETTER E SETTER
/**
 * 
 * @return titolo del libro interessato
 */
	public String getTitolo()
	{
		return titolo;
	}
	
	public String getAutore()
	{
		return autore;
	}
	
	public int getNumeroPagine ()
	{
		return numeroPagine;
	}
	
	public double getCostoFisso()
	{
		return COSTO_FISSO;
	}
	
	public static double getCostoPagina()
	{
		return costoPagina;
	}
	
/**
 * 
 * @param titolo del libro
 */
	public void setTitolo(String titolo)
	{
		this.titolo=titolo;
	}
	
	public void setAutore(String autore)
	{
		this.autore=autore;
	}
	
/**
 * Imposta il numero di pagine. Se è minore di zero lo imposta a 0
 * @param numeroPagine
 */
	public void setNumeroPagine(int numeroPagine)
	{
		if (numeroPagine>0)
			this.numeroPagine=numeroPagine;
		else
			this.numeroPagine=0;
	}
	
	public static void setCostoPagina (double costo)
	{
		costoPagina=costo;
	}
	
	//	ALTRI METODI
	public double prezzo()
	{
		return ((numeroPagine*costoPagina)+COSTO_FISSO);
	}
	
	public String toString()
	{
		return (getTitolo()+", "+getAutore()+", "+prezzo()+" €");
	}
	
	public boolean equals(Libro l)
	{
		if (getTitolo()==l.getTitolo() && getAutore()==l.getAutore() && getNumeroPagine()==l.getNumeroPagine())
			return true;
		else
			return false;
	}
}