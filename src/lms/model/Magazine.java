package lms.model;

public class Magazine extends LibraryItem {

    private int issueNumber;

    // Constructor
    public Magazine(String id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    // Getter
    public int getIssueNumber() {
        return issueNumber;
    }

    // Late fee calculation
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 5.0;
    }
}
