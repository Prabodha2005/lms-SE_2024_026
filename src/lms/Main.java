package lms;

import lms.model.Book;
import lms.model.DVD;
import lms.model.Magazine;
import lms.model.Student;
import lms.model.Staff;
import lms.service.Library;

public class Main {
    public static void main(String[] args) {

        // Create Library
        Library library = new Library();

        // Create library items
        Book book = new Book("B001", "Clean Code", "Robert C. Martin");

        DVD dvd = new DVD("D001", "Introduction to Algorithms", 120);

        Magazine magazine = new Magazine("M001", "Software Weekly", 101);

        // Add items
        library.addItem(book);
        library.addItem(dvd);
        library.addItem(magazine);

        // Create members
        Student student = new Student("S001", "Nadeesha Perera");

        Staff staff = new Staff("ST001", "Mr. Kasun Silva");

        // Add members
        library.addMember(student);
        library.addMember(staff);

        // Display late fees
        library.printAllLateFees(3);

        // Lending tests
        System.out.println("\n--- Loans ---");

        library.lend(book, student);

        // Try lending the same book again
        library.lend(book, staff);

        // Lend DVD and Magazine to staff
        library.lend(dvd, staff);
        library.lend(magazine, staff);

        // Reservation tests
        System.out.println("\n--- Reservations ---");

        library.reserveIfPossible(book, staff);
        library.reserveIfPossible(dvd, staff);

        library.printMembersByActivity();
    }
}
