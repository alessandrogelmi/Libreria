
public class EccezionePosizioneNonValida extends Exception
{
	int ripiano;
	int posizione;
	
	public EccezionePosizioneNonValida(int ripiano, int posizione)
	{
		this.ripiano=ripiano;
		this.posizione=posizione;
	}
	
	public String toString()
	{
		return ("("+ripiano+" ; "+posizione+") -> Posizione non valida");
	}
}
