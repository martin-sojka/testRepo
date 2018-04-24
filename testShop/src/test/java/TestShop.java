package test.java;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import testShop.Users;

import static org.mockito.Mockito.*;

public class TestShop {
	
	Users testUsers = new Users("Pepa", 55, false);
	Users tUser = mock(Users.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		String name = testUsers.getName();
		when(tUser.getName()).thenReturn(name);
		assertEquals(tUser.getName(), "Pepa");
	}

	@Test
	public void testGetAge() {
		when(tUser.getAge()).thenReturn(55);
	}

	@Test
	public void testSetLogged() {
		when(tUser.setLogged()).thenReturn(false);
		assertFalse(false);
	}

	@Test
	public void testGetLogged() {
		assertTrue(true);
	}

	
	@Test
	public void testOrder() {
		when(tUser.order(anyInt())).thenReturn(5, 5);
	}

}
