package service;

import java.util.ArrayList;
import java.util.List;
import models.Book;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public Book addBook(String title, String author, String publisher, int copies) {
        Book book = new Book(title, author, publisher, copies);
        books.add(book);
        return book;
    }

    public void listBooks() {
        System.out.println("\n-- Book List --");
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
