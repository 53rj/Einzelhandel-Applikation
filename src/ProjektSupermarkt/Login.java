package ProjektSupermarkt;

public class Login {
    private DbQueryHandler dbQueryHandler;

    public Login() {
        dbQueryHandler = new DbQueryHandler();
    }

    public void registerUser(String username, String hashedPassword) {
        dbQueryHandler.registerUser(username, hashedPassword);

    }

    public int loginUser(String username, String hashedPassword) {
        return dbQueryHandler.loginUser(username, hashedPassword);
    }
}
