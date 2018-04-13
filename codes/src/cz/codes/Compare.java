package cz.codes;

import java.io.IOException;
import java.util.ArrayList;

public class Compare {
	
	ArrayList<Integer> nahodne;
	ArrayList<Integer> vstup;
	int iter = 0;
	
		
	public Compare(ArrayList<Integer> vstup ) {
		this.vstup = vstup;
	}
	
	public Compare(ArrayList<Integer> nahodne, ArrayList<Integer> vstup) {
		this.nahodne = nahodne;
		this.vstup = vstup;
	}
		
	public void comp() {
		
				
		while (iter <= 9) {
			
			System.out.println(vstup);
			
			String out = "[";
			
					
		for (int i = 0; i < nahodne.size(); i++) {
			if (nahodne.contains(vstup.get(i)) && (nahodne.get(i) == vstup.get(i))) {
				out = out+="*,";
			}
			
			else if (nahodne.contains(vstup.get(i))) {
				out = out+="o,";
			}
			
				if (nahodne.equals(vstup)) {
					System.out.println("you win");
					System.exit(0);
				}
						
		}
		System.out.print(out);
		System.out.print("]");
				
	    Input inp = new Input();
		
	    try {
			vstup = inp.vstup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		iter++;
		}
		
		System.out.println(nahodne);
	}

}
