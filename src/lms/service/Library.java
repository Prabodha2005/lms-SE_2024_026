package lms.service;

import lms.model.Book;
import lms.model.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {

    // Lists to store books and members
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Add a member
    public void addMember(Member member) {
        members.add(member);
    }

    // Display all books
    public void listBooks() {
        System.out.println("--- Books in the library ---");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Display all members
    public void listMembers() {
        System.out.println("--- Registered members ---");

        for (Member member : members) {
            System.out.println(member);
        }
    }

    // Get books list
    public List<Book> getBooks() {
        return books;
    }

    // Get members list
    public List<Member> getMembers() {
        return members;
    }
}
