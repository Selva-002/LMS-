package service;

import java.util.ArrayList;
import java.util.List;

import models.Librarian;

public class LibrarianService {
    private List<Librarian> librarians = new ArrayList<>();

    public Librarian addLibrarian(String name, String email, String password) {
        Librarian librarian = new Librarian(name, email, password);
        librarians.add(librarian);
        return librarian;
    }

    public Librarian login(String email, String password) {
        for (Librarian lib : librarians) {
            if (lib.getEmail().equalsIgnoreCase(email) && lib.getPassword().equals(password)) {
                return lib;
            }
        }
        return null;
    }

    public void listLibrarians() {
        System.out.println("\n-- Librarian List --");
        if (librarians.isEmpty()) {
            System.out.println("No librarians found.");
            return;
        }
        for (Librarian lib : librarians) {
            System.out.println(lib);
        }
    }
}
