public class Email {

    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(password) && isValidPassword(newPassword)) {
            this.password = newPassword;
            System.out.println("Password changed successfully");
        } else {
            System.out.println("Password change failed");
        }
    }

    private boolean isValidPassword(String password) {
        // Check password conditions
        // 1. At least 8 characters
        // 2. At least one uppercase letter
        // 3. At least one lowercase letter
        // 4. At least one digit
        // 5. At least one special character
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
                && password.matches(".*\\d.*") && password.matches(".*[^a-zA-Z0-9].*");
    }
}
