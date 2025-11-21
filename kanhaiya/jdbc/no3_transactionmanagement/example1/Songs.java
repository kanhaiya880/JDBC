package kanhaiya.jdbc.no3_transactionmanagement.example1;
/*
This is the program related to transaction management
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Songs {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://localhost:3306/songsdata";
        String uname="root";
        String pass="root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        try {

        con.setAutoCommit(false); /// auto commit setting false
        Statement stmt = con.createStatement();
        int r1=stmt.executeUpdate("insert into song_info values(101,'Mere Nasiba me','Lata Mangeshkar','Naseeb')");
        int r2=stmt.executeUpdate("insert into song_info values(202,'Raata Lambiyan','jubin','shersha')");
        int r3=stmt.executeUpdate("insert into song_info values(303,'Apna banale','Arjit singh','bhediya')");
        int r4=stmt.executeUpdate("insert into song_info values(404,'Pehla Nasha','Udit naryan','bhediya')");
       con.commit();
        System.out.println((r1+r2+r3+r4)+" record Inserted........!");
        } catch (Exception exp)
        {
            exp.printStackTrace();
            con.rollback();
            System.out.println("Rolling back the trasaction ");
        }
        finally {
            con.close();
        }
    }
}
