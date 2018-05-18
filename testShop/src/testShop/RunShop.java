package testShop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunShop {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	Users user = new Users("Martin", 20, false);
		System.out.println(user.getName());
		System.out.println("Logged: " + user.getLogged());
		user.setLogged();
		System.out.println("Logged: " + user.getLogged());
		System.out.println("Goods left: " + user.order());
		user.order(5);
		System.out.println("Goods left: " + user.order());
		
		System.out.println("----------------");
		
		Users user1 = new Users("Petr", 50, false);
		System.out.println(user1.getName());
		System.out.println("Logged: " + user1.getLogged());
		user1.setLogged();
		System.out.println("Logged: " + user1.getLogged());
		System.out.println("Goods left: " + user1.order());
		user1.order(5);
		System.out.println("Goods left: " + user1.order());
		
		System.out.println("----------------");
		
		Goods goods = new Goods();
		goods.addAmount(4);
		System.out.println("Goods add: " + goods.getAmount());
		
		System.out.println("----------------");
		
		System.out.println(user.getName());
		System.out.println("Logged: " + user.getLogged());
		user.setLogged();
		System.out.println("Logged: " + user.getLogged());
		System.out.println("Goods left: " + user.order());
		user.order(1);
		System.out.println("Goods left: " + user.order());
		
		System.out.println("----------------");
		
		System.out.println(user1.getName());
		System.out.println("Logged: " + user1.getLogged());
		user1.setLogged();
		System.out.println("Logged: " + user1.getLogged());
		System.out.println("Goods left: " + user1.order());
		user1.order(2);
		System.out.println("Goods left: " + user1.order());
		
		System.out.println("----------------");
		
		try {
			Class<?> c = Class.forName("testShop.Users");
			Method m[] = c.getDeclaredMethods();
			for (int i = 0; i < m.length; i++)
	            System.out.println(m[i].getName());
	         }
	         catch (Throwable e) {
	            System.err.println(e);
	         }
	      */
		
		// ----------------------------------------------------------
		
	/*	DbConn connection = new DbConn();
		connection.connect(); */
		
		// -----------------------------------------------------------
		
	/*	String[] c = {"jedna", "dve", "tri"}; 
		String[] d = {"ctyri", "pet", "sest"};
		List<String> list = new ArrayList<>(Arrays.asList(c));
		List<String> list2 = new ArrayList<>(Arrays.asList(d));
		
		System.out.println(list.toString());
		
		list2.addAll(list); // add elements from list to list2
		
		for (Object o : list2)
			System.out.println(o); 
		
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext(); ) {
			if (iterator.next() != null)
				iterator.remove();
		}
		
		System.out.println(list.toString()); */
		
		// ------------------------------------------------------------
		
		Integer pocet = 0;
		
		try {
			Scanner s = new Scanner(new File("C:\\Users\\msojka\\git\\testShop\\src\\testShop\\readFile.txt"));
			while (s.hasNext()) {
				 pocet += 1;
				 s.next();
			}
			
			s.close();
			System.out.print(pocet);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	}

}
