import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class PreparedDelete {
public static void main(String[] args) {
	// TODO Auto-generated method stub
      try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn=null;
        	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
        	PreparedStatement stmt=conn.prepareStatement("delete from emp WHERE eid=?");
        	stmt.setInt(1,1);
            int i=stmt.executeUpdate();
            System.out.println(i+" deleted records");
            conn.close();
}
      catch(Exception e) {
    	  e.printStackTrace();
      }
}
}