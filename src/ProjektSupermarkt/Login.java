package ProjektSupermarkt;

public class Login {
    private String username;
    private String hashedPassword;

    public Login() {

    }

    public void registerUser(String username, String hashedPassword) {
        DbQueryHandler dbQueryHandler = new DbQueryHandler();
        dbQueryHandler.registerUser(username, hashedPassword);

    }

    public int loginUser(String username, String hashedPassword) {
        DbQueryHandler dbQueryHandler = new DbQueryHandler();
        int result = dbQueryHandler.loginUser(username, hashedPassword);
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
