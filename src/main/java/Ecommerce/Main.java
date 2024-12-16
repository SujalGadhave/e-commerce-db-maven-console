package Ecommerce;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException {
		
		System.out.println("\tWelcome to Ecommerce \n");
		
		Scanner scan = new Scanner(System.in);
		
		Login.login();
		
		while(true) {
			
			System.out.println("1. User Management");
			System.out.println("2. Product Management");
			System.out.println("3. Exit");
			
			int option = scan.nextInt();
			
			if(option == 1) {
				
				UserMangement.userMan();
				
			}else if (option == 2) {
				
				ProductManagement.productManagement();
				
			}else if(option == 3) {
				
				System.out.println("Exiting from ecommerce...");
				return;
				
			}
		}
	}
}
