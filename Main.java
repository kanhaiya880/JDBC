import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String args[]) throws ClassNotFoundException,SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/bookdb";
        String uname="root";
        String upass="root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,upass);
        Statement stmt = con.createStatement();

        // BookInsert.insertBook(stmt);
        //BookRetrieve.retrieveBook(stmt);
        // BookUpdate.updateBook(1,350,stmt);
        //BookDelete.deleteBook(1,stmt);


    }
}
