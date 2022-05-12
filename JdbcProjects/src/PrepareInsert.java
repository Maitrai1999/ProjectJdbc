import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class PrepareInsert {
public static void main(String[] args) {
	// TODO Auto-generated method stub
     try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn=null;
        	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
            PreparedStatement stmt=conn.prepareStatement("insert into emp values(?,?,?,?)");
        	stmt.setInt(1,1);
        	stmt.setString(2,"maitrai");
        	stmt.setString(3,"tumulury");
        	stmt.setInt(4,23);
            int i=stmt.executeUpdate();
            System.out.println(i+"insert records in given database...");
      }    
      catch(Exception e) {
    	  e.printStackTrace();
      }
}
}
	
	

