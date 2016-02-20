import java.math.BigInteger;
import java.util.Random;

/** TODO */
public class Prime {
	private int size;
	private Random rand;
	
	private final static BigInteger ONE = BigInteger.ONE;
	private final static BigInteger TWO = new BigInteger("2");
	private final static BigInteger FOUR = new BigInteger("4");
	
	public Prime(int size){
		this.size = size;
		rand = new Random();
	}
	
	public BigInteger getPrime(){
		// Denna funktion får inte användas enligt uppgiften.
		return new BigInteger(size, 15, new Random()); 
	}
	
	public boolean isPrime(BigInteger n){	//Ska i anta att (n>3 && n%2 = 1) eller ska vi kontrollera?
		if(n.compareTo(FOUR) < 0) return true;
		BigInteger a, s, x, n_1;
		int r;
		
		s = n.subtract(ONE);
		r = s.getLowestSetBit();
		s = s.shiftRight(r);
		n_1 = n.subtract(ONE);
		
		for(int i = 0; i < 20; i++){
			do{
				a = new BigInteger(n.bitLength(),rand);
			}while(!(a.compareTo(TWO) >= 0 && a.compareTo(n.subtract(TWO)) <= 0));	// while !(a >= 2 && a <= n-2)
			
			x = exp_mod(a, s, n);
			if(x.equals(ONE)
					|| x.equals(n.subtract(ONE))){	//if x=1 || x=n-1
				return true;
			}
			
			for(int j = 1; j < r - 1; j++){
				x = exp_mod(a, s.multiply(TWO.pow(j)), n);
				/* 
				//DEBUG Info
				System.out.println("a: "+a.intValue());
				System.out.println("s: "+s.intValue());
				System.out.println("n: "+n.intValue());
				System.out.println("x: "+x.intValue());
				System.out.println("r: "+r);
				System.out.println("j: "+j);
				System.out.println("------");
				*/
				if(x.equals(ONE)) return false;
				if(x.equals(n_1)) return true;
			}
		}
		return false;
	}
	
	// Implemented from the Project 1 instruction, Bonus section.
	// Computes a^x mod N - Recursive form
	public static BigInteger exp_mod(BigInteger a, BigInteger x, BigInteger N){
		// Assume a >= 0, x >= 0 N > 1
		if(a.compareTo(BigInteger.ZERO) == 0)
			return BigInteger.ZERO;
		
		if(x.compareTo(BigInteger.ZERO) == 0)
			return BigInteger.ONE;
		
		if(x.testBit(0))
			return a.multiply(exp_mod(a, x.subtract(BigInteger.ONE), N)).mod(N);
		else
			return exp_mod(a, x.shiftRight(1), N).pow(2).mod(N); //ShiftRight  = divide by 2, but faster
	}
}
