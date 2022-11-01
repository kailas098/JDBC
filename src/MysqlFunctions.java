import java.sql.*;
import java.util.Scanner;

public class MysqlFunctions
{
	private int user_id;
	private String user_name,user_email;

	public void addIntoDatabase() throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		Statement stmt = con.createStatement();

		Scanner sc = new Scanner(System.in);
		System.out.println("enter your name:");
		user_name = sc.nextLine();
		System.out.println("enter your email:");
		user_email = sc.nextLine();

		String s = "INSERT INTO user_info (user_name,user_email) VALUES ('" +user_name+"','"+user_email+"')";

		stmt.execute(s);

		System.out.println("Query executed.");
		stmt.close();
		con.close();
		return;
	}

	public void showFromDatabase() throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		Statement stmt = con.createStatement();
		String s  = "SELECT * FROM user_info";

		ResultSet res = stmt.executeQuery(s);
		while(res.next())
		{
			user_id = res.getInt(1);
			user_name = res.getString(2);
			user_email = res.getString(3);
			System.out.println("user id:"+user_id+"\nname:"+user_name+"\nemail:"+user_email+"\n");
		}
		stmt.close();
		con.close();
		return;
	}

	public void deleteFromDatabse()throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		Statement stmt = con.createStatement();

		Scanner sc = new Scanner(System.in);
		System.out.println("enter your id:");
		user_id = sc.nextInt();
		sc.nextLine();
		String s = "DELETE FROM user_info WHERE user_id="+user_id;
		stmt.execute(s);

		System.out.println("Query executed.");
		stmt.close();
		con.close();
		return;
	}

}
