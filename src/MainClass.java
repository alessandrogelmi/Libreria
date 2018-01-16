
public class MainClass 
{
	public static void main(String[] args) 
	{
		Libro l1=new Libro("I promessi sposi", "Manzoni",600);
		Libro l2=new Libro("Moby Dick", "Melvill",650);
		System.out.println(l1.getTitolo()+": "+l1.prezzo()+" €");
		System.out.println(l2.getTitolo()+": "+l2.prezzo()+" €");
		
		Libro l3=new Libro (l1);
		
		System.out.println(l3.getTitolo()+": "+l3.prezzo()+" €");
	}
}
