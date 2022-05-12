import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CommitInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	Connection conn=null;
            	conn=DriverManager.getConnection("jdbc:mysql://localhost/stud","root","root");
            	conn.setAutoCommit(false);
                Statement stmt=conn.createStatement();
               // String query="INSERT INTO stud(sid,scity) values(1,'AP')";
               String query1="INSERT INTO trainer(tid,sid,tname) values(5,5,'key')";
               // stmt.executeUpdate(query);
               stmt.executeUpdate(query1);
                conn.commit();
                System.out.println("Inserted records in given database...");
}
          catch(Exception e) {
        	  e.printStackTrace();
          }

}
}
