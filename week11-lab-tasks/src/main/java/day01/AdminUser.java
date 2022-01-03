package day01;

public class AdminUser implements User{
    private String userEmail;
    private String password;

    public AdminUser(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }

    @Override
    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String getPassword() {
        return "*".repeat(password.length());
    }
}
