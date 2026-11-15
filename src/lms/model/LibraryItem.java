package lms.model;

public abstract class LibraryItem implements Loanable {

    private String id;
    private String title;
    private boolean isBorrowed;

    // Constructor
    public LibraryItem(String id, String title) {
        setId(id);
        setTitle(title);
        this.isBorrowed = false;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Setters
    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be blank");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        this.title = title;
    }

    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    // Loan an item
    @Override
    public void loan(Member member) {

        if (isBorrowed) {
            System.out.println(title + " is already on loan.");
            return;
        }

        if (member.getBorrowedCount() >= member.getMaxBorrowLimit()) {
            System.out.println(member.getName() + " has reached the borrowing limit.");
            return;
        }

        setBorrowed(true);
        member.incrementBorrowedCount();

        System.out.println(title + " loaned to " + member.getName());
    }

    // Return an item
    @Override
    public void returnItem() {
        setBorrowed(false);
        System.out.println(title + " returned.");
    }

    // Abstract late fee calculation
    public abstract double calculateLateFee(int daysLate);

    // toString method
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", borrowed=" + isBorrowed +
                '}';
    }
}
