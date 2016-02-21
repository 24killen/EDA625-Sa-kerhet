import java.math.BigInteger;
import java.util.Random;

/** TODO */
public class Prime {
	private Random rand;

	private final static BigInteger ZERO = BigInteger.ZERO;
	private final static BigInteger ONE = BigInteger.ONE;
	private final static BigInteger TWO = new BigInteger("2");
	private final static BigInteger FOUR = new BigInteger("4");
	
	public Prime(){
		rand = new Random();
	}
	
	// Returns a random prime number.
	public BigInteger getPrime(int nbrOfBits){
		BigInteger num;
		do{
			num = randOddBigInt(nbrOfBits);
		}while(!isPrime(num));
		return num;
	}
	
	// Returns a random odd BigInteger
	public BigInteger randOddBigInt(int nbrOfBits){
		BigInteger num;
		do{
			num = new BigInteger(nbrOfBits, rand);
		}while(!num.testBit(0)); // Check the last bit if it's even or odd. 
		return num;
	}
	
	public boolean isPrime(BigInteger n){
		if(n.compareTo(FOUR) < 0 && n.compareTo(ZERO) > 0){
			return true;
		}else if( n.compareTo(ZERO) < 0){
			return false;
		}
		
		BigInteger a, s, x, n_1;
		int r;
		
		n_1 = n.subtract(ONE); // n-1
		r = n_1.getLowestSetBit(); // Number of times a division of 2 is possible from n_1
		s = n_1.shiftRight(r);		// s = n-1 / 2^r
		
		
		for(int i = 0; i < 20; i++){
			do{
				a = new BigInteger(n.bitLength(),rand);
			}while(!(a.compareTo(TWO) >= 0 && a.compareTo(n.subtract(TWO)) <= 0));	// while !(a >= 2 && a <= n-2)
			x = exp_mod(a, s, n);
			
			//if x=1 || x=n-1
			if(x.equals(ONE) || x.equals(n_1)) return true;
			
			for(int j = 1; j <= r - 1; j++){
				x = exp_mod(x, s.multiply(TWO.pow(j)), n);
				//x = exp_mod(x,TWO,n);
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
