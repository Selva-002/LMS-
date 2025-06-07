package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Book;
import models.BorrowRecord;
import models.Student;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public Student addStudent(String name, String email, String department) {
        Student student = new Student(name, email, department);
        students.add(student);
        return student;
    }

    public Student login(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void listStudents() {
        System.out.println("\n-- Student List --");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void viewProfile(Student student) {
        System.out.println("\n-- Student Profile --");
        System.out.println(student);
    }

    public void borrowBook(Student student, Book book) {
        if (book.getAvailableCopies() <= 0) {
            System.out.println("No copies available for this book.");
            return;
        }

        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(14);

        BorrowRecord record = new BorrowRecord(book, today, dueDate);
        student.addBorrowRecord(record);
        book.setAvailableCopies(book.getAvailableCopies() - 1);

        System.out.println("Book borrowed successfully! Due date: " + dueDate);
    }

    public void returnBook(Student student, String bookTitle) {
        for (BorrowRecord record : student.getBorrowHistory()) {
            if (record.getBook().getTitle().equalsIgnoreCase(bookTitle) && !record.isReturned()) {
                record.setReturned(true);
                record.getBook().setAvailableCopies(record.getBook().getAvailableCopies() + 1);
                System.out.println("Book returned successfully.");
                if (LocalDate.now().isAfter(record.getDueDate())) {
                    System.out.println("Returned late! Due date was: " + record.getDueDate());
                }
                return;
            }
        }
        System.out.println("You haven't borrowed this book or it's already returned.");
    }

    public void showBorrowHistory(Student student) {
        System.out.println("\n--- Borrowing History ---");
        if (student.getBorrowHistory().isEmpty()) {
            System.out.println("No borrowing records.");
            return;
        }
        for (BorrowRecord record : student.getBorrowHistory()) {
            System.out.println("Title: " + record.getBook().getTitle());
            System.out.println("Borrowed On: " + record.getBorrowDate());
            System.out.println("Due Date: " + record.getDueDate());
            System.out.println("Status: " + (record.isReturned() ? "Returned" : "Not Returned"));
            System.out.println("----------------------------");
        }
    }
}
