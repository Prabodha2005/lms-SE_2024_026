package lms.model;

public class Book extends LibraryItem implements Reservable {

    private String author;
    private Member reservedBy;

    public Book(String id, String title, String author) {
        super(id, title);
        setAuthor(author);
        this.reservedBy = null;
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public Member getReservedBy() {
        return reservedBy;
    }

    // Setter
    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be blank");
        }
        this.author = author;
    }

    // Late fee calculation
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 10.0;
    }

    // Reserve book
    @Override
    public void reserve(Member member) {
        if (reservedBy != null) {
            System.out.println(getTitle() + " is already reserved.");
            return;
        }

        reservedBy = member;

        System.out.println(
                getTitle() + " reserved for " + member.getName()
        );
    }

    // Cancel reservation
    @Override
    public void cancelReservation() {
        reservedBy = null;
        System.out.println(getTitle() + " reservation cancelled.");
    }

    // Check reservation
    @Override
    public boolean isReserved() {
        return reservedBy != null;
    }
}
