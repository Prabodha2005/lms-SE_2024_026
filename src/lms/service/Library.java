package lms.service;

import lms.model.Book;
import lms.model.DVD;
import lms.model.LibraryItem;
import lms.model.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    // Method overloading
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("Added via addItem(LibraryItem): " + item.getTitle());
    }

    public void addItem(Book book) {
        items.add(book);
        System.out.println("Added via addItem(Book): " + book.getTitle());
    }

    public void addItem(DVD dvd) {
        items.add(dvd);
        System.out.println("Added via addItem(DVD): " + dvd.getTitle());
    }

    // Display all library items
    public void listItems() {
        System.out.println("--- Library items ---");

        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    // Add members
    public void addMember(Member member) {
        members.add(member);
    }

    // Display all members
    public void listMembers() {
        System.out.println("--- Registered members ---");

        for (Member member : members) {
            System.out.println(member);
        }
    }

    // Calculate late fees
    public void printAllLateFees(int daysLate) {
        for (LibraryItem item : items) {
            System.out.println(
                    item.getTitle() + " late fee: " +
                            item.calculateLateFee(daysLate)
            );
        }
    }

    // Stream DVD if possible
    public void streamIfPossible(LibraryItem item) {

        if (item instanceof DVD dvd) {
            System.out.println(
                    "Streaming \"" + dvd.getTitle() +
                            "\" (" + dvd.getDurationMinutes() + " min)..."
            );
        } else {
            System.out.println(
                    item.getTitle() +
                            " cannot be streamed - it isn't a DVD."
            );
        }
    }

    // Get items
    public List<LibraryItem> getItems() {
        return items;
    }

    // Get members
    public List<Member> getMembers() {
        return members;
    }
}
