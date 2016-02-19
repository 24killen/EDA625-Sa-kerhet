import java.math.BigInteger;

public class main {
	
	public static void main(String[] args) {
		
		// Notera att storleken på size måste vara minst lika lång 
		// som bitlängden på plaintext
		int size = 512; 
		
		Prime p = new Prime(size);
		
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
		
	}
}