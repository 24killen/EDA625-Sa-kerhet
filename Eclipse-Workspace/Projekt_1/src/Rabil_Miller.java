import java.math.BigInteger;
import java.util.Random;

public class Rabil_Miller {
	Random rand;
	
	public Rabil_Miller(){
		rand = new Random();
	}
	
	public boolean isPrime(BigInteger n){	//Ska i anta att (n>3 && n%2 = 1) eller ska vi kontrollera?
		BigInteger a, s, r;
		
		long max = n.longValue()-2;
		
		//Uträkning av s och r...
		do{
			a = new BigInteger(n.bitLength(),rand);
		}while(a.compareTo(BigInteger.valueOf(2))!=-1 
				|| a.compareTo(BigInteger.valueOf(max))!=1);	//while 2<=a && a<=n-2...
		
		BigInteger x = a.pow(s.intValue()).mod(n);
		if(x.compareTo(BigInteger.valueOf(1))==0
				|| x.compareTo(BigInteger.valueOf(max+1))==0){	//if x=1 || x=n-1
			return true;
				}
		for(int j=1;j<r.intValue()-1;j++){		//OBS!!! Villkoren måste förbättras
			//x = a.pow(s.multiply(BigInteger.valueOf(2).pow(j))) % n.intValue();
			//x = x.multiply(x) % n.intValue();		
		//Båda ska testas och jämföras, antingen här eller i en separat testklass som tar tiden. Bästa väljs till denna klass.
			
			if(x.compareTo(BigInteger.valueOf(1))==0) return false;
			if(x.compareTo(BigInteger.valueOf(max+1))==0) return true;
		}
		return false;
	}
	

}
