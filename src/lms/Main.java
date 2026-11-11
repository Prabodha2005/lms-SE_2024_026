package lms;

import lms.model.Book;
import lms.model.Member;
import lms.service.Library;

public class Main {

    public static void main(String[] args) {

        // Create Library object
        Library library = new Library();

        // Create and add books
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0132350884"));

        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0134685991"));

        library.addBook(new Book("The Pragmatic Programmer", "Hunt & Thomas", "978-0135957059"));

        // Create and add members
        library.addMember(new Member("M001", "Nadeesha Perera",3));

        library.addMember(new Member("M002", "Kasun Silva",10));

        // Display books and members
        library.listBooks();

        library.listMembers();

        // Test invalid book
        try {
            Book invalidBook = new Book("", "Nobody", "000-0000000000");
            library.addBook(invalidBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected invalid book: " + e.getMessage());
        }
    }
}
