package Ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductManagement{
	public static void productManagement() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/ecommerce";
		String userName = "root";
		String password = "Sujal@123";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. Add Product");
			System.out.println("2. Search Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Display products data");
			System.out.println("5. Exit");
			
			int option= scan.nextInt();
			
			if(option == 1) {
				System.out.println("\t Add Product \n");
				
				System.out.println("Enter product id: ");
				int id = scan.nextInt();
				
				System.out.println("Enter product name: ");
				String name = scan.next();
				
				System.out.println("Enter product quantity: ");
				String quantity = scan.next();
				
				System.out.println("Enter product price: ");
				String price = scan.next();
				
				String query = "INSERT INTO ecommerce.product_management (id,name,quantity,price)" + 
								"VALUES(" + id + ",'" + name + "','" +quantity+ "','"+ price +"');";
				
				statement.execute(query);
				System.out.println("New product added! \n");
			}
			else if(option == 2) {
				
				System.out.println("\t Search product \n");
				
				System.out.println("Enter product name: ");
				String search = scan.next();
				
				String query = "SELECT * FROM ecommerce.product_management WHERE name = '" + search + "';";
				
				ResultSet result =statement.executeQuery(query);
				while(result.next()) {
					for(int i = 1; i < 5; i++) {
						System.out.println(result.getString(i));
					}
				}
			}
			else if(option == 3) {
				System.out.println("\t Remove product \n");
				
				System.out.println("Enter product name: ");
				String remove = scan.next();
				
				String query ="DELETE FROM ecommerce.product_management WHERE name = '" +remove+ "',";
				statement.execute(query);
				
				System.out.println("\n Product removed successfully...");
			}
			else if(option == 4) {
				System.out.println("\t Display Product \n");
				
				String query = "SELECT * FROM ecommerce.product_management";
				
				ResultSet display =statement.executeQuery(query);
				while(display.next()) {
					for(int i = 1; i < 5; i++) {
						System.out.println(display.getString(i));
					}
				}
			}
			else if(option == 5) {
				connection.close();
				System.out.println("\t Exiting product management \n");
				return;
			}
			else {
				System.out.println("\t Invalid Option try again...");
			}
		}
	}
}
