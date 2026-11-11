package lms.service;

import lms.model.Book;
import lms.model.DVD;
import lms.model.LibraryItem;
import lms.model.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {

    // Store different types of library items
    private final List<LibraryItem> items = new ArrayList<>();

    // Store different types of members
    private final List<Member> members = new ArrayList<>();

    // Add library items
    public void addItem(LibraryItem item) {
        items.add(item);
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

    // Calculate and display late fees
    public void printAllLateFees(int daysLate) {
        for (LibraryItem item : items) {
            System.out.println(
                    item.getTitle() + " late fee: " +
                            item.calculateLateFee(daysLate)
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
