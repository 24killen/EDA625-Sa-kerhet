import java.math.BigInteger;

public class main {
	
	public static void main(String[] args) {
		
		// Notera att storleken på size måste vara minst lika lång 
		// som bitlängden på plaintext
		int size = 512; 
		
		Prime p = new Prime(size);
		 //Print all primes between 2 and 100
		for(int i = 2; i < 100; i++){
			if(p.isPrime(BigInteger.valueOf(i)))
				System.out.print(i+", ");
		}
//		p.isPrime(BigInteger.valueOf(25));
//		p.isPrime(BigInteger.valueOf(28));
		// While 25 is prime (it's not a prime, but it's still true..
		int counter = 0;
		while(p.isPrime(BigInteger.valueOf(25))){
			counter++;
		}
		System.out.println();
		System.out.println("25 is set as a prime "+counter +" times.");
		
		
		/*
		RSA rsa = new RSA(p.getPrime(),p.getPrime());
		
		// A test to see if it works! 
		String plainText = "Detta är ett hemligt meddelande som krypteras.";
		BigInteger cypher = rsa.encrypt(new BigInteger(plainText.getBytes()));
		String textBack = new String(rsa.decrypt(cypher).toByteArray());
		
		System.out.println("Sträng-baserad utskrift");
		System.out.println("Klartext: \t"+plainText);
		System.out.println("Krypterad: \t"+cypher.toByteArray());
		System.out.println("Avkrypterad: \t"+textBack);
		System.out.println();
		System.out.println("BigInteger-baserad utskrift");
		System.out.println("Klartext: \t"+new BigInteger(plainText.getBytes()));
		System.out.println("Krypterad: \t"+cypher);
		System.out.println("Avkrypterad: \t"+new BigInteger(textBack.getBytes()));
		System.out.println();
		System.out.println("Bit-baserad utskrift");
		System.out.println("Klartext: \t"+new BigInteger(plainText.getBytes()).toString(2));
		System.out.println("Krypterad: \t"+cypher.toString(2));
		System.out.println("Avkrypterad: \t"+new BigInteger(textBack.getBytes()).toString(2));
		*/
	}
}