package com.kanhaiya.jdbc.advanced;

import java.sql.*;
import java.util.Scanner;

public class JdbcCRUD {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "yourpassword";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            while (true) {
                System.out.println("\n1. Insert");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                switch (ch) {

                    // INSERT
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter City: ");
                        String city = sc.next();

                        String insertSQL = "INSERT INTO students VALUES (?, ?, ?)";
                        PreparedStatement psInsert = con.prepareStatement(insertSQL);
                        psInsert.setInt(1, id);
                        psInsert.setString(2, name);
                        psInsert.setString(3, city);

                        int i = psInsert.executeUpdate();
                        System.out.println(i + " record inserted");
                        break;

                    // READ
                    case 2:
                        String selectSQL = "SELECT * FROM students";
                        PreparedStatement psSelect = con.prepareStatement(selectSQL);
                        ResultSet rs = psSelect.executeQuery();

                        System.out.println("ID | Name | City");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " | " +
                                    rs.getString(2) + " | " +
                                    rs.getString(3));
                        }
                        break;

                    // UPDATE
                    case 3:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        System.out.print("Enter new City: ");
                        String newCity = sc.next();

                        String updateSQL = "UPDATE students SET city=? WHERE id=?";
                        PreparedStatement psUpdate = con.prepareStatement(updateSQL);
                        psUpdate.setString(1, newCity);
                        psUpdate.setInt(2, uid);

                        int u = psUpdate.executeUpdate();
                        System.out.println(u + " record updated");
                        break;

                    // DELETE
                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();

                        String deleteSQL = "DELETE FROM students WHERE id=?";
                        PreparedStatement psDelete = con.prepareStatement(deleteSQL);
                        psDelete.setInt(1, did);

                        int d = psDelete.executeUpdate();
                        System.out.println(d + " record deleted");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
