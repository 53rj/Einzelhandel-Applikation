package ProjektSupermarkt;

public class Login {
    private DbQueryHandler dbQueryHandler;
    private int uid;

    public Login() {
        dbQueryHandler = new DbQueryHandler();
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return this.uid;
    }

    public void registerUser(String username, String hashedPassword) {
        dbQueryHandler.registerUser(username, hashedPassword);
    }

    public int loginUser(String username, String hashedPassword) {
        uid = dbQueryHandler.loginUser(username, hashedPassword);
        return uid;
    }

    public void logoutUser() {
        this.setUid(0);
    }
}
