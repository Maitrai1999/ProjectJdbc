import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PreparedSelect {
public static void main(String[] args) {
	// TODO Auto-generated method stub
      try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn=null;
        	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
        	PreparedStatement stmt=conn.prepareStatement("SELECT * from emp ");
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
               	System.out.println("eid:"+rs.getInt(1));
               	System.out.println("firstname:"+rs.getString(2));
               	System.out.println("lastname:"+rs.getString(3));
               	System.out.println("age:"+rs.getInt(4));
               }
}
      catch(Exception e) {
    	  e.printStackTrace();
      }
}

}



