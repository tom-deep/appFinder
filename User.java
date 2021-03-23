import java.util.ArrayList;
import java.util.Scanner;

public class User {
	private final String username;
	private final String password;
	
	ArrayList<User> users = new ArrayList<User>();
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean usernameMatch(String username) {
		return this.username.equals(username);
	}
	
	public boolean passwordMatch(String password) {
		return this.password.equals(password);
	}
	
	public void login() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to appFinder! Enter your username");
		String temp = input.nextLine();
		System.out.println("Thanks! Now enter your password");
		String temp2 = input.nextLine();
		
		for (int i = 0; i <users.size(); i++) {
			if (users.get(i).usernameMatch(temp) && users.get(i).passwordMatch(temp2)) {
				//give user access
			}
		}
	}
}




