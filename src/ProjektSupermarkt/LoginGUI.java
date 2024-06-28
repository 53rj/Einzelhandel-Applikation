package ProjektSupermarkt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginGUI extends JFrame implements ActionListener {

    private JTextField nameField;
    private JPasswordField passwordField;
    private JPanel loginPanel;
    private JButton loginButton, registerButton;
    private JTextArea textArea;
    private Login login;
    private int uid;

    public LoginGUI(String titel) {
        super(titel);
        loginPanel = new JPanel();
        login = new Login();
        this.add(loginPanel);

        nameField = new JTextField(10);
        loginPanel.add(nameField);

        passwordField = new JPasswordField(10);
        loginPanel.add(passwordField);

        registerButton = new JButton("Register");
        loginPanel.add(registerButton);
        registerButton.addActionListener(this);

        loginButton = new JButton("Login");
        loginPanel.add(loginButton);
        loginButton.addActionListener(this);

        textArea = new JTextArea(1, 20);
        textArea.setEditable(false); // To prevent editing
        loginPanel.add(textArea);

        this.setSize(300, 200);
        this.setVisible(true);
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = nameField.getText();
            char[] password = passwordField.getPassword();
            String hashedPassword = hashPassword(password);

            if (login.loginUser(username, hashedPassword) != -1) {
                uid = login.loginUser(username, hashedPassword);
                textArea.setText("Login successful for user: " + username);
            } else {
                textArea.setText("Login failed. Please try again.");
            }
            passwordField.setText(""); // Clear password field for security reasons
        } else if (e.getSource() == registerButton) {
            String username = nameField.getText();
            char[] password = passwordField.getPassword();
            String hashedPassword = hashPassword(password);

            login.registerUser(username, hashedPassword);
            passwordField.setText(""); // Clear password field for security reasons
        }
    }

    private static String hashPassword(char[] password) {
        try {
            byte[] passwordBytes = new String(password).getBytes(); // Convert the password char array to a byte array
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Create MessageDigest instance for SHA-256
            byte[] hashedBytes = md.digest(passwordBytes); // Add password bytes to digest
            StringBuilder hexString = new StringBuilder(); // Convert byte array into signum representation

            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString(); // Return the hashed password as a hexadecimal string
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Error hashing password", ex);
        }
    }
}
