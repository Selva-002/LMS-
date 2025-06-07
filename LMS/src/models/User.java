package models;

public class User {

    private String Username;
    private String Password;
    private String role;

    public User(String Username, String Password, String role) {
        this.Username = Username;
        this.Password = Password;
        this.role = role;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getRole() {
        return role;
    }

}
