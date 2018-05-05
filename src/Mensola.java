import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Mensola implements Serializable
{
	private Libro[] volumi;
	private static final int NUM_MAX_VOLUMI=15;
	
	private static Scanner tastiera;
	
	//costruttori
	public Mensola()
	{
		volumi=new Libro[NUM_MAX_VOLUMI];
	}
	
	public Mensola(Mensola m)
	{
		volumi=new Libro[NUM_MAX_VOLUMI];
		for (int i = 0; i < NUM_MAX_VOLUMI; i++) 
		{
			if(m.getVolume(i)!=null)
				setVolume(new Libro (m.getVolume(i)),i);
		}
	}
	
	//Setter e getter
			//se posizione sbagliata -> return -1
			//se posizione occupata -> return -2
			//se ok -> return posizione
		public int setVolume (Libro volume,int posizione)
		{	
			if(volumi[posizione]==null)
				volumi[posizione]=new Libro(volume);
			else
				return -2;
			
			return posizione;
		}
		
			//se posizione sbagliata -> return null
			//se posizione vuota --> return null
			//se posizione ok -> return libro
		public Libro getVolume(int posizione)
		{
			return new Libro(volumi[posizione]);	
		}

		public int rimuoviVolume (int posizione)
		{
			if (volumi[posizione]==null)
				return -2;
			volumi[posizione]=null;
			return posizione;
		}
		
		public static int getNumMaxVolumi()
		{
			return NUM_MAX_VOLUMI;
		}
		
		public int getNumVolumi()
		{
			int c=0;
			for (int i = 0; i < NUM_MAX_VOLUMI; i++) 
			{
				if(volumi[i]!=null)
					c++;
			}
			return c;
		}
		
		public String toString()
		{
			String risultato="";
			for (int i = 0; i < NUM_MAX_VOLUMI; i++) 
			{
				if (volumi[i]!=null)
					risultato+=volumi[i].toString()+"\n";
			}
			return risultato;
		}
		
		public boolean cercaTitolo()
		{
			String titoloCercare="";
			tastiera = new Scanner(System.in);
			System.out.print("Inserisci il titolo da cercare: ");
			titoloCercare=tastiera.nextLine();
			int c=0;
			
			for(int i = 0; i < volumi.length; i++) 
			{
				if(volumi[i]!=null)
					if(volumi[i].getTitolo().compareToIgnoreCase(titoloCercare)==0)
						c++;
			}
			
			if(c==0)
				return false;
			else 
				return true;
		}
		
		public void salvaVolumiCSV(String nomeFile) throws IOException, FileException
		{
			TextFile file=new TextFile(nomeFile,'W');
			Libro libro;
			String libroCSV;
			
			for (int i = 0; i < NUM_MAX_VOLUMI; i++) 
			{
				if(volumi[i]!=null)
				{
					libro=getVolume(i);
					libroCSV=i+";"+libro.getTitolo()+";"+libro.getAutore()+";"+libro.getNumeroPagine()+";";
					file.toFile(libroCSV);
				}
			}
			file.closeFile();
		}
		
		public Mensola caricaVolumi(String nomeFile) throws IOException, FileException
		{
			TextFile file=new TextFile(nomeFile,'R');
			
			String libroCSV;
			String[] elementiLibro;
			Libro libro;
			Mensola m=new Mensola();
			
			try 
			{
				for (int i = 0; i < NUM_MAX_VOLUMI; i++) 
				{
					libroCSV=file.fromFile();
					elementiLibro=libroCSV.split(";");
					libro=new Libro(elementiLibro[1], elementiLibro[2], Integer.parseInt(elementiLibro[3]));
					m.setVolume(libro, Integer.parseInt(elementiLibro[0]));
				}
			} 
			catch (EccezioneTextFileEOF e) 
			{
				
			}
			file.closeFile();
			return m;
		}
		
		public void salvaMensola(String nomeFile) throws IOException
		{
			FileOutputStream file=new FileOutputStream(nomeFile);
			ObjectOutputStream writer=new ObjectOutputStream(file);
			
			writer.writeObject(this);
			writer.flush();
			file.close();
		}
		
		public Mensola caricaMensola(String nomeFile) throws IOException, ClassNotFoundException
		{
			FileInputStream file=new FileInputStream(nomeFile);
			ObjectInputStream reader= new ObjectInputStream(file);
			
			Mensola m;
			m=(Mensola)reader.readObject();
			
			file.close();
			return m;
		}
	}



