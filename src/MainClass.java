import java.io.IOException;

public class MainClass 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Libro l1=new Libro ("I promessi sposi","Manzoni",600);
		Libro l2=new Libro ("Moby Dick","Melville",650);
		Libro l3=new Libro ("Adelchi","Manzoni",200);
		Libro l4=new Libro ("Raccolta di Poesie","Manzoni",340);
		
		
		
//------------Test inserimento libro
		
		/*Scaffale s1=new Scaffale();
		
		try 
		{
			s1.setLibro(l1, 0, 0);
			s1.setLibro(l2, 1, 0);
		}
		catch (EccezionePosizioneNonValida e) 
		{
			System.out.println(e.toString());
		} 
		catch (EccezionePosizioneNonVuota e)
		{
			System.out.println(e.toString());
		}
		
		try 
		{
			System.out.println(s1.getLibro(1, 3));
		} 
		catch (EccezionePosizioneNonValida e) 
		{
			System.out.println(e.toString());
		}
		catch (EccezionePosizioneVuota e)
		{
			System.out.println(e.toString());
		}
		
		
		try 
		{
			s1.rimuoviLibro(3, 1);
		} 
		catch (EccezionePosizioneVuota e) 
		{
			System.out.println(e.toString());
		} 
		catch (EccezionePosizioneNonValida e) 
		{
			System.out.println(e.toString());
		}
		
		System.out.println(s1.toString());*/
		
		Mensola m1=new Mensola();
		m1.setVolume(l1, 1);
		m1.setVolume(l2, 5);
		m1.setVolume(l3, 6);
		m1.setVolume(l4, 10);
		
		/*System.out.println(m1.toString());
		
		try 
		{
			m1.salvaVolumiCSV("volumi.txt");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile scrivere su file");
		}catch (FileException e)
		{
			System.out.println(e.toString());
		}*/
		
		
		
		/*Mensola m2=new Mensola();
		
		try 
		{
			m2=m2.caricaVolumi("volumi.txt");
			System.out.println("Caricamento OK");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile leggere da file");
		} 
		catch (FileException e) 
		{
			System.out.println(e.toString());
		}
		System.out.println(m2.toString());*/
		
		try 
		{
			m1.salvaMensola("Mensola.bin");
			System.out.println("Scittura OK");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile scrivere sul file");
		}
		
		Mensola m2=new Mensola();
		
		try 
		{
			m2=m2.caricaMensola("Mensola.bin");
			System.out.println("Caricamento OK");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Classe non trovata");
		}
		catch (IOException e) 
		{
			System.out.println("Impossibile leggere dal file");
		}
		
		System.out.println(m2.toString());
	}
}