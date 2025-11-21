package kanhaiya.jdbc.no1_basic;

import java.sql.SQLException;
import java.sql.Statement;

public class BookUpdate {

    public static void updateBook(int id,int values,Statement stmt) throws SQLException {

        int RecordCount=0;

        int rowCount = stmt.executeUpdate( String.format("UPDATE book_records SET price=%d WHERE id=%d",values,id));

        RecordCount+=rowCount;


        System.out.println(String.format("%d records added successfully",RecordCount));

    }
}
