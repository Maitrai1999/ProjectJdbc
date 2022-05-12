import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class InsertTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	Connection conn=null;
            	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
                Statement stmt=conn.createStatement();
               // String query="INSERT INTO EMP values(1,'Maitrai','Tumulury',23)";
                String query1="INSERT INTO EMP values(2,'Yamini','Keerthi',22)";
                String query2="INSERT INTO EMP values(3,'Irfana','Nisha',22)";
               // stmt.executeUpdate(query);
                stmt.executeUpdate(query1);
                stmt.executeUpdate(query2);
                System.out.println("Inserted records in given database...");
}
          catch(Exception e) {
        	  e.printStackTrace();
          }
	}
}
