package lms;

import lms.exception.ItemNotAvailableException;
import lms.exception.MemberNotFoundException;
import lms.model.Book;
import lms.model.DVD;
import lms.model.Magazine;
import lms.model.LibraryItem;
import lms.model.Student;
import lms.model.Staff;
import lms.service.Library;

public class Main {

    // Attempt to borrow an item
    public static void attempt(Library library, String itemId, String memberId) {

        try {
            library.borrowItem(itemId, memberId);

        } catch (ItemNotAvailableException e) {
            System.out.println("Cannot borrow: " + e.getMessage());

        } catch (MemberNotFoundException e) {
            System.out.println("Unknown member: " + e.getMemberId());

        } finally {
            System.out.println(
                    "    (attempt finished: item " + itemId +
                            ", member " + memberId + ")"
            );
        }
    }

    public static void main(String[] args) {

        // Create Library
        Library library = new Library();

        // Create library items
        Book book = new Book("B001", "Clean Code", "Robert C. Martin");
        DVD dvd = new DVD("D001", "Introduction to Algorithms", 120);
        Magazine magazine = new Magazine("M001", "Software Weekly", 101);
        Book book2 = new Book("B002", "Effective Java", "Joshua Bloch");
        Book book3 = new Book("B003", "Java Programming", "Someone");
        Book book4 = new Book("B004", "Head First Java", "Kathy Sierra");

        // Add items
        library.addItem(book);
        library.addItem(dvd);
        library.addItem(magazine);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);

        // Create members
        Student student = new Student("M001", "Nadeesha Perera");
        Staff staff = new Staff("M002", "Mr. Kasun Silva");

        // Add members
        library.addMember(student);
        library.addMember(staff);

        // Display late fees
        library.printAllLateFees(3);

        // 1. Successful borrowing
        System.out.println("\n--- 1. Successful borrowing ---");
        attempt(library, "B001", "M001");

        // 2. Already on loan
        System.out.println("\n--- 2. Already on loan (checked exception) ---");
        attempt(library, "B001", "M002");

        // 3. Unknown member
        System.out.println("\n--- 3. Unknown member (unchecked exception) ---");
        attempt(library, "D001", "M999");

        // 4. Unknown item
        System.out.println("\n--- 4. Unknown item ---");
        attempt(library, "X404", "M001");

        // 5. Returning something not on loan
        System.out.println("\n--- 5. Returning something not on loan ---");

        try {
            library.returnItem("D001");

        } catch (ItemNotAvailableException e) {
            System.out.println("Cannot return: " + e.getMessage());
        }

        // 6. Bad data
        System.out.println("\n--- 6. Bad data (IllegalArgumentException) ---");

        try {
            Book invalidBook = new Book("B007", " ", "Someone");
            library.addItem(invalidBook);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid book: " + e.getMessage());
        }

        // 7. Student borrowing limit
        System.out.println("\n--- 7. Student borrowing limit ---");

        attempt(library, "D001", "M001");
        attempt(library, "M001", "M001");
        attempt(library, "B002", "M001");
        attempt(library, "B003", "M001");

        // 8. Return frees a slot
        System.out.println("\n--- 8. Return frees a slot ---");

        try {
            library.returnItem("B001");
            attempt(library, "B004", "M001");

        } catch (ItemNotAvailableException e) {
            System.out.println("Cannot return: " + e.getMessage());
        }

        // Display members ranked by activity
        library.printMembersByActivity();
    }
}
