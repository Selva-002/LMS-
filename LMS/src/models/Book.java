package models;

public class Book {
    private static int counter = 1;
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int totalCopies;
    private int availableCopies;

    public Book(String title, String author, String publisher, int totalCopies) {
        this.id = counter++;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", Title:" + title + ", Author:" + author + ", Publisher:" + publisher
                + ", Available Copies:" + availableCopies;
    }
}
