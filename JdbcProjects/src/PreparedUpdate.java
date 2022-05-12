import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class PreparedUpdate {
public static void main(String[] args) {
	// TODO Auto-generated method stub
      try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn=null;
        	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
        	PreparedStatement stmt=conn.prepareStatement("Update emp SET firstname=? WHERE eid=?");
        	stmt.setString(1,"keerthi");
        	stmt.setInt(2,2);
            int i=stmt.executeUpdate();
            System.out.println(i+"UPDATED records");
            conn.close();
}
      catch(Exception e) {
    	  e.printStackTrace();
      }
}
}