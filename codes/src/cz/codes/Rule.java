package cz.codes;

public class Rule {

	public static void main(String[] args) {
		
		long n = 10;
		long k = 4;
		long pomN = n;
		long pomK = k;
		final long total;
		// final long prob;
		
		for (int i = (int) (n - 1); i > (n-k); i--) {
			 
			pomN = (pomN * i);
								
		}
			
			for (int j = (int) (k - 1); j > 0; j--) {
				
				pomK *= j;
				
			}
			
		total = pomN / pomK;
		System.out.println(total);
		
		// prob = (k / total);
		// System.out.println(prob);

	}

}
