package cz.codes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.ArrayList;


public class TestCompare {
	
	Compare comp = mock(Compare.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCompareArrayListOfInteger() {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		
	}

	@Test
	public void testCompareArrayListOfIntegerArrayListOfInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testComp() {
		fail("Not yet implemented");
	}

}
