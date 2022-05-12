import java.sql.DriverManager;
public class Connection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	java.sql.Connection conn=null;
            	conn=DriverManager.getConnection("jdbc:mysql://localhost/stud","root","root");
            	System.out.print("database is connected!");
            	conn.close();
}
          catch(Exception e) {
        	  System.out.print("do not connect to db - Error:"+e);
          }
	}

}