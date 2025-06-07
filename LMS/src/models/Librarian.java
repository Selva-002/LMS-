package models;

public class Librarian {
    private static int counter = 1;
    private int id;
    private String name;
    private String email;
    private String password;

    public Librarian(String name, String email, String password) {
        this.id = counter++;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", Name:" + name + ", Email:" + email;
    }
}
