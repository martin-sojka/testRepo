package cz.codes;

import java.io.IOException;

public class Code {

	public static void main(String[] args) {
		
		Rand nahodne = new Rand();
		//System.out.println(nahodne.numbers());
		
		Input vstup = new Input();
		//System.out.println(vstup.vstup());
		
		Compare porovnat;
		try {
			porovnat = new Compare(nahodne.numbers(), vstup.vstup());
			porovnat.comp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
