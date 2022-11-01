import java.sql.SQLException;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws SQLException
	{
		int n;
		MysqlFunctions mf = new MysqlFunctions();
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("1-Add record to databse\n2-Show record\n3-Delete record\n4-exit\nENTER YOUR CHOICE:");
			n = sc.nextInt();
			switch (n) {
				case 1 -> mf.addIntoDatabase();
				case 2 -> mf.showFromDatabase();
				case 3 -> mf.deleteFromDatabse();
				case 4 -> System.exit(1);
				default -> System.out.println("Option not available.");
			}
		}while(true);
	}

}