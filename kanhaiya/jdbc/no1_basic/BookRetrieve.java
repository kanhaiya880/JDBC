package kanhaiya.jdbc.no1_basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRetrieve {

    public static void retrieveBook(Statement stmt) throws SQLException {

        int RecordCount=0;




        System.out.println("University Record are:");

        ResultSet rs=stmt.executeQuery("select * from book_records");

		while(rs.next())
		{
			System.out.println(String.format("%d | %s | %s | %d ",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			System.out.println("-------------------------------------------");
		}


    }

}
