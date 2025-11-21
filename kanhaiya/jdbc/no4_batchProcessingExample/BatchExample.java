package kanhaiya.jdbc.no4_batchProcessingExample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://127.0.0.1:3306/bank_batchprocess";
        String uname="root";
        String pass="root";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,uname,pass);
        con.setAutoCommit(false);
        Statement stmt= con.createStatement();

        try {

            stmt.addBatch("insert into bank_info values (1,'HDFC','karve nagar','HDFC11002')");
            stmt.addBatch("insert into bank_info values (2,'SBI','FC Road','SBI33002')");
            stmt.addBatch("insert into bank_info values (3,'Bank of Maharashtra','JM Road','MAHB00002')");

            int[] result=stmt.executeBatch();
            System.out.println(result.length+" Records inserted !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            stmt.close();
            System.out.print("finally block");
        }
    }

}
