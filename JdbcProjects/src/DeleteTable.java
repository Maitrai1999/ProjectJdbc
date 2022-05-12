import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DeleteTable {
public static void main(String[] args) {
	// TODO Auto-generated method stub
      try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn=null;
        	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
            Statement stmt=conn.createStatement();
            String query="DELETE from EMP WHERE eid=1";
            stmt.executeUpdate(query);
            System.out.println("Deleted records in given Table...");
}
      catch(Exception e) {
    	  e.printStackTrace();
      }
}
}