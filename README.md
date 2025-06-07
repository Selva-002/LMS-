
📚 Java Console-Based Library Management System (LMS)

This is a simple **console-based Library Management System** developed in Java using object-oriented principles. 
It features **role-based access for students and librarians**, and supports student profiles, librarian login, book management, and borrowing history.


✨ Features

👩‍🎓 Student Portal

* Register with name, email, and department
* Login using name
* View own profile (ID, name, email, dept)
* Borrow and return books
* View borrowing history

🧑‍🏫 Librarian Portal

* Register/login using email and password
* View list of all students and librarians
* Add new books with multiple copies
* View all books available in the system


🛠️ Tech Stack

* Java SE (Standard Edition)
* Console-based Input/Output
* Java Collections (`HashMap`, `ArrayList`)
* Object-Oriented Programming

📂 Project Structure

├── app/
│   └── Main.java                # Main logic and menu system
├── models/
│   ├── Book.java                # Book model
│   ├── Librarian.java           # Librarian model
│   └── Student.java             # Student model
├── service/
│   ├── BookService.java         # Manage books (add, list, find)
│   ├── LibrarianService.java    # Manage librarians
│   └── StudentService.java      # Manage student profiles and borrowing\

📦 How to Run

1. **Clone or download** the repository.
2. Open in your **IDE** (e.g., IntelliJ, Eclipse) or compile using terminal:

   javac app/Main.java
   java app.Main

3. Follow the prompts:

   * Select your role (Student or Librarian)
   * Register or login
   * Access respective features

🧪 Sample Usage
👨‍🎓 Student
--- LMS Portal ---
1. Student
2. Librarian
3. Exit
Choose role: 1

--- Student Portal ---
1. Register
2. Login
3. Back to Main Menu

📚 Borrowing a Book

-- Student Menu --
1. View My Profile
2. Borrow Book
3. Return Book
4. View Borrowing History
5. Logout

🚧 Future Enhancements

* ✅ Due date system for borrowed books
* ✅ Borrow history with timestamp
* ⏳ Overdue penalties
* ⏳ Persistent storage using files or a database
* ⏳ Search/filter books
* ⏳ Admin role for system management

👨‍💻 Author

**SelvaNayaki**
*B.Tech IT Student | Java Developer*

