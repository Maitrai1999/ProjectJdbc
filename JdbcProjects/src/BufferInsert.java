import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class BufferInsert {
public static void main(String[] args) throws Exception{
	// TODO Auto-generated method stub
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost/splprj1","root","root");
    PreparedStatement ps=conn.prepareStatement("insert into Emp values(?,?,?,?)");  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
    do{  
    	System.out.println("Enter eid:");  
    	int eid=Integer.parseInt(br.readLine());  
    	System.out.println("Enter Firstname:");  
        String Firstname=br.readLine();  
    	System.out.println("Enter Lastname:");  
        String Lastname=br.readLine();
    	System.out.println("Enter Age");  
        int Age=Integer.parseInt(br.readLine());
        ps.setInt(1,eid);  
    	ps.setString(2,Firstname);  
    	ps.setString(3,Lastname); 
    	ps.setInt(4,Age); 
        int i=ps.executeUpdate();  
        System.out.println(i+" records inserted");  
        System.out.println("Do you want to continue: y/n");  
        String s=br.readLine();  
 	if(s.startsWith("n")){  
    	break;  
}  
}while(true);  

conn.close();  

}

}