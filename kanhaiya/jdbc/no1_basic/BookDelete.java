package kanhaiya.jdbc.no1_basic;

import java.sql.SQLException;
import java.sql.Statement;

public class BookDelete {

    public static void deleteBook(int id,Statement stmt) throws SQLException {

        int RecordCount=0;

        int rowCount = stmt.executeUpdate( String.format("Delete From book_records WHERE id=%d",id));

        RecordCount+=rowCount;


        System.out.println(String.format("%d records added successfully",RecordCount));

    }
}
