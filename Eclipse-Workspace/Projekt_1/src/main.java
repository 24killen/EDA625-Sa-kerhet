import java.math.BigInteger;

public class main {
	
	public static void main(String[] args) {
		
		int size = 256;			// Number of bits to start with.
		int maxNbrBits = 2048; 	// Last number of bitLength to check.
		int repeat = 1;			// Number of times to repeat.
		
		Prime p = new Prime();
		
		// Prime test
		String stats = "";
		while(size <= maxNbrBits){
			long start = System.currentTimeMillis();
			for(int i = 0; i < repeat; i++){
				long temp = System.currentTimeMillis();
				p.getPrime(size);
				System.out.println("Prime "+i+" generated after "
						+(double)(System.currentTimeMillis()-temp)/1000 + " seconds. ("+size+" bit)");
			}
			long end = System.currentTimeMillis();
			long diff = (end-start);
			stats += "Time elapsed for "+size+" bitLength: "+ diff/1000 +" seconds\n";
			size *= 2;
		}
		
		System.out.println("---------------------------------------------------------");
		System.out.println(stats);
		System.out.println("---------------------------------------------------------");
	
		/*
		RSA rsa = new RSA(p.getPrime(size),p.getPrime(size));
		
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