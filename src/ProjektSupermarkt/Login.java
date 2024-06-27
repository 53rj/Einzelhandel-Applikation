package ProjektSupermarkt;

public class Login {
    private String username;
    private String hashedPassword;

    public Login() {

    }

    public int registerUser(String username, String hashedPassword) {
        DbQueryHandler dbQueryHandler = new DbQueryHandler();
        int result = dbQueryHandler.registerUser(this.getUsername(), this.gethashedPassword());
        return result;
    }

    public int loginUser(String username, String hashedPassword) {
        DbQueryHandler dbQueryHandler = new DbQueryHandler();
        int result = dbQueryHandler.loginUser(this.getUsername(), this.gethashedPassword());
        return result;
    }

    private String gethashedPassword() {
        return this.hashedPassword;
    }

    private void sethashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    private String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }
}
