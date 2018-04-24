package testShop;

public class RunShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Users user = new Users("Martin", 20, false);
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
		
	}

}
