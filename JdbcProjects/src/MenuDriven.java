import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
public class MenuDriven {

	public static void main(String[] args) throws Exception{
		int usn;
		String name;
		int marks;
		Connection con=null;
		Statement st=null;
		ResultSet r=null;
		int ch;
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfully connected");
			con=DriverManager.getConnection("jdbc:mysql://localhost/jdbcmenu","root","root");
			//System.out.println("Not connected!!");
		}
		catch(Exception e){
			System.out.println("error!!"+e);
		}
		do {
		System.out.println("Enter 1 to Insert:");
		System.out.println("Enter 2 to Delete:");
		System.out.println("Enter 3 to Update:");
		System.out.println("Enter 4 to View All:");
		System.out.println("Enter 5 to Search:");
		System.out.println("Enter 6 to order:");
		System.out.println("Enter 7 to exit:");
		System.out.println("Enter your choice:");
		ch=Integer.parseInt(sc.nextLine());
		switch(ch){
		case 1:
			System.out.println("Enter usn:");
			usn=sc.nextInt();
			System.out.println("Enter name:");
		    name=sc.nextLine();
			System.out.println("Marks:");
			marks=sc.nextInt();
			try {
	String s="Insert into studen values('"+usn+"','"+name+"','"+marks+"')";
	st=con.createStatement();
	st.executeUpdate(s);
	System.out.println("Row inserted");
			}
		catch(Exception e) {
			System.out.println("error2!"+e);
		}break;
		case 2:
			try {
				System.out.println(" Enter usn");
				String str=sc.nextLine();
				st=con.createStatement();
				int x=st.executeUpdate("delete from studen where usn="+"'"+str+"'");
				System.out.println("Deleted rows are:"+x);
		}
			catch(Exception e) {
				System.out.println("error3!"+e);
			}break;
		case 3:
			try {
				
			System.out.println("Enter usn to be updated");
			String usn1=sc.nextLine();
			String query="update studen set marks=95 where usn='"+usn1+"'";
			st=con.createStatement();
			int x=st.executeUpdate(query);
			System.out.println("Updated rows are:"+x);
			
			}catch(Exception e) {
				System.out.println("error4!"+e);
			}break;
		case 4:
				try {
					String query="select * from studen";
					st=con.createStatement();
					r=st.executeQuery(query);
					boolean rec=r.next();
					while(!rec)
					{
					System.out.println("No record");
					}
					do {
						usn=r.getInt(1);
						name=r.getString(2);
						marks=r.getInt(3);
						System.out.println(usn+"\t");
						System.out.println(name+"\t");
						System.out.println(marks);
					}
					while(r.next());
						st.close();
					    con.close();
				}
					catch(Exception e) {
						System.out.println("error5!"+e);
					}break;
			case 5:
				System.out.println("Enter usn");
				usn = sc.nextInt();
				try {
					st = con.createStatement();
					String query = "select * from studen where usn=" + usn + " ";
					r = st.executeQuery(query);
					{
						System.out.println(r.getInt(1));
						System.out.println(r.getString(2));
						System.out.println(r.getInt(3));
					}

					System.out.println("selected value:");

				} catch (Exception e) {
					System.out.println("error6!" + e);
				}
			
			case 6:
				try {
				st=con.createStatement();
			    r=st.executeQuery("select * from studen order by name ASC");
			//    r=st.executeQuery("select * from student order by name DESC");
				while(r.next()) {
					System.out.println("usn : "+r.getInt("usn"));
					System.out.println(", name : "+r.getString("name"));
					System.out.println(", marks : "+r.getInt("marks"));       
				}}
				catch(Exception e) {
					System.out.println("error! ");
				}
			              break;   
								
			case 7:
				System.exit(1);
				break;
				default:
					System.out.println("I am default");
		}
		System.out.println("Do you want to continue(yes/no)");
		String str=sc.nextLine();
		if(str.equals("yes")||str.equals("y"))
			flag=true;
		if(str.equals("no")||str.equals("no"))
			flag=false;
		}
		while(flag);
	}
}
