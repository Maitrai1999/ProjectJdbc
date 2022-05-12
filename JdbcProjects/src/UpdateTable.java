import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class UpdateTable {
public static void main(String[] args) {
	// TODO Auto-generated method stub
      try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn=null;
        	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
            Statement stmt=conn.createStatement();
            String sql="UPDATE EMP SET lastname='Vadlapatla' WHERE eid=2";
            stmt.executeUpdate(sql);
            System.out.println("Updated record ");
}
      catch(Exception e) {
    	  e.printStackTrace();
      }
}
}