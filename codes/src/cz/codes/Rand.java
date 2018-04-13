package cz.codes;

import java.util.Collections;
import java.util.ArrayList;

public final class Rand {
	
	final ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	
	final ArrayList<Integer> numbers() {
	
	for (int i = 1; i < 9; i++) {
		numbers.add(i);
		}
	
	Collections.shuffle(numbers);
	ArrayList<Integer> numbersSublist = new ArrayList<Integer>(numbers.subList(1, 5));
	return numbersSublist;
		
	}
	
	
}
