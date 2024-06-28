package ProjektSupermarkt;

public class Login {

    public Login() {

    }

    public void registerUser(String username, String hashedPassword) {
        DbQueryHandler dbQueryHandler = new DbQueryHandler();
        dbQueryHandler.registerUser(username, hashedPassword);

    }

    public int loginUser(String username, String hashedPassword) {
        DbQueryHandler dbQueryHandler = new DbQueryHandler();
        return dbQueryHandler.loginUser(username, hashedPassword);
    }
}
