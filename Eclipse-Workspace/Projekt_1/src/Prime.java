import java.math.BigInteger;
import java.util.Random;

/** TODO */
public class Prime {
	private int size;
	
	public Prime(int size){
		this.size = size;
	}
	
	public BigInteger getPrime(){
		// Denna funktion får inte användas enligt uppgiften.
		return new BigInteger(size, 15, new Random()); 
	}
}
