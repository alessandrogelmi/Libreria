
public class EccezionePosizioneNonVuota extends Exception
{
	int ripiano;
	int posizione;
	
	public EccezionePosizioneNonVuota(int ripiano, int posizione)
	{
		this.ripiano=ripiano;
		this.posizione=posizione;
	}
	
	public String toString()
	{
		return ("("+ripiano+" ; "+posizione+") -> Posizione non vuota");
	}
}
