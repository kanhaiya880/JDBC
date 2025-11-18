package com.kanhaiya.jdbc.basic;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class BookInsert {


    public static void insertBook(Statement stmt) throws SQLException {

        Book book1 = new Book("7 Steps to Live Your Best Life", "Roxie Nafosi", 350.00);
        Book book2 = new Book("Atomic Habits", "James Clear", 420.00);
        Book book3 = new Book("The Alchemist", "Paulo Coelho", 299.00);
        Book book4 = new Book("Think and Grow Rich", "Napoleon Hill", 399.00);
        Book book5 = new Book("Deep Work", "Cal Newport", 450.00);
        Book book6 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 320.00);
        Book book7 = new Book("The Psychology of Money", "Morgan Housel", 380.00);
        Book book8 = new Book("Ikigai", "", 240.00);
        Book book9 = new Book("Mindset: The New Psychology of Success", "Carol Dweck", 410.00);
        Book book10 = new Book("Can not Hurt Me", "David Goggins", 460.00);

        ArrayList<Book> bookList= new ArrayList<>(Arrays.asList(book1,book2,book3,book4,book5,book6,book7,book8,book9,book10));
        int RecordCount=0;
        for (int i = 0; i < bookList.size(); i++) {

            int rowCount = stmt.executeUpdate( String.format("INSERT INTO book_records (name, author, price) VALUES ('%s','%s',%f)",
                    bookList.get(i).getName(),bookList.get(i).getAuthor(),bookList.get(i).getPrice()));

            RecordCount+=rowCount;

        }

        System.out.println(String.format("%d records added successfully",RecordCount));

    }
}
