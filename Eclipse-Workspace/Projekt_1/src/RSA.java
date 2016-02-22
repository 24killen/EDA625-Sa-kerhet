import java.math.BigInteger;
import java.util.Random;


public class RSA {
	Random rand;
	private BigInteger N, e, d;
	
	public RSA(BigInteger p, BigInteger q){
		rand = new Random();
		
		// N = p*q
		N = p.multiply(q); 
		
		BigInteger p_sub_1 = p.subtract(BigInteger.ONE);	//p-1
		BigInteger q_sub_1 = q.subtract(BigInteger.ONE);	//q-1
		
		// phi = (p-1)(q-1)
		BigInteger phi = p_sub_1.multiply(q_sub_1);

		// While e > phi or gcd (e, phi) != 1
		do{
			e = new BigInteger(N.bitLength(), rand);
		}while(e.compareTo(phi) != 1 									//e>phi
				|| e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0);	//gcd(e,phi) = 1
		
		d = e.modInverse(phi);											// d = e^-1 mod(p-1)(q-1)
		//d = Prime.inverseMod(e, phi);
	}
	
	public BigInteger encrypt(BigInteger plainText){
		return Prime.exp_mod(plainText, e, N);
	}

	public BigInteger decrypt(BigInteger cipherText){
		return Prime.exp_mod(cipherText, d, N);
	}
	
}
