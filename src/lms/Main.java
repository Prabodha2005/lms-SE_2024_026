package lms;

import lms.model.Book;
import lms.model.Member;
import lms.service.Library;
import lms.model.DVD;

public class Main {

    public static void main(String[] args) {

        // Create Library object
        Library library = new Library();

        // Create and add books
        library.addItem(new Book("B001", "Clean Code", "Robert C. Martin"));

        library.addItem(new Book("B002", "Effective Java", "Joshua Bloch"));

        library.addItem(new Book("B003", "The Pragmatic Programmer", "Hunt & Thomas"));

        library.addItem(new DVD("D001", "Introduction to Algorithms", 120));

        // Create and add members
        library.addMember(new Member("M001", "Nadeesha Perera",3));

        library.addMember(new Member("M002", "Kasun Silva",10));

        // Display books and members
        library.listItems();

        library.listMembers();

        // Test invalid book
        try {
            Book invalidBook = new Book("", "Nobody", "000-0000000000");
            library.addItem(invalidBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected invalid book: " + e.getMessage());
        }
    }
}
