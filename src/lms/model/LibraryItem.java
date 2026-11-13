package lms.model;

public class LibraryItem {

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

    // Calculate late fee
    public double calculateLateFee(int daysLate) {
        return daysLate * 10.0;
    }

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
