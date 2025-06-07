package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private static int counter = 1;
    private int id;
    private String name;
    private String email;
    private String department;
    private List<BorrowRecord> borrowHistory = new ArrayList<>();

    public Student(String name, String email, String department) {
        this.id = counter++;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public List<BorrowRecord> getBorrowHistory() {
        return borrowHistory;
    }

    public void addBorrowRecord(BorrowRecord record) {
        borrowHistory.add(record);
    }

    @Override
    public String toString() {
        return "ID:" + id + ", Name:" + name + ", Email:" + email + ", Dept:" + department;
    }
}
