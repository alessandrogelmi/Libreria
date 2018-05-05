
public class EccezionePosizioneVuota extends Exception 
{
	int ripiano;
	int posizione;
	
	public EccezionePosizioneVuota(int ripiano, int posizione)
	{
		this.ripiano=ripiano;
		this.posizione=posizione;
	}
	
	public String toString()
	{
		return ("("+ripiano+" ; "+posizione+") -> Posizione vuota");
	}
}
