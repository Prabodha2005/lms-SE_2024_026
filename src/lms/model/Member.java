package lms.model;

public class Member {

    private String memberId;
    private String name;
    private int borrowedCount;
    private int maxBorrowLimit;

    // Constructor
    public Member(String memberId, String name, int maxBorrowLimit) {
        setMemberId(memberId);
        setName(name);
        setMaxBorrowLimit(maxBorrowLimit);
        this.borrowedCount = 0;
    }

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }

    // Setters
    public void setMemberId(String memberId) {
        if (memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException("Member ID cannot be blank");
        }
        this.memberId = memberId;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
    }

    public void setBorrowedCount(int borrowedCount) {
        if (borrowedCount < 0) {
            throw new IllegalArgumentException("Borrowed count cannot be negative");
        }
        this.borrowedCount = borrowedCount;
    }

    public void setMaxBorrowLimit(int maxBorrowLimit) {
        if (maxBorrowLimit <= 0) {
            throw new IllegalArgumentException("Borrow limit must be positive");
        }
        this.maxBorrowLimit = maxBorrowLimit;
    }

    // Increment borrowed count
    public void incrementBorrowedCount() {
        setBorrowedCount(this.borrowedCount + 1);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", borrowedCount=" + borrowedCount +
                ", maxBorrowLimit=" + maxBorrowLimit +
                '}';
    }

}
