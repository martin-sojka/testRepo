package cz.codes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	
	ArrayList<Integer> input = new ArrayList<Integer>();
	Scanner scan = new Scanner(System.in);
	
	final ArrayList<Integer> vstup() throws IOException {
		
		for (int i = 0; i < 4; i++) {
			input.add(scan.nextInt());
				}
		return input;
		
		
	}
}
