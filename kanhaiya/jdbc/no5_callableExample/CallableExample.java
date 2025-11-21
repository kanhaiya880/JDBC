package kanhaiya.jdbc.no5_callableExample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableExample {
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/employee_ccsp";
		String uname="root";
		String pass="root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,uname,pass);
		
//		CallableStatement cstmt=conn.prepareCall("{call getEmployeeNamebyId(?,?)}");
//
//		cstmt.setInt(1, 3);
//		cstmt.registerOutParameter(2,Types.VARCHAR);
//		cstmt.execute();
//		String name=cstmt.getString(2);
//		System.out.println("Good Morning - "+name);

		CallableStatement cstmt=conn.prepareCall("{call getEmployeeDetailsbyId(?,?,?,?,?,?)}");

		cstmt.setInt(1, 3);
		cstmt.registerOutParameter(2,Types.INTEGER);
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.INTEGER);
		cstmt.execute();
		int id=cstmt.getInt(2);
		String name=cstmt.getString(3);
		String address=cstmt.getString(4);
		String dept=cstmt.getString(5);
		int salary =cstmt.getInt(6);
		System.out.println(String.format("%d %s %s %s %d",id,name,address,dept,salary));
		
	}

}
