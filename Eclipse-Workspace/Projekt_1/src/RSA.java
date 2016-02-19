import java.math.BigInteger;
import java.util.Random;


public class RSA {
	Random rand;
	private BigInteger N, e, d;
	
	public RSA(BigInteger p, BigInteger q){
		rand = new Random();
		
		// N = p*q
		N = p.multiply(q); 
		
		BigInteger p_sub_1 = p.subtract(BigInteger.ONE);
		BigInteger q_sub_1 = q.subtract(BigInteger.ONE);
		
		// phi = (p-1)(q-1)
		BigInteger phi = p_sub_1.multiply(q_sub_1);

		// While e > phi or gcd (e, phi) != 1
		do{
			e = new BigInteger(N.bitLength(), rand);
		}while(e.compareTo(phi) != 1 
				|| e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0);
		
		d = e.modInverse(phi);	
	}
	
	// Implemented just for fun and it's an easy way to test if it works :)
	public BigInteger encrypt(BigInteger plainText){
		return exp_mod(plainText, e, N);
	}

	// Implemented just for fun and it's an easy way to test if it works :)
	public BigInteger decrypt(BigInteger cipherText){
		return exp_mod(cipherText, d, N);
	}
	
	// Implemented from the Project 1 instruction, Bonus section.
	// Computes a^x mod N - Recursive form
	private static BigInteger exp_mod(BigInteger a, BigInteger x, BigInteger N){
		// Assume a >= 0, x >= 0 N > 1
		if(a.compareTo(BigInteger.ZERO) == 0)
			return BigInteger.ZERO;
		
		if(x.compareTo(BigInteger.ZERO) == 0)
			return BigInteger.ONE;
		
		if(x.testBit(0))
			return a.multiply(exp_mod(a, x.subtract(BigInteger.ONE), N)).mod(N);
		else
			return exp_mod(a, x.divide(BigInteger.valueOf(2)), N).pow(2).mod(N);
	}
}
