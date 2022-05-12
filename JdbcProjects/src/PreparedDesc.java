import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PreparedDesc {
public static void main(String[] args) {
	// TODO Auto-generated method stub
      try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn=null;
        	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
        	PreparedStatement stmt=conn.prepareStatement("SELECT * from emp ORDER BY lastname DESC");
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
               	System.out.println("eid:"+rs.getInt("eid"));
               	System.out.println("firstname:"+rs.getString("firstname"));
               	System.out.println("lastname:"+rs.getString("lastname"));
               	System.out.println("age:"+rs.getInt("age"));
               }
}
      catch(Exception e) {
    	  e.printStackTrace();
      }
}
}