package Ecommerce;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserMangement{
	public static void userMan() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/ecommerce";
		String userName = "root";
		String password = "Sujal@123";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. Add User");
			System.out.println("2. Search User");
			System.out.println("3. Delete User");
			System.out.println("4. Display User data");
			System.out.println("5. Exit");
			
			int option= scan.nextInt();
			
			if(option == 1) {
				System.out.println("\t Add user \n");
				
				System.out.println("Enter user id: ");
				int id = scan.nextInt();
				
				System.out.println("Enter user name: ");
				String name = scan.next();
				
				System.out.println("Enter user age: ");
				String age = scan.next();
				
				System.out.println("Enter user email: ");
				String email = scan.next();
				
				String query = "INSERT INTO ecommerce.user_management (id,name,quantity,price)" + "VALUES(" + id + ",'" + name + "','" +age+ "','"+ email +"');";
				
				statement.execute(query);
				System.out.println("New user added! \n");
			}
			else if(option == 2) {
				
				System.out.println("\t Search product \n");
				
				System.out.println("Enter user name: ");
				String search = scan.next();
				
				String query = "SELECT * FROM ecommerce.user_management WHERE name = '" + search + "';";
				
				ResultSet result =statement.executeQuery(query);
				while(result.next()) {
					for(int i = 1; i < 5; i++) {
						System.out.println(result.getString(i));
					}
				}
			}
			else if(option == 3) {
				System.out.println("\t Remove user \n");
				
				System.out.println("Enter user name: ");
				String remove = scan.next();
				
				String query ="DELETE FROM ecommerce.user_management WHERE name = '" +remove+ "',";
				statement.execute(query);
				
				System.out.println("\n User removed successfully...");
			}
			else if(option == 4) {
				System.out.println("\t Display User \n");
				
				String query = "SELECT * FROM ecommerce.user_management";
				
				ResultSet display =statement.executeQuery(query);
				while(display.next()) {
					for(int i = 1; i < 5; i++) {
						System.out.println(display.getString(i));
					}
				}
			}
			else if(option == 5) {
				connection.close();
				System.out.println("\t Exiting user management \n");
				return;
			}
			else {
				System.out.println("\t Invalid Option try again...");
			}
		}
	}
}