import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int Eid, age, Ch, k;
		String firstname, lastname;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcmenu", "root", "root");
			Statement smt = con.createStatement();

			do {
				System.out.println("1. Insert \n2. Update \n3. Delete \n4. Search \n5. Display \n6. Count Employees \n7. Minimum age \n8. Maximum age \n9. Average age \n10. Exit");
				System.out.println("\nSelect your option");
				Ch = Integer.parseInt(sc.nextLine());

				switch (Ch) {
				case 1:
					System.out.println("How many recoreds do you want to insert");
					Integer n = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < n; i++) {
						System.out.println("Enter the Eid :");
						Eid = Integer.parseInt(sc.nextLine());
						System.out.println("Enter age");
						age = Integer.parseInt(sc.nextLine());
						System.out.println("Enter firstname");
						firstname = sc.nextLine();
						System.out.println("Enter lastname");
						lastname = sc.nextLine();
						k= smt.executeUpdate("insert into Employee values(" + Eid + ",'" + firstname + "','" + lastname
								+ "'," + age + ")");
					}
					break;

				case 2:
					System.out.println("Enter the Eid");
					Eid = Integer.parseInt(sc.nextLine());
					System.out.println("Enter firstname");
					firstname = sc.nextLine();

					k = smt.executeUpdate("Update Employee set firstname = '" + firstname + "' Where Eid=" + Eid);
					if (k > 0) {
						System.out.println("Record is updated");
					}
					System.out.println("------------------------");
					break;

				case 3:
					System.out.println("Enter the Eid to delete");
					Eid = Integer.parseInt(sc.nextLine());
					k = smt.executeUpdate("Delete from Employee Where Eid =" + Eid);
					if (k > 0)

					{
						System.out.println("Record is deleted");
					}
					System.out.println("------------------------");
					break;

				case 4:
					System.out.println("Enter Eid to Search data");
					Eid = Integer.parseInt(sc.nextLine());
					ResultSet rs1 = smt.executeQuery("select*from Employee Where Eid=" + Eid);
					while (rs1.next())
				{
					System.out.println(
							rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t" + rs1.getInt(4));
				}
					System.out.println("-------------------------");
					break;

				case 5:
					ResultSet rs = smt.executeQuery("select*from Employee");
					while (rs.next())
				{
					System.out.println(
							rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
				}
					System.out.println("-------------------------");
					break;
					
				case 6:
					String q="Select COUNT(*) from Employee";
					ResultSet rs2 = smt.executeQuery(q);
					rs2.next();
					int count = rs2.getInt(1);
					System.out.println("Number of Employees : " + count);
					System.out.println("-------------------------");
					break;
					
				case 7:
					String q1="Select MIN(age) from Employee";
					ResultSet rs3 = smt.executeQuery(q1);
					rs3.next();
					int count1 = rs3.getInt(1);
					System.out.println("Minimum age of Employee from table : " + count1);
					System.out.println("-------------------------");
					break;
					
				case 8:
					String q2="Select MAX(age) from Employee";
					ResultSet rs4 = smt.executeQuery(q2);
					rs4.next();
					int count2 = rs4.getInt(1);
					System.out.println("Maximum age of Employee from table : " + count2);
					System.out.println("-------------------------");
					break;
					
				case 9:
					String q3="Select AVG(age) from Employee";
					ResultSet rs5 = smt.executeQuery(q3);
					rs5.next();
					int count3 = rs5.getInt(1);
					System.out.println("Average age of Employee from table : " + count3);
					System.out.println("-------------------------");
					break;
				case 10:
					System.out.println("Exit from operations");
					System.exit(0);

				default:
					System.out.println("\nInvalid option, enter valid option\n");
					break;
				}
			}

			while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




