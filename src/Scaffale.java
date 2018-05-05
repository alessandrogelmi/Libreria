
public class Scaffale 
{
	private Mensola[] ripiani;
	private static final int NUM_RIPIANI=5;
	
	//costruttori
	public Scaffale()
	{
		ripiani=new Mensola[NUM_RIPIANI];
	
		for (int i = 0; i < ripiani.length; i++)
		{
			ripiani[i]=new Mensola();
		}
	}
	
	public Scaffale(Scaffale s) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota, EccezionePosizioneVuota
	{
		ripiani=new Mensola[NUM_RIPIANI];
		
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			ripiani[i]=new Mensola();
			for (int j = 0; j < ripiani[i].getNumMaxVolumi(); j++) 
			{
				if(s.getLibro(i, j)!=null)
					setLibro(new Libro(s.getLibro(i, j)), i, j);
			}
		}
	}
	
	public void setLibro(Libro libro, int ripiano, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota
	{
		int returnMensola;
		try 
		{
			returnMensola=ripiani[ripiano].setVolume(libro,posizione);
			if (returnMensola==-2)
				throw new EccezionePosizioneNonVuota(ripiano, posizione);
		} 
		catch (ArrayIndexOutOfBoundsException e) 
		{
			throw new EccezionePosizioneNonValida(ripiano, posizione);
		}
	}

	public Libro getLibro(int ripiano, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
	{
		try 
		{
			return ripiani[ripiano].getVolume(posizione);
		} 
		catch (ArrayIndexOutOfBoundsException e) 
		{
			throw new EccezionePosizioneNonValida(ripiano, posizione);
		}
		catch (NullPointerException e)
		{
			throw new EccezionePosizioneVuota(ripiano,posizione);
		}
		
	}
	
	public void rimuoviLibro (int ripiano, int posizione) throws EccezionePosizioneVuota, EccezionePosizioneNonValida
	{
		/*if (ripiano<0 || ripiano>=NUM_RIPIANI)
			return -1;
		if (ripiani[ripiano].rimuoviVolume(posizione)<0)
			return -2;
		return 1;*/
		
		int returnMensola;
		try 
		{
			returnMensola=ripiani[ripiano].rimuoviVolume(posizione);
			if (returnMensola==-2)
				throw new EccezionePosizioneVuota(ripiano, posizione);
		} 
		catch (ArrayIndexOutOfBoundsException e) 
		{
			throw new EccezionePosizioneNonValida(ripiano,posizione);
		}	
	}
	
	public int getNumMaxLibri (int ripiano)
	{
		if (ripiano<0 ||ripiano >NUM_RIPIANI)
			return -1000;
		return ripiani[ripiano].getNumMaxVolumi();
	}
	
	public String[] elencoTitoli(String autore)
	{
		String[] elencoTitoliAutore;
		int contatore=0;
		
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			for (int j = 0; j < ripiani[i].getNumMaxVolumi(); j++) 
			{
				if (ripiani[i].getVolume(j)!=null)
				{
					if (ripiani[i].getVolume(j).getAutore().compareTo(autore)==0)
						contatore++;
				}
			}
		}
		
		elencoTitoliAutore=new String[contatore];
		
		int k=0;
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			for (int j = 0; j < ripiani[i].getNumMaxVolumi(); j++) 
			{
				if (ripiani[i].getVolume(j)!=null)
				{
					if (ripiani[i].getVolume(j).getAutore().compareTo(autore)==0)
					{
						elencoTitoliAutore[k]=ripiani[i].getVolume(j).getTitolo();
						k++;
					}
				}
			}
		}
		return elencoTitoliAutore;
	}
	
	public int setElencoLibri(Libro[] elencoLibri, int ripiano) throws EccezionePosizioneNonValida, EccezionePosizioneNonVuota
	{
		if (ripiano<0 || ripiano>NUM_RIPIANI) 
			return -1;
		
		int NumLibriDaInserire=ripiani[ripiano].getNumMaxVolumi();
		if (elencoLibri.length<NumLibriDaInserire) 
			NumLibriDaInserire=elencoLibri.length;
		for (int i = 0; i < NumLibriDaInserire; i++) 
		{
			setLibro(elencoLibri[i],ripiano,i);
		}
		return 1;
	}
	
	public String toString()
	{
		String risultato="";
		for (int i = 0; i < NUM_RIPIANI; i++) 
		{
			for (int j = 0; j < getNumMaxLibri(i); j++) 
			{
				try 
				{
					if (getLibro(i,j)!=null) 
					{
						risultato+="("+i+", "+j+") "+getLibro(i, j).toString()+'\n';
					}
				} 
				catch (EccezionePosizioneNonValida e) 
				{
					System.out.println(e.toString());
				} 
				catch (EccezionePosizioneVuota e) 
				{
					
				}
			}
		}
		return risultato;
	}
}

