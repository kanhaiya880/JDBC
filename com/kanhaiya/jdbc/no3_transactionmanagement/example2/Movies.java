package com.kanhaiya.jdbc.no3_transactionmanagement.example2;
/*
This is the program related to transaction management
 */
import java.sql.*;


public class Movies {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://localhost:3306/moviesdb";
        String uname="root";
        String pass="root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        try {

            con.setAutoCommit(false); /// auto commit setting false
            Statement stmt = con.createStatement();
            MovieInfo m1  = new MovieInfo(1, "Inception", "Sci-Fi", 148, 8.8);
            MovieInfo m2  = new MovieInfo(2, "The Dark Knight", "Action", 152, 9.0);
            MovieInfo m3  = new MovieInfo(3, "Interstellar", "Sci-Fi", 169, 8.6);
            MovieInfo m4  = new MovieInfo(4, "Avatar", "Fantasy", 162, 7.8);
            MovieInfo m5  = new MovieInfo(5, "Titanic", "Romance", 195, 7.9);
            String sql= "INSERT INTO movie_info (id,title,genre,duration,rating) values(?,?,?,?,?)";
           PreparedStatement pstmt=con.prepareStatement(sql);
            // Insert all records using same PreparedStatement
            int r1 = insertMovie(pstmt, m1);
            int r2 = insertMovie(pstmt, m2);
            int r3 = insertMovie(pstmt, m3);
            int r4 = insertMovie(pstmt, m4);
            int r5 = insertMovie(pstmt, m5);

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

    public static int insertMovie(PreparedStatement pstmt,MovieInfo movie) throws SQLException {
        pstmt.setInt(1, movie.getId());
        pstmt.setString(2, movie.getTitle());
        pstmt.setString(3, movie.getGenre());
        pstmt.setInt(4, movie.getDuration());
        pstmt.setDouble(5, movie.getRating());
        return pstmt.executeUpdate();
    }
}


