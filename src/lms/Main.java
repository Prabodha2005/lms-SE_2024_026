package lms;

import lms.model.Book;
import lms.model.DVD;
import lms.model.Student;
import lms.model.Staff;
import lms.service.Library;

public class Main {

    public static void main(String[] args) {

        // Create Library object
        Library library = new Library();

        // Create Book objects
        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");
        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");

        // Create DVD object
        DVD d1 = new DVD("D001", "Introduction to Algorithms", 120);

        // Add items to the library (Method Overloading)
        library.addItem(b1);
        library.addItem(b2);
        library.addItem(d1);

        // Create Student and Staff objects
        Student s1 = new Student("M001", "Nadeesha Perera");
        Staff st1 = new Staff("M002", "Kasun Silva");

        // Add members to the library
        library.addMember(s1);
        library.addMember(st1);

        // Display all library items
        library.listItems();

        // Display all members
        library.listMembers();

        // Calculate late fees for 3 days
        System.out.println("\n--- Late Fee Calculation ---");
        library.printAllLateFees(3);

        // Test DVD streaming
        System.out.println("\n--- Streaming Test ---");
        library.streamIfPossible(d1);
        library.streamIfPossible(b1);

        // Test exception handling
        System.out.println("\n--- Exception Handling Test ---");

        try {
            Book invalidBook = new Book("", "Nobody", "Unknown");
            library.addItem(invalidBook);

        } catch (IllegalArgumentException e) {
            System.out.println("Rejected invalid book: " + e.getMessage());
        }
    }
}
