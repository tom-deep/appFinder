import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User{
	
	
	ArrayList<Admin> admins = new ArrayList<Admin>();
	//only registered employees can be Admins? Not sure how we want this process to work. 
	private String employeeID;
	
	
	public Admin(String username, String password, boolean flag, String employeeID) {
		super(username, password);
		this.employeeID = employeeID;
	}
	
	
	public boolean employeeIDMatch(String employeeID) {
		return (this.employeeID.equals(employeeID));
	}
	
	public void login() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to appFinder! Enter your username");
		String temp = input.nextLine();
		System.out.println("Thanks! Now enter your password");
		String temp2 = input.nextLine();
		System.out.println("Enter EmployeeID");
		String temp3 = input.nextLine();
		
		for (int i = 0; i <users.size(); i++) {
			if (admins.get(i).usernameMatch(temp) && admins.get(i).passwordMatch(temp2) && admins.get(i).employeeIDMatch(temp3)) {
				//give admin access
			}
		}
	}

}
