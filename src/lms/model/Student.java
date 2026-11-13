package lms.model;

public class Student extends Member {

    private static final int MAX_BORROW_LIMIT = 3;

    public Student(String memberId, String name) {
        super(memberId, name, MAX_BORROW_LIMIT);
    }
}
