package app;

import java.util.Scanner;

import models.Book;
import models.Librarian;
import models.Student;
import service.BookService;
import service.LibrarianService;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        LibrarianService librarianService = new LibrarianService();
        BookService bookService = new BookService();

        // Preload one student for testing
        studentService.addStudent("Selva", "selva@gmail.com", "CSE");

        while (true) {
            System.out.println("\n--- LMS Portal ---");
            System.out.println("1. Student");
            System.out.println("2. Librarian");
            System.out.println("3. Exit");
            System.out.print("Choose role: ");
            String roleChoice = sc.nextLine();

            switch (roleChoice) {
                case "1":
                    handleStudentMenu(sc, studentService, bookService);
                    break;

                case "2":
                    handleLibrarianEntry(sc, librarianService, studentService, bookService);
                    break;

                case "3":
                    System.out.println("Exiting LMS. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleLibrarianEntry(Scanner sc, LibrarianService librarianService,
            StudentService studentService, BookService bookService) {
        while (true) {
            System.out.println("\n-- Librarian Portal --");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n-- Register Librarian --");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    Librarian newLib = librarianService.addLibrarian(name, email, password);
                    System.out.println("Librarian registered successfully. Your ID: " + newLib.getId());
                    break;

                case "2":
                    System.out.print("\nEnter librarian email: ");
                    String loginEmail = sc.nextLine();
                    System.out.print("Enter password: ");
                    String loginPass = sc.nextLine();

                    Librarian loggedInLib = librarianService.login(loginEmail, loginPass);
                    if (loggedInLib != null) {
                        System.out.println("Login successful. Welcome, " + loggedInLib.getName() + "!");
                        handleLibrarianMenu(sc, studentService, librarianService, bookService);
                    } else {
                        System.out.println("Invalid librarian credentials.");
                    }
                    break;

                case "3":
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleStudentMenu(Scanner sc, StudentService studentService, BookService bookService) {
        while (true) {
            System.out.println("\n--- Student Portal ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n-- Register Student --");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();

                    Student newStudent = studentService.addStudent(name, email, dept);
                    System.out.println("Student registered successfully. Your ID: " + newStudent.getId());
                    break;

                case "2":
                    System.out.print("\nEnter your name to login: ");
                    String loginName = sc.nextLine();
                    Student loggedInStudent = studentService.login(loginName);

                    if (loggedInStudent != null) {
                        System.out.println("Login successful. Welcome, " + loggedInStudent.getName() + "!");
                        boolean inMenu = true;
                        while (inMenu) {
                            System.out.println("\n-- Student Menu --");
                            System.out.println("1. View My Profile");
                            System.out.println("2. Borrow Book");
                            System.out.println("3. Return Book");
                            System.out.println("4. View Borrowing History");
                            System.out.println("5. Logout");
                            System.out.print("Enter your choice: ");
                            String menuChoice = sc.nextLine();

                            switch (menuChoice) {
                                case "1":
                                    studentService.viewProfile(loggedInStudent);
                                    break;
                                case "2":
                                    System.out.print("Enter book title to borrow: ");
                                    String borrowTitle = sc.nextLine();
                                    Book bookToBorrow = bookService.findBookByTitle(borrowTitle);
                                    if (bookToBorrow != null) {
                                        studentService.borrowBook(loggedInStudent, bookToBorrow);
                                    } else {
                                        System.out.println("Book not found.");
                                    }
                                    break;
                                case "3":
                                    System.out.print("Enter book title to return: ");
                                    String returnTitle = sc.nextLine();
                                    studentService.returnBook(loggedInStudent, returnTitle);
                                    break;
                                case "4":
                                    studentService.showBorrowHistory(loggedInStudent);
                                    break;
                                case "5":
                                    inMenu = false;
                                    System.out.println("Logged out.");
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                        }
                    } else {
                        System.out.println("Login failed. Student not found.");
                    }
                    break;

                case "3":
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleLibrarianMenu(Scanner sc, StudentService studentService,
            LibrarianService librarianService, BookService bookService) {
        boolean inLibrarianMenu = true;

        while (inLibrarianMenu) {
            System.out.println("\n-- Librarian Menu --");
            System.out.println("1. View All Students");
            System.out.println("2. View All Librarians");
            System.out.println("3. Add Book");
            System.out.println("4. View All Books");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            String libChoice = sc.nextLine();

            switch (libChoice) {
                case "1":
                    studentService.listStudents();
                    break;
                case "2":
                    librarianService.listLibrarians();
                    break;
                case "3":
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = sc.nextLine();
                    System.out.print("Enter number of copies: ");
                    int copies;
                    try {
                        copies = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number for copies.");
                        break;
                    }

                    Book newBook = bookService.addBook(title, author, publisher, copies);
                    System.out.println("Book added successfully with ID: " + newBook.getId());
                    break;
                case "4":
                    bookService.listBooks();
                    break;
                case "5":
                    inLibrarianMenu = false;
                    System.out.println("Librarian logged out.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
